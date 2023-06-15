package org.TestSimulation.Model.animals.Predators;

import org.TestSimulation.Model.animals.Animal;
import org.TestSimulation.Model.animals.Herbivores.*;

public class Bear extends Animal {
    public Bear() {
        this(40);
    }

    public Bear(int maxAge) {
        eatMap.put(Cat.class, 30);
        eatMap.put(Dog.class, 60);
        eatMap.put(Bear.class, 0);
        eatMap.put(Fox.class, 0);
        eatMap.put(Wolf.class, 40);
        eatMap.put(Pig.class, 70);
        eatMap.put(Sheep.class, 70);
        eatMap.put(Rabbit.class, 70);
        eatMap.put(Chicken.class, 40);
        eatMap.put(Cow.class, 30);
        eatMap.put(Duck.class, 30);
        eatMap.put(Grasshopper.class, 1);
        eatMap.put(Horse.class, 50);
        eatMap.put(Rat.class, 20);

        this.maxAge = maxAge;
        this.weight = 20;
        this.maxMovementSpeed = 2;
        this.maxNatureCount = 5;

    }

    @Override
    public String toString() {
        return "\uD83D\uDC3B";
    }
}
