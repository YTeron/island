package net.yteron.island.animal;

import net.yteron.island.server.Island;
import net.yteron.island.server.Location;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Animal {
    private int timeToDeath;
    private static final Set<Class<? extends Animal>> REGISTRY = new LinkedHashSet<>();
    protected final EStats stats;
    private double satiety;
    private int cooldown;

    public Animal(EStats stats,int timeToDeath) {
        this.stats = stats;
        this.timeToDeath = timeToDeath;
        this.satiety = stats.foodNeed / 2.0;
        this.cooldown = 5;
        this.timeToDeath = timeToDeath;
    }
    public void move(Location current, Island island) {
        int speed = stats.speed;
        if (speed <= 0) {
            defaultAction();
            return;
        }

        int dx = ThreadLocalRandom.current().nextInt(-speed, speed + 1);
        int dy = ThreadLocalRandom.current().nextInt(-speed, speed + 1);
        if (dx == 0 && dy == 0) {
            defaultAction();
            return;
        }

        Location target = island.getLocation(
                current.getX() + dx, current.getY() + dy);
        if (target == null || target.isLiquid()) return;
        if (target.getAnimals().size() >= stats.maxPerCell) return;

        if (target.addAnimals(this)) {
            current.removeAnimals(this);
        }
    }

    public boolean age() {
        if (--timeToDeath <= 0) return false;
        if (cooldown > 0) cooldown--;
        return true;
    }
    public boolean isDead() {
        return timeToDeath <= 0;
    }
    public abstract void defaultAction();
    public abstract void eat(Location location);

    public int getTimeToDeath(){return timeToDeath;}
    public void bonusTimeToDeath(int bonus){ timeToDeath+=bonus;}

    public boolean canBreed() {
        return cooldown == 0 && isFull() && !isDead();
    }
    protected void feed(double kg) {
        satiety = Math.min(stats.foodNeed, satiety + kg);
    }

    public boolean isFull() {
        return satiety >= stats.foodNeed;
    }
    public Animal tryBreed(Location location) {
        if (!canBreed()) return null;

        for (Animal other : location.getAnimals()) {
            if (other == this) continue;
            if (other.getClass() != this.getClass()) continue;
            if (!other.canBreed()) continue;

            if (location.getAnimals().size() >= stats.maxPerCell) return null;

            Animal child = createChild();
            if (child == null) return null;

            this.cooldown = 10;
            other.cooldown = 10;
            this.satiety = 0;
            other.satiety = 0;
            location.addAnimals(child);
            return child;
        }
        return null;
    }

    protected Animal createChild() {
        try {
            return getClass()
                    .getDeclaredConstructor(int.class)
                    .newInstance(ThreadLocalRandom.current().nextInt(10, 31));
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException("Не удалось создать потомка " + getClass().getSimpleName(), e);
        }
    }

    public double getSatiety() {
        return satiety;
    }

    public EStats getStats() {
        return stats;
    }

    public static void register(Class<? extends Animal> clazz) {
        REGISTRY.add(clazz);
    }

    public static Set<Class<? extends Animal>> getAll() {
        return REGISTRY;
    }
}
