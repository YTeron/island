package net.yteron.island.animal.herbivore;

import net.yteron.island.animal.Animal;
import net.yteron.island.animal.EStats;

public class Mouse extends Herbivore{
    static {
        Animal.register(Mouse.class);
    }
    public Mouse(int timeToDeath) {
        super(EStats.MOUSE, timeToDeath);
    }

    @Override
    public void defaultAction() {

    }
}
