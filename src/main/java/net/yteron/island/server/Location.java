package net.yteron.island.server;

import net.yteron.island.animal.Animal;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class Location {
    private final int x;
    private final int y;
    private final boolean isLiquid;
    private boolean isGrass;
    private int time;
    private static final int GRASS_REGROW_TICKS = 10;

    private List<Animal> animals;

    public Location(int x, int y) {
        this(x, y, false , false);
    }
    public Location(int x, int y, boolean isLiquid, boolean isGrass){
        this.y = y;
        this.x = x;
        this.isLiquid = isLiquid;
        this.isGrass =isGrass;
        animals =new CopyOnWriteArrayList<>();
    }

    public List<Animal> getAnimals() {
        return animals;
    }
    public void tick(){
        if (isLiquid) return;
        if (isGrass) return;

        time++;
        if (time >= GRASS_REGROW_TICKS) {
            isGrass = true;
            time = 0;
        }
    }
    public void eatGrass() {
        isGrass = false;
        time = 0;
    }
    public boolean isLiquid() {
        return isLiquid;
    }

    public boolean isGrass() {
        return isGrass;
    }
    public void setGrass(boolean isGrass){this.isGrass =isGrass; }

    public boolean addAnimals(Animal animals) {
        return this.animals.add(animals);
    }

    public void removeAnimals(Animal animals) {
        this.animals.remove(animals);
    }
    public <T extends Animal> List<T> getOfTypeAnimal(Class<T> t){
        List<T> list = new ArrayList<>();
        for (Animal animal : animals) {
            if (t.isInstance(animal)) {
                list.add(t.cast(animal));
            }
        }
        return list;
    }
    public boolean canAdd(Animal animal) {
        long sameKind = animals.stream()
                .filter(a -> a.getClass() == animal.getClass())
                .count();
        return sameKind < animal.getStats().maxPerCell
                && animals.size() < 1000; // общий предохранитель
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
