package org.TestSimulation.Model.Factories;

import org.TestSimulation.Model.Herbivores.Pig;
import org.TestSimulation.Model.Herbivores.Rabbit;
import org.TestSimulation.Model.Herbivores.Sheep;
import org.TestSimulation.Model.Nature;
import org.TestSimulation.Model.Plants.Grass;
import org.TestSimulation.Model.Predators.Dog;
import org.TestSimulation.Model.Predators.Fox;
import org.TestSimulation.Model.Predators.Wolf;
import org.TestSimulation.Model.UtilityClass;

public class NatureFactory {

    public Nature createHerbivore(){
        var random = UtilityClass.random(3);

        return switch (random) {
            case 0 -> new Pig(UtilityClass.random(40));
            case 1 -> new Sheep((UtilityClass.random(40)));
            default -> new Rabbit((UtilityClass.random(40)));


        };
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
