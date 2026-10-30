package net.yteron.island.animal.herbivore;

import net.yteron.island.animal.Animal;
import net.yteron.island.animal.EStats;

public class Boar extends Herbivore{
    static {
        Animal.register(Boar.class);
    }
    public Boar(int timeToDeath) {
        super(EStats.BOAR, timeToDeath);
    }

    @Override
    public void defaultAction() {

    }
}
