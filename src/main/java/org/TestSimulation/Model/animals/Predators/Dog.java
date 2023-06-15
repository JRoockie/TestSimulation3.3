package org.TestSimulation.Model.animals.Predators;



import org.TestSimulation.Model.animals.Animal;
import org.TestSimulation.Model.animals.Herbivores.*;

public class Dog extends Animal {

    public Dog() {
        this(20);
    }

    public Dog(int maxAge) {
        eatMap.put(Cat.class, 30);
        eatMap.put(Dog.class, 0);
        eatMap.put(Fox.class, 20);
        eatMap.put(Bear.class, 0);
        eatMap.put(Wolf.class, 20);
        eatMap.put(Pig.class, 30);
        eatMap.put(Sheep.class, 40);
        eatMap.put(Rabbit.class, 90);
        eatMap.put(Chicken.class, 90);
        eatMap.put(Cow.class, 20);
        eatMap.put(Duck.class, 90);
        eatMap.put(Grasshopper.class, 1);
        eatMap.put(Horse.class, 20);
        eatMap.put(Rat.class, 70);
        this.maxAge = maxAge;
        this.weight = 10;
        this.maxMovementSpeed = 2;
        this.maxNatureCount = 20;

    }
    @Override
    public String toString() {
        return "\uD83D\uDC15";
    }
}
