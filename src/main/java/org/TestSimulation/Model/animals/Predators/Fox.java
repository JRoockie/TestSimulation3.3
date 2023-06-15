package org.TestSimulation.Model.animals.Predators;


import org.TestSimulation.Model.animals.Animal;
import org.TestSimulation.Model.animals.Herbivores.*;

public class Fox  extends Animal {

    public Fox() {
        this(40);
    }

    public Fox(int maxAge) {
        eatMap.put(Cat.class, 50);
        eatMap.put(Dog.class, 30);
        eatMap.put(Bear.class, 0);
        eatMap.put(Wolf.class, 30);
        eatMap.put(Pig.class, 40);
        eatMap.put(Sheep.class, 50);
        eatMap.put(Rabbit.class, 40);
        eatMap.put(Chicken.class, 80);
        eatMap.put(Cow.class, 30);
        eatMap.put(Duck.class, 30);
        eatMap.put(Grasshopper.class, 1);
        eatMap.put(Horse.class, 50);
        eatMap.put(Rat.class, 70);
        eatMap.put(Fox.class, 0);
        this.maxAge = maxAge;
        this.weight = 20;
        this.maxMovementSpeed = 2;
        this.maxNatureCount = 30;

    }
    @Override
    public String toString() {
        return "\uD83E\uDD8A";
    }
}

