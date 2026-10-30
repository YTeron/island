package net.yteron.island.animal.herbivore;

import net.yteron.island.animal.Animal;
import net.yteron.island.animal.EStats;
import net.yteron.island.server.Location;
import net.yteron.island.server.Loger;

import java.util.List;

public class Duck extends Herbivore {

    static {
        Animal.register(Duck.class);
    }

    public Duck(int timeToDeath) {
        super(EStats.DUCK,timeToDeath);
    }

    @Override
    public void eat(Location location) {
        if (isFull()) return;
        List<Caterpillar> caterpillars = location.getOfTypeAnimal(Caterpillar.class);
        if (!caterpillars.isEmpty()) {
            Caterpillar prey = caterpillars.get(0);
            location.removeAnimals(prey);
            feed(prey.getStats().weight);
            bonusTimeToDeath(3);
            Loger.log("Duck съел Caterpillar");
        } else {
            super.eat(location);
        }
    }

    @Override
    public void defaultAction() {
        System.out.println("Kra");
    }

}
