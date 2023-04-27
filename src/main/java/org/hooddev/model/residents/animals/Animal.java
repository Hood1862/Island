package org.hooddev.model.residents.animals;

import org.hooddev.model.island.Cell;
import org.hooddev.model.residents.animals.chances.Food;
import org.hooddev.model.residents.animals.characteristics.Characteristic;
import org.hooddev.model.residents.animals.characteristics.CharacteristicDTO;

import java.util.Map;

public abstract class Animal {

    private int amountOfHunger = 0;
    private boolean isLive = true;
    private boolean isReadyToMove = true;

    public CharacteristicDTO getCharacteristic() {
        return Characteristic.getCharacteristicDTO(getAnimal());
    }

    protected Map<AnimalsEnum, Integer> getFoodChances() {
        return Food.getAnimalEnumMap().get(getAnimal());
    }


    public abstract void eat(Cell cell);

    public boolean multiply() {
        return isLive && getAmountOfHunger() == 0;
    }

    public int movementSpeed() {
        return getCharacteristic().getMovementSpeed();
    }

    public abstract AnimalTypeEnum getAnimalType();

    public abstract AnimalsEnum getAnimal();

    public int getAmountOfHunger() {
        return amountOfHunger;
    }

    public void addOneTaskHunger() {
        amountOfHunger++;
    }

    public void resetHungerCount() {
        this.amountOfHunger = 0;
    }

    public boolean isLive() {
        return isLive;
    }

    public void killAnimal() {
        isLive = false;
    }

    public boolean isReadyToMove() {
        return isReadyToMove;
    }

    public void setReadyToMove(boolean readyToMove) {
        isReadyToMove = readyToMove;
    }
}