package org.TestSimulation.Model.animals.Predators;



import org.TestSimulation.Model.animals.Animal;
import org.TestSimulation.Model.animals.Herbivores.Pig;
import org.TestSimulation.Model.animals.Herbivores.Rabbit;
import org.TestSimulation.Model.animals.Herbivores.Sheep;

public class Dog extends Animal {

    public Dog() {
        this(40);
    }

    public Dog(int maxAge) {
//        eatMap.put("Cat", 65);
//        eatMap.put("Dog", 40);
//        eatMap.put("Fox", 30);
//        eatMap.put("Wolf", 20);
        eatMap.put(Pig.class, 70);
        eatMap.put(Sheep.class, 70);
        eatMap.put(Rabbit.class, 70);
        this.maxAge = maxAge;
        this.weight = 20;
        this.maxMovementSpeed = 1;
        this.maxNatureCount = 30;

    }
    @Override
    public String toString() {
        return "\uD83D\uDC15";
    }
}
