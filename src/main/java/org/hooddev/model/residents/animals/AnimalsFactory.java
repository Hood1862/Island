package org.hooddev.model.residents.animals;

import org.hooddev.model.residents.animals.Herbivore.*;
import org.hooddev.model.residents.animals.Predator.*;

public class AnimalsFactory {

    public static Animal getAnimal(AnimalsEnum animalEnum) {
        return switch (animalEnum) {
            case WOLF -> new Wolf();
            case SNAKE -> new Snake();
            case FOX -> new Fox();
            case BEAR -> new Bear();
            case EAGLE -> new Eagle();
            case HORSE -> new Horse();
            case DEER -> new Deer();
            case RABBIT -> new Rabbit();
            case MOUSE -> new Mouse();
            case GOAT -> new Goat();
            case SHEEP -> new Sheep();
            case BOAR -> new Boar();
            case BUFFALO -> new Buffalo();
            case DUCK -> new Duck();
            case CATERPILLAR -> new Caterpillar();
            default -> null;
        };
        }
    }

