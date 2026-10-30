package net.yteron.island.server.command;

import net.yteron.island.animal.Animal;
import net.yteron.island.server.Island;
import net.yteron.island.server.Location;

import java.util.concurrent.ThreadLocalRandom;

public class Init {
    public static <T extends Animal> void spawnAnimal(Island island, int count, Class<T> type) {
        int placed = 0;
        int attempts = 0;
        int maxAttempts = count * 100;

        while (placed < count && attempts++ < maxAttempts) {
            int x = ThreadLocalRandom.current().nextInt(island.getWidth());
            int y = ThreadLocalRandom.current().nextInt(island.getHeight());
            Location loc = island.getLocation(x, y);
            if (loc == null || loc.isLiquid()) continue;

            int life = ThreadLocalRandom.current().nextInt(10, 31);
            try {
                T animal = type.getDeclaredConstructor(int.class)
                        .newInstance(life);

                if (!loc.canAdd(animal)) continue;
                if (loc.addAnimals(animal)) placed++;

            } catch (ReflectiveOperationException e) {
                throw new RuntimeException(
                        "Не удалось создать " + type.getSimpleName(), e);
            }
        }
    }
}
