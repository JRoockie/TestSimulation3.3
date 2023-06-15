package org.TestSimulation.Model.animals.Predators;

import org.TestSimulation.Model.animals.Animal;
import org.TestSimulation.Model.animals.Herbivores.*;

public class Cat extends Animal {
    public Cat() {
        this(40);
    }

    public Cat(int maxAge) {
        eatMap.put(Cat.class, 0);
        eatMap.put(Fox.class, 0);
        eatMap.put(Dog.class, 0);
        eatMap.put(Bear.class, 0);
        eatMap.put(Wolf.class, 10);
        eatMap.put(Pig.class, 30);
        eatMap.put(Sheep.class, 40);
        eatMap.put(Rabbit.class, 90);
        eatMap.put(Chicken.class, 90);
        eatMap.put(Cow.class, 30);
        eatMap.put(Duck.class, 30);
        eatMap.put(Grasshopper.class, 1);
        eatMap.put(Horse.class, 50);
        eatMap.put(Rat.class, 100);
        this.maxAge = maxAge;
        this.weight = 20;
        this.maxMovementSpeed = 2;
        this.maxNatureCount = 30;

    }
    @Override
    public String toString() {
        return "\uD83D\uDC08";
    }
}
