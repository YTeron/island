package net.yteron.island.animal.carnivore;

import net.yteron.island.animal.Animal;
import net.yteron.island.animal.EStats;

public class Eagle extends Carnivore{
    static {
        Animal.register(Eagle.class);
    }
    public Eagle(int timeToDeath) {
        super(EStats.EAGLE, timeToDeath);
    }

    @Override
    public void defaultAction() {

    }
}
