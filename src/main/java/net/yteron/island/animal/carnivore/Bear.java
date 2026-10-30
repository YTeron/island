package net.yteron.island.animal.carnivore;

import net.yteron.island.animal.Animal;
import net.yteron.island.animal.EStats;

public class Bear extends Carnivore{
    static {
        Animal.register(Bear.class);
    }
    public Bear(int timeToDeath) {
        super(EStats.BEAR, timeToDeath);
    }

    @Override
    public void defaultAction() {

    }
}
