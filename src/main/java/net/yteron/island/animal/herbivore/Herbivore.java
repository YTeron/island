package net.yteron.island.animal.herbivore;

import net.yteron.island.animal.Animal;
import net.yteron.island.animal.EStats;
import net.yteron.island.server.Location;

public abstract class Herbivore extends Animal {

    public Herbivore(EStats species, int timeToDeath) {
        super(species,timeToDeath);
    }

    @Override
    public void eat(Location location) {
        if (isFull()) return;
        if (location.isGrass()) {
            location.eatGrass();
            feed(1.0);
            bonusTimeToDeath(2);
        }
    }
}
