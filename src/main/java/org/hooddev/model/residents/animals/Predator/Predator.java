package org.hooddev.model.residents.animals.Predator;

import org.hooddev.model.Utils.Utils;
import org.hooddev.model.island.Cell;
import org.hooddev.model.residents.animals.Animal;
import org.hooddev.model.residents.animals.AnimalTypeEnum;
import org.hooddev.model.residents.animals.AnimalsEnum;
import org.hooddev.model.residents.animals.characteristics.Characteristic;

import java.util.List;
import java.util.Set;

public abstract class Predator extends Animal {

    @Override
    public AnimalTypeEnum getAnimalType() {
        return AnimalTypeEnum.PREDATOR;
    }

    @Override
    public void eat(Cell cell) {

        boolean isAteFull;
        Set<AnimalsEnum> animalEnums = getFoodChances().keySet();

        List<Animal> collect = Cell.getAnimals().stream()
                .filter(Animal::isLive)
                .filter(animal -> animalEnums.contains(getAnimal()))
                .toList();
        double energy = getCharacteristic().getEnergy();

        for (Animal animal : collect) {
            AnimalsEnum animalEnum = getAnimal();

            boolean randomBoolean = Utils.getRandomBoolean(getFoodChances().get(animalEnum));
            if (randomBoolean) {
                double weight = Characteristic.getCharacteristicDTO(animalEnum).getWeight();
                energy = energy - weight;
                animal.killAnimal();
                cell.addEatenAnimals();
            }

            if (energy <= 0)
                break;
        }

        if (energy > 0) {
            isAteFull = cell.getPlants().reduceAmount(energy);
        } else
            isAteFull = true;

        if (isAteFull) {
            resetHungerCount();
        } else {
            addOneTaskHunger();
        }
    }

}
