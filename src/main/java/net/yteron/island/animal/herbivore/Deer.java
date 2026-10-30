package net.yteron.island.animal.herbivore;

import net.yteron.island.animal.Animal;
import net.yteron.island.animal.EStats;

public class Deer extends Herbivore {
    static {
        Animal.register(Deer.class);
    }
    public Deer(int timeToDeath) {
        super(EStats.DEER, timeToDeath);
    }

    @Override
    public void defaultAction() {

    }
}
