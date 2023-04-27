package org.hooddev.model.residents.animals.characteristics;

import org.hooddev.model.residents.animals.AnimalsEnum;

import java.util.HashMap;
import java.util.Map;

public class Characteristic {

    private static final Map<AnimalsEnum, CharacteristicDTO> animalCharacteristicMap = new HashMap<>();

    static {
        init();
    }

    public Characteristic() {
        init();
    }

    private static void init() {

        // хищники

        animalCharacteristicMap.put(
                AnimalsEnum.WOLF,
                new CharacteristicDTO(50, 30, 3, 8, 10));

        animalCharacteristicMap.put(
                AnimalsEnum.SNAKE,
                new CharacteristicDTO(15, 50, 1, 3 , 15));

        animalCharacteristicMap.put(
                AnimalsEnum.FOX,
                new CharacteristicDTO(8, 30, 2, 2, 8));

        animalCharacteristicMap.put(
                AnimalsEnum.BEAR,
                new CharacteristicDTO(500, 5, 2, 80, 15));

        animalCharacteristicMap.put(
                AnimalsEnum.EAGLE,
                new CharacteristicDTO(6, 20, 3, 1, 5));



        // травоядные

        animalCharacteristicMap.put(
                AnimalsEnum.HORSE,
                new CharacteristicDTO(400, 20, 4, 60, 5));

        animalCharacteristicMap.put(
                AnimalsEnum.DEER,
                new CharacteristicDTO(300, 20, 4, 50, 4));

        animalCharacteristicMap.put(
                AnimalsEnum.RABBIT,
                new CharacteristicDTO(2, 150, 2, 0.45, 7));

        animalCharacteristicMap.put(
                AnimalsEnum.MOUSE,
                new CharacteristicDTO(0.05, 500, 1, 0.01, 3));

        animalCharacteristicMap.put(
                AnimalsEnum.GOAT,
                new CharacteristicDTO(60, 140, 3, 10, 10));

        animalCharacteristicMap.put(
                AnimalsEnum.SHEEP,
                new CharacteristicDTO(70, 140, 3, 10, 15));

        animalCharacteristicMap.put(
                AnimalsEnum.BOAR,
                new CharacteristicDTO(400, 50, 2, 50, 8));

        animalCharacteristicMap.put(
                AnimalsEnum.BUFFALO,
                new CharacteristicDTO(700, 10, 3, 100, 4));

        animalCharacteristicMap.put(
                AnimalsEnum.DUCK,
                new CharacteristicDTO(1, 200, 4, 0.15, 4));

        animalCharacteristicMap.put(
                AnimalsEnum.CATERPILLAR,
                new CharacteristicDTO(0.01, 1000, 0, 0, 1));
    }

    public static CharacteristicDTO getCharacteristicDTO(AnimalsEnum animalEnum) {
        return animalCharacteristicMap.get(animalEnum);
    }

}
