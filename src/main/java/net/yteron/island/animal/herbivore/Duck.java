package net.yteron.island.animal.herbivore;

import net.yteron.island.animal.Animal;
import net.yteron.island.server.Location;

public class Duck extends Animal {

    public Duck(int timeToDeath) {
        super(timeToDeath);
    }

    @Override
    public void defaultAction() {

    }

    @Override
    public void eat(Location location) {
        if (location.isGrass()) {
            location.setGrass(false);
            bonusTimeToDeath(2);
        }
    }

}
