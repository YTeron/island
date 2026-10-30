package net.yteron.island.animal.carnivore;

import net.yteron.island.animal.Animal;
import net.yteron.island.animal.EStats;

public class Snake extends Carnivore{
    static {
        Animal.register(Snake.class);
    }
    public Snake(int timeToDeath) {
        super(EStats.SNAKE, timeToDeath);
    }

    @Override
    public void defaultAction() {

    }
}
