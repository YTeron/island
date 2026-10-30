package net.yteron.island.animal.herbivore;

import net.yteron.island.animal.Animal;
import net.yteron.island.animal.EStats;

public class Rabbit extends Herbivore{
    static {
        Animal.register(Rabbit.class);
    }
    public Rabbit(int timeToDeath) {
        super(EStats.RABBIT, timeToDeath);
    }
    @Override
    public void defaultAction() {

    }

}
