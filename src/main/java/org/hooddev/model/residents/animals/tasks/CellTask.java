package org.hooddev.model.residents.animals.tasks;

import org.hooddev.model.island.Cell;
import org.hooddev.model.residents.animals.Animal;
import org.hooddev.model.residents.animals.AnimalsEnum;
import org.hooddev.model.residents.animals.AnimalsFactory;
import org.hooddev.model.residents.animals.characteristics.Characteristic;
import org.hooddev.model.residents.animals.characteristics.CharacteristicDTO;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CellTask implements Runnable {

    private final Cell cell;

    public CellTask(Cell cell) {
        this.cell = cell;
    }

    @Override
    public void run() {
        cell.getPlants();
        Cell.getAnimals().forEach(animal -> animal.eat(cell));
        Cell.getAnimals().forEach(animal -> {
            if (animal.getAmountOfHunger() > animal.getCharacteristic().getCountLife()) {
                animal.killAnimal();
                cell.addDeadAnimals();
            }
        });

        List<Animal> notLiveAnimalList = Cell.getAnimals().stream()
                .filter(animal -> !animal.isLive())
                .toList();

        Cell.getAnimals().removeAll(notLiveAnimalList);


        Map<AnimalsEnum, Long> countMultiply = Cell.getAnimals().stream()
                .filter(Animal::multiply)
                .collect(Collectors.groupingBy(
                        Animal::getAnimal,
                        Collectors.counting()
                ));


        Map<AnimalsEnum, Long> countAnimal = Cell.getAnimals().stream()
                .collect(Collectors.groupingBy(
                        Animal::getAnimal,
                        Collectors.counting()
                ));


        countMultiply.forEach((animalEnum, aLong) -> {

            CharacteristicDTO characteristicDto = Characteristic.getCharacteristicDTO(animalEnum);
            for (int i = 0; i < aLong / 2; i++) {
                Long aLong1 = countAnimal.get(animalEnum);
                if (characteristicDto.getMaximumAmount() > aLong1) {
                    Cell.getAnimals().add(AnimalsFactory.getAnimal(animalEnum));
                    countAnimal.put(animalEnum, ++aLong1);
                } else {
                    break;
                }
            }
        });
    }
}

