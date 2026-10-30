package net.yteron.island;

import net.yteron.island.animal.Animal;
import net.yteron.island.animal.carnivore.*;
import net.yteron.island.animal.herbivore.*;
import net.yteron.island.server.Island;
import net.yteron.island.server.Location;
import net.yteron.island.server.Loger;
import net.yteron.island.server.command.Init;
import net.yteron.island.server.render.Render;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int ticks =21;
        long timeToUpdate =500;

        Island island = new Island(100, 20);
        Init.spawnAnimal(island, 10, Duck.class);
        Init.spawnAnimal(island, 10, Rabbit.class);
        Init.spawnAnimal(island, 10, Caterpillar.class);
        Init.spawnAnimal(island, 10, Horse.class);
        Init.spawnAnimal(island, 10, Deer.class);
        Init.spawnAnimal(island, 10, Boar.class);
        Init.spawnAnimal(island, 10, Goat.class);
        Init.spawnAnimal(island, 10, Mouse.class);

        Init.spawnAnimal(island, 10, Wolf.class);
        Init.spawnAnimal(island, 10, Fox.class);
        Init.spawnAnimal(island, 10, Bear.class);
        Init.spawnAnimal(island, 10, Eagle.class);
        Init.spawnAnimal(island, 10, Snake.class);


        for (Class<? extends Animal> clazz : Animal.getAll()) {
            Loger.log(clazz.getSimpleName());
        }
        for (int t = 0; t < ticks; t++) {
            System.out.println("Tick " + t);
            Render.render(island);

            List<String> events = new ArrayList<>();

            island.forEachLocation(Location::tick);
            island.forEachLocation(loc -> {
                for (Animal a : new ArrayList<>(loc.getAnimals())) {
                    if (a.isDead()) {
                        events.add(a.getClass().getSimpleName() + " голод");
                        loc.removeAnimals(a);
                        continue;
                    }
                    a.eat(loc);
                    a.move(loc, island);
                    if (!a.age()) {
                        events.add(a.getClass().getSimpleName() + " умер от старости");
                        loc.removeAnimals(a);
                        continue;
                    }
                    Animal child = a.tryBreed(loc);
                    if (child != null) {
                        events.add(a.getClass().getSimpleName()
                                + " размножился -> " + child.getClass().getSimpleName());
                    }
                }
            });

            events.forEach(Loger::log);
            Thread.sleep(timeToUpdate);
        }
        Loger.shutdown();
    }

}