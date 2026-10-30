package net.yteron.island.animal.herbivore;

import net.yteron.island.animal.Animal;
import net.yteron.island.animal.EStats;
import net.yteron.island.server.Location;

public class Goat  extends Herbivore {
    static {
        Animal.register(Goat.class);
    }
    public Goat(int timeToDeath) {
        super(EStats.GOAT, timeToDeath);
    }

    @Override
    public void defaultAction() {

    }
}
