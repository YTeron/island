package net.yteron.island.server.render;

import net.yteron.island.server.Island;
import net.yteron.island.server.Location;

public class Render {
    public static void render(Island island) {
        int width = island.getWidth();
        int height = island.getHeight();

        StringBuilder top = new StringBuilder("+");
        top.append("-".repeat(width * 2));
        top.append("+");
        System.out.println(top);

        for (int y = 0; y < height; y++) {
            StringBuilder row = new StringBuilder("|");
            for (int x = 0; x < width; x++) {
                Location loc = island.getLocation(x, y);
                row.append(symbolFor(loc)).append(" ");
            }
            row.append("|");
            System.out.println(row);
        }

        StringBuilder bottom = new StringBuilder("+");
        bottom.append("-".repeat(width * 2));
        bottom.append("+");
        System.out.println(bottom);

        System.out.println("Легенда: ~ вода, * трава, . пусто, A животное, @ несколько");
    }

    private static char symbolFor(Location loc) {
        if (loc == null) return ' ';

        int animalCount = loc.getAnimals().size();

        if (animalCount > 1)      return '@';
        if (animalCount == 1)     return 'A';
        if (loc.isGrass())        return '*';
        if (loc.isLiquid())       return '~';
        return '.';
    }
}
