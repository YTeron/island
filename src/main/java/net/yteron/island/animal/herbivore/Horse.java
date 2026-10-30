package net.yteron.island.animal.herbivore;

import net.yteron.island.animal.Animal;
import net.yteron.island.animal.EStats;
import net.yteron.island.server.Location;

public class Horse extends Herbivore {
    static {
        Animal.register(Horse.class);
    }
    public Horse(int timeToDeath) {
        super(EStats.HORSE, timeToDeath);
    }

    @Override
    public void defaultAction() {

    }

}
