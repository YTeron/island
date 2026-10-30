package net.yteron.island.animal.carnivore;

import net.yteron.island.animal.Animal;
import net.yteron.island.animal.EStats;
import net.yteron.island.animal.herbivore.Herbivore;
import net.yteron.island.server.Location;
import net.yteron.island.server.Loger;

import java.util.ArrayList;
import java.util.List;

public abstract class Carnivore extends Animal {

    public Carnivore(EStats species, int timeToDeath) {
        super(species, timeToDeath);
    }

    @Override
    public void eat(Location location) {
        if (isFull()) return;
        for (Animal prey : new ArrayList<>(location.getAnimals())) {
            if (prey == this) continue;
            if (prey instanceof Carnivore) continue;
            if (prey.getStats().weight > stats.foodNeed * 4) continue;

            location.removeAnimals(prey);
            feed(prey.getStats().weight);
            bonusTimeToDeath(2);
            Loger.log(getClass().getSimpleName() + " съел " + prey.getClass().getSimpleName());
            return;
        }
    }
}
