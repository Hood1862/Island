package org.hooddev.model.island;

import org.hooddev.model.residents.animals.AnimalsEnum;
import org.hooddev.model.residents.animals.AnimalsFactory;
import org.hooddev.model.residents.animals.characteristics.Characteristic;
import org.hooddev.model.residents.animals.characteristics.CharacteristicDTO;

public class Location {

    private static final int WIDTH = 20;
    private static final int HEIGHT = 10;

    private final Cell[][] island = new Cell[HEIGHT][WIDTH];

    public Location() {
        init();
        initAnimalAndPlant();
    }

    public void init() {
        System.out.println("Инициализация поля island");
        for (int i = 0; i < island.length; i++) {
            for (int j = 0; j < island[i].length; j++) {
                island[i][j] = new Cell();
            }
        }
        System.out.println("Инициализация поля island завершена");
    }

    private void initAnimalAndPlant() {
        for (Cell[] cells : island) {
            for (Cell cell : cells) {
                initAnimal(cell);
                int amountPlantsInCell = (int) (Math.random() * 10000);
                cell.getPlants().setAmount(amountPlantsInCell);
            }
        }
    }

    private void initAnimal(Cell cell) {
        for (AnimalsEnum value : AnimalsEnum.values()) {
            CharacteristicDTO characteristicDto = Characteristic.getCharacteristicDTO(value);
            int amountAnimalInCell = (int) (Math.random() * characteristicDto.getMaximumAmount());
            for (int i = 0; i < amountAnimalInCell; i++) {
                cell.getAnimals().add(AnimalsFactory.getAnimal(value));
            }
        }
    }


    public Cell[][] getIsland() {
        return island;
    }
}
