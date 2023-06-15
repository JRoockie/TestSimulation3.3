package org.TestSimulation.Model.Factories;

import org.TestSimulation.Model.animals.Herbivores.Pig;
import org.TestSimulation.Model.animals.Herbivores.Rabbit;
import org.TestSimulation.Model.animals.Herbivores.Sheep;
import org.TestSimulation.Model.Nature;
import org.TestSimulation.Model.plants.Grass;
import org.TestSimulation.Model.animals.Predators.Dog;
import org.TestSimulation.Model.animals.Predators.Fox;
import org.TestSimulation.Model.animals.Predators.Wolf;
import org.TestSimulation.Model.UtilityClass;

import java.lang.reflect.InvocationTargetException;

public class NatureFactory {

    public Nature createHerbivore(){
        var random = UtilityClass.random(3);

//        return switch (random) {
//            case 0 -> new Pig(UtilityClass.random(40));
//            case 1 -> new Sheep((UtilityClass.random(40)));
//            default -> new Rabbit((UtilityClass.random(40)));
//
//
//        };
        return new Pig(UtilityClass.random(40));
    }
    public static Nature create(Class<?> clazz) {
        try {
            return (Nature) clazz.getDeclaredConstructor().newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
    public Nature createPredator(){
        var random = UtilityClass.random(3);

        return switch (random) {
            case 0 -> new Dog(UtilityClass.random(40));
            case 1 -> new Wolf((UtilityClass.random(40)));
            default -> new Fox((UtilityClass.random(40)));
        };
    }

    public Nature createPlant(){
        var random = UtilityClass.random(2);

        return switch (random) {
            default -> new Grass((UtilityClass.random(40)));
        };
    }

}
