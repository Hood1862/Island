package org.hooddev.model.residents.animals.Herbivore;

import org.hooddev.model.Utils.Utils;
import org.hooddev.model.residents.animals.Animal;
import org.hooddev.model.residents.animals.AnimalTypeEnum;
import org.hooddev.model.residents.animals.AnimalsEnum;
import org.hooddev.model.residents.animals.characteristics.Characteristic;
import org.hooddev.model.residents.plants.Plants;
import org.hooddev.model.island.Cell;

import java.util.List;
import java.util.Set;

public abstract class Herbivore extends Animal {

    @Override
    public AnimalTypeEnum getAnimalType() {
        return AnimalTypeEnum.HERBIVORE;
    }

    public boolean isNotVegan() {
        return false;
    }

    @Override
    public void eat(Cell cell) {
        if (isLive()) {
            boolean isAteFull;
            if (isNotVegan()) {
                Set<AnimalsEnum> animalEnums = getFoodChances().keySet();
                List<Animal> collect = cell.getAnimals().stream()
                        .filter(Animal::isLive)
                        .filter(animal -> animalEnums.contains(animal.getAnimal()))
                        .toList();
                double energy = getCharacteristic().getEnergy();

                for (Animal animal : collect) {
                    AnimalsEnum animalEnum = animal.getAnimal();

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
            } else {
                isAteFull = cell.getPlants().reduceAmount(getCharacteristic().getEnergy());
            }

            if (isAteFull) {
                resetHungerCount();
            } else {
                addOneTaskHunger();
            }
        }
    }

}
