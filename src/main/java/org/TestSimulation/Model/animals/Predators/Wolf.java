package org.TestSimulation.Model.animals.Predators;


import org.TestSimulation.Model.animals.Animal;
import org.TestSimulation.Model.animals.Herbivores.*;

public class Wolf extends Animal{

    public Wolf() {
        this(40);
    }

    public Wolf(int maxAge) {
        eatMap.put(Cat.class, 40);
        eatMap.put(Dog.class, 60);
        eatMap.put(Bear.class, 0);
        eatMap.put(Wolf.class, 00);
        eatMap.put(Fox.class, 0);
        eatMap.put(Pig.class, 50);
        eatMap.put(Sheep.class, 70);
        eatMap.put(Rabbit.class, 70);
        eatMap.put(Chicken.class, 70);
        eatMap.put(Cow.class, 30);
        eatMap.put(Duck.class, 60);
        eatMap.put(Grasshopper.class, 1);
        eatMap.put(Horse.class, 50);
        eatMap.put(Rat.class, 30);
        this.maxAge = maxAge;
        this.weight = 20;
        this.maxMovementSpeed = 3;
        this.maxNatureCount = 30;
    }

    @Override
    public String toString() {
        return "\uD83D\uDC3A";
    }
}

