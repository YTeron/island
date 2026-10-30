package net.yteron.island.animal.carnivore;

import net.yteron.island.animal.Animal;
import net.yteron.island.animal.EStats;

public class Fox extends Carnivore{
    static {
        Animal.register(Fox.class);
    }
    public Fox(int timeToDeath) {
        super(EStats.FOX, timeToDeath);
    }

    @Override
    public void defaultAction() {

    }
}
