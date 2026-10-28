package net.yteron.island.animal;

import net.yteron.island.server.Island;
import net.yteron.island.server.Location;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Animal {
    private int timeToDeath;
    public Animal(int timeToDeath) {
        this.timeToDeath = timeToDeath;

    }
    public void move(Location current, Island island) {
        int dx =  ThreadLocalRandom.current().nextInt(-1, 2);
        int dy =  ThreadLocalRandom.current().nextInt(-1, 2);
        if (dx == 0 && dy == 0) defaultAction();

        Location target = island.getLocation(
                current.getX() + dx, current.getY() + dy);
        if (target == null) {
            return;
        }
        if (target.addAnimals(this)) {
            current.removeAnimals(this);
        }

    }
    public boolean age() {
        return --timeToDeath > 0;
    }
    public boolean isDead() {
        return timeToDeath <= 0;
    }
    public abstract void defaultAction();
    public abstract void eat(Location location);
    public int getTimeToDeath(){return timeToDeath;}
    public void bonusTimeToDeath(int bonus){ timeToDeath+=bonus;}
}
