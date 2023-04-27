package org.hooddev.model.island;

import org.hooddev.model.residents.animals.Animal;
import org.hooddev.model.residents.animals.AnimalsEnum;
import org.hooddev.model.residents.plants.Plants;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LocationPrint {

    public static void print(Cell[][] island) {
        for (int i = 0; i < island.length; i++) {
            for (int j = 0; j < island[i].length; j++) {
                System.out.printf("клетка[%d][%d] Старт%n", i, j);
                printCell(island[i][j]);
                System.out.printf("клетка[%d][%d] Финиш%n", i, j);
            }

        }
    }

    private static void printCell(Cell cell) {
        Plants plants = (Plants) cell.getPlants();
        System.out.println("Растений осталось - " + plants.getAmount());

        System.out.println("Животных всего - " + Cell.getAnimals().size());

        Map<AnimalsEnum, List<Animal>> animalMap = Cell.getAnimals().stream()
                .collect(Collectors.groupingBy(Animal::getAnimal));

        for (Map.Entry<AnimalsEnum, List<Animal>> animalEnumListEntry : animalMap.entrySet()) {
            AnimalsEnum key = animalEnumListEntry.getKey();
            int size = animalEnumListEntry.getValue().size();
            System.out.println("Всего в клетке " + key.getDescription() + " - " + size);

            long count = animalEnumListEntry.getValue().stream()
                    .filter(animal -> animal.getAmountOfHunger() == 0)
                    .count();
            System.out.println(key.getDescription() + "всего поело - " + count + ", голодных - " + (size - count) );
        }

        System.out.println("Животных погибло голодными - " + cell.getDeadAnimals());
        System.out.println("Животных съедено - " + cell.getEatenAnimals());
        cell.reset();
    }

}