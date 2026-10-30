package net.yteron.island.animal.carnivore;

import net.yteron.island.animal.Animal;
import net.yteron.island.animal.EStats;

public class Wolf extends Carnivore{
    static {
        Animal.register(Wolf.class);
    }
    public Wolf(int timeToDeath) {
        super(EStats.WOLF, timeToDeath);
    }

    @Override
    public void defaultAction() {

    }
}
