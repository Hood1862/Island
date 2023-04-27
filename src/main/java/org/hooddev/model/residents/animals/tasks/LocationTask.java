package org.hooddev.model.residents.animals.tasks;

import org.hooddev.model.island.Cell;
import org.hooddev.model.island.Location;
import org.hooddev.model.island.LocationPrint;
import org.hooddev.model.residents.animals.Animal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;

public class LocationTask implements Runnable {

    private final Location location;

    public LocationTask(Location location) {
        this.location = location;
    }

    @Override
    public void run() {

        final Cell[][] island = location.getIsland();

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);
        List<Future<?>> futures = new ArrayList<>();
        Arrays.stream(island)
                .flatMap(Arrays::stream)
                .forEach(cell -> futures.add(executorService.submit(new CellTask(cell))));

        for (Future<?> future : futures) {
            try {
                future.get();
            } catch (Exception ignored) {
            }
        }
        executorService.shutdown();


        for (int i = 0; i < island.length; i++) {
            for (int j = 0; j < island[i].length; j++) {

                int finalI = i;
                int finalJ = j;

                island[i][j].getAnimals().stream()
                        .filter(Animal::isReadyToMove)
                        .forEach(animal -> {

                            int movementSpeed = animal.movementSpeed();

                            List<Cell> listMovedAnimal = getListMovedAnimal(island, finalI, finalJ, movementSpeed);

                            Collections.shuffle(listMovedAnimal);

                            for (Cell cell : listMovedAnimal) {

                                long countAnimals = Cell.getAnimals().stream()
                                        .filter(animal1 -> animal1.getAnimal() == animal.getAnimal())
                                        .count();


                                if (countAnimals < animal.getCharacteristic().getMaximumAmount()) {

                                    Cell.getAnimals().add(animal);
                                }
                            }
                        });

            }
        }

        for (Cell[] cells : island) {
            for (Cell cell : cells) {
                Cell.getAnimals().forEach(animal -> animal.setReadyToMove(true));
            }
        }

        LocationPrint.print(location.getIsland());

    }


    private static List<Cell> getListMovedAnimal(Cell[][] island, final int i, final int j, int movementSpeed) {
        List<Cell> result = new ArrayList<>();
        int leftPosition = Math.max(j - movementSpeed, 0);
        int rightPosition = Math.min(j + movementSpeed, island[j].length - 1);
        int downPosition = Math.min(i + movementSpeed, island.length - 1);
        int upPosition = Math.max(i - movementSpeed, 0);

        for (int i1 = upPosition; i1 <= downPosition; i1++) {
            for (int j2 = leftPosition; j2 <= rightPosition; j2++) {
                if (!(i1 == i && j2 == j)) {
                    result.add(island[i1][j2]);
                }
            }
        }

        return result;
    }
}
