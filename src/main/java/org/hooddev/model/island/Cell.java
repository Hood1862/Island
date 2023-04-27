package org.hooddev.model.island;

import lombok.Getter;
import lombok.Setter;
import org.hooddev.model.residents.animals.Animal;
import org.hooddev.model.residents.plants.Plants;

import java.util.ArrayList;
import java.util.List;


public class Cell extends Plants{
    @Setter
    @Getter
    private static List<Animal> animals = new ArrayList<>();

    @Setter
    @Getter
    private Plants plants = new Plants();

    @Setter
    @Getter
    private int deadAnimals = 0;

    @Setter
    @Getter
    private int eatenAnimals = 0;


    public void reset() {
        deadAnimals = 0;
        eatenAnimals = 0;
    }

    public void addDeadAnimals() {
        this.deadAnimals++;
    }

    public void addEatenAnimals() {
        this.eatenAnimals++;
    }



}
