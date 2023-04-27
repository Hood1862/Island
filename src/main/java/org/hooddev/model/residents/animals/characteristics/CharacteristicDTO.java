package org.hooddev.model.residents.animals.characteristics;

import lombok.Getter;
import lombok.Setter;

public class CharacteristicDTO {

    @Getter @Setter private double weight;
    @Getter @Setter private int maximumAmount;
    @Getter @Setter private int movementSpeed;
    @Getter @Setter private double energy;
    @Getter @Setter private int countLife;

    public CharacteristicDTO(double weight, int maximumAmount, int movementSpeed, double energy, int countLife) {
        this.weight = weight;
        this.maximumAmount = maximumAmount;
        this.movementSpeed = movementSpeed;
        this.energy = energy;
        this.countLife = countLife;
    }
}

