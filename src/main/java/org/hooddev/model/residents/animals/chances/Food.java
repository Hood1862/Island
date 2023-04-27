package org.hooddev.model.residents.animals.chances;

import org.hooddev.model.residents.animals.AnimalsEnum;

import java.util.HashMap;
import java.util.Map;

public class Food {

    private static final Map<AnimalsEnum, Map<AnimalsEnum, Integer>> animalEnumMap = new HashMap<>();

    public static Map<AnimalsEnum, Map<AnimalsEnum, Integer>> getAnimalEnumMap() {
        return animalEnumMap;
    }

    static {
        init();
        initHerbivoreChances();
    }

    private static void init() {

        // Волк

        Map<AnimalsEnum, Integer> wolfMap = new HashMap<>();
        wolfMap.put(AnimalsEnum.HORSE, 10);
        wolfMap.put(AnimalsEnum.DEER, 15);
        wolfMap.put(AnimalsEnum.RABBIT, 60);
        wolfMap.put(AnimalsEnum.MOUSE, 80);
        wolfMap.put(AnimalsEnum.GOAT, 60);
        wolfMap.put(AnimalsEnum.SHEEP, 70);
        wolfMap.put(AnimalsEnum.BOAR, 15);
        wolfMap.put(AnimalsEnum.BUFFALO, 10);
        wolfMap.put(AnimalsEnum.DUCK, 40);
        animalEnumMap.put(AnimalsEnum.WOLF, wolfMap);

        // Змея

        Map<AnimalsEnum, Integer> snakeMap = new HashMap<>();
        snakeMap.put(AnimalsEnum.FOX, 15);
        snakeMap.put(AnimalsEnum.RABBIT, 20);
        snakeMap.put(AnimalsEnum.MOUSE, 40);
        snakeMap.put(AnimalsEnum.DUCK, 10);
        animalEnumMap.put(AnimalsEnum.SNAKE, snakeMap);

        // Лиса

        Map<AnimalsEnum, Integer> foxMap = new HashMap<>();
        foxMap.put(AnimalsEnum.RABBIT, 70);
        foxMap.put(AnimalsEnum.MOUSE, 90);
        foxMap.put(AnimalsEnum.DUCK, 60);
        foxMap.put(AnimalsEnum.CATERPILLAR, 40);
        animalEnumMap.put(AnimalsEnum.FOX, foxMap);

        // Медведь

        Map<AnimalsEnum, Integer> bearMap = new HashMap<>();
        bearMap.put(AnimalsEnum.SNAKE, 80);
        bearMap.put(AnimalsEnum.HORSE, 40);
        bearMap.put(AnimalsEnum.DEER, 80);
        bearMap.put(AnimalsEnum.RABBIT, 80);
        bearMap.put(AnimalsEnum.MOUSE, 90);
        bearMap.put(AnimalsEnum.GOAT, 70);
        bearMap.put(AnimalsEnum.SHEEP, 70);
        bearMap.put(AnimalsEnum.BOAR, 50);
        bearMap.put(AnimalsEnum.BUFFALO, 20);
        bearMap.put(AnimalsEnum.DUCK, 10);
        animalEnumMap.put(AnimalsEnum.BEAR, bearMap);

        // Орел

        Map<AnimalsEnum, Integer> eagleMap = new HashMap<>();
        eagleMap.put(AnimalsEnum.FOX, 10);
        eagleMap.put(AnimalsEnum.RABBIT, 90);
        eagleMap.put(AnimalsEnum.MOUSE, 90);
        eagleMap.put(AnimalsEnum.DUCK, 80);
        animalEnumMap.put(AnimalsEnum.EAGLE, eagleMap);

    }

    private static void initHerbivoreChances() {

        // Кабан

        Map<AnimalsEnum, Integer> boarMap = new HashMap<>();
        boarMap.put(AnimalsEnum.MOUSE, 50);
        boarMap.put(AnimalsEnum.CATERPILLAR, 90);
        animalEnumMap.put(AnimalsEnum.DUCK, boarMap);

        // Мышь

        Map<AnimalsEnum, Integer> mouseMap = new HashMap<>();
        mouseMap.put(AnimalsEnum.CATERPILLAR, 90);
        animalEnumMap.put(AnimalsEnum.DUCK, mouseMap);

        // Утка

        Map<AnimalsEnum, Integer> duckMap = new HashMap<>();
        duckMap.put(AnimalsEnum.CATERPILLAR, 90);
        animalEnumMap.put(AnimalsEnum.DUCK, duckMap);
    }

}

