package net.yteron.island.server;

import net.yteron.island.animal.Animal;

import java.util.List;

public class Island {
    private final int width, height;
    private Location[][] map;


    public Island(int width, int height) {
        this.width = width;
        this.height = height;
        this.map = new Location[height][width];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                boolean liquid = x < width / 3;
                boolean grass  = !liquid && ((x + y) % 3 == 0);
                map[y][x] = new Location(x, y,liquid,grass);
            }
        }
    }

    public List<Animal> animal(int x,int y){
        Location location = map[x][y];
        return location.getAnimals();
    }

    public Location getLocation(int x, int y) {
        if (x < 0 || x >= width || y < 0 || y >= height) {
            return null;
        }
        return map[y][x];
    }


    public int getWidth()  { return width; }
    public int getHeight() { return height; }

    public void forEachLocation(java.util.function.Consumer<Location> action) {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                action.accept(map[y][x]);
            }
        }
    }

}
