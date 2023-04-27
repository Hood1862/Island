package org.hooddev.model;

import org.hooddev.model.island.Location;
import org.hooddev.model.island.LocationPrint;
import org.hooddev.model.residents.animals.tasks.LocationTask;

public class Runner {

    private static final int STEP_COUNT = 3;

    public static void main(String[] args) {


        Location location = new Location();

        LocationPrint.print(location.getIsland());


        for (int i = 0; i < STEP_COUNT; i++) {
            System.out.printf("Расчёт хода номер = %d начат %n", i + 1);
            new LocationTask(location).run();
            System.out.printf("Расчёт хода номер = %d завершен %n", i + 1);
        }

        System.out.println("Пришло время покинуть остров.");

    }

}
