package net.yteron.island;

import net.yteron.island.animal.Animal;
import net.yteron.island.animal.herbivore.Duck;
import net.yteron.island.server.Island;
import net.yteron.island.server.Location;
import net.yteron.island.server.render.Render;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        int ticks =21;
        long timeToUpdate =500;
        Island island = new Island(20, 10);
        spawnDucks(island, 10);
        for (int t = 0; t < ticks; t++) {
            clearScreen();
            System.out.println("Tick " + t);
            Render.render(island);

            // один шаг симуляции: каждый Location тикает
            island.forEachLocation(Location::tick);
            // плюс можно двигать животных здесь
            island.forEachLocation(loc -> {
                // копия списка — чтобы безопасно удалять/добавлять
                for (Animal a : new ArrayList<>(loc.getAnimals())) {
                    if (a.isDead()) {
                        loc.removeAnimals(a);
                        continue;
                    }
                    a.eat(loc);
                    a.move(loc, island);
                    a.age();
                }
            });
            Thread.sleep(timeToUpdate);
        }
    }
    private static void clearScreen() {
        // ANSI: очистить экран и вернуть курсор в левый верхний угол
        System.out.print("\u001B[2J\u001B[H");
        System.out.flush();
    }
    private static void spawnDucks(Island island, int count) {
        int placed = 0;
        int attempts = 0;
        int maxAttempts = count * 100;

        while (placed < count && attempts++ < maxAttempts) {
            int x = ThreadLocalRandom.current().nextInt(island.getWidth());
            int y = ThreadLocalRandom.current().nextInt(island.getHeight());
            Location loc = island.getLocation(x, y);

            if (loc == null || loc.isLiquid()) continue;   // не в воду
            if (loc.getAnimals().size() >= 3) continue;    // не более 3 на клетку

            int life = ThreadLocalRandom.current().nextInt(10, 31);
            loc.addAnimals(new Duck(life));
            placed++;
        }
    }
}