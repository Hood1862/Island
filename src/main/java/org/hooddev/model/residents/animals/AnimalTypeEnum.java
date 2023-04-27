package org.hooddev.model.residents.animals;

import lombok.Getter;

public enum AnimalTypeEnum {

    PREDATOR("Хищник"),
    HERBIVORE("Травоядное");

    @Getter final String description;

    AnimalTypeEnum(String description) {
        this.description = description;
    }


}
