package net.yteron.island.animal.herbivore;

import net.yteron.island.animal.Animal;
import net.yteron.island.animal.EStats;

public class Caterpillar extends Herbivore{
    static {
        Animal.register(Caterpillar.class);
    }
    public Caterpillar(int timeToDeath) {
        super(EStats.CATERPILLAR, timeToDeath);
    }

    @Override
    public void defaultAction() {

    }
}
