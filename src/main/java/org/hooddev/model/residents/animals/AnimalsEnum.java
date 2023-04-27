package org.hooddev.model.residents.animals;

import lombok.Getter;

public enum AnimalsEnum {

    WOLF(AnimalTypeEnum.PREDATOR, "Волк "),
    SNAKE(AnimalTypeEnum.PREDATOR, "Змея"),
    FOX(AnimalTypeEnum.PREDATOR, "Лиса "),
    BEAR(AnimalTypeEnum.PREDATOR, "Медведь "),
    EAGLE(AnimalTypeEnum.PREDATOR, "Орел "),
    HORSE(AnimalTypeEnum.HERBIVORE, "Лошадь "),
    DEER(AnimalTypeEnum.HERBIVORE, "Олень "),
    RABBIT(AnimalTypeEnum.HERBIVORE, "Заяц "),
    MOUSE(AnimalTypeEnum.HERBIVORE, "Мышь "),
    GOAT(AnimalTypeEnum.HERBIVORE, "Коза "),
    SHEEP(AnimalTypeEnum.HERBIVORE, "Овца "),
    BOAR(AnimalTypeEnum.HERBIVORE, "Кабан "),
    BUFFALO(AnimalTypeEnum.HERBIVORE, "Буйвол "),
    DUCK(AnimalTypeEnum.HERBIVORE, "Утка "),
    CATERPILLAR(AnimalTypeEnum.HERBIVORE, "Гусеница ");


    @Getter private final AnimalTypeEnum animalTypeEnum;


    @Getter private final String description;


    AnimalsEnum(AnimalTypeEnum animalTypeEnum, String description) {
        this.animalTypeEnum = animalTypeEnum;
        this.description = description;
    }
}
