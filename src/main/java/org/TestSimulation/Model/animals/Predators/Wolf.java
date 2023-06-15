package org.TestSimulation.Model.animals.Predators;


import org.TestSimulation.Model.animals.Animal;
import org.TestSimulation.Model.animals.Herbivores.Pig;
import org.TestSimulation.Model.animals.Herbivores.Rabbit;
import org.TestSimulation.Model.animals.Herbivores.Sheep;

public class Wolf extends Animal{

    public Wolf() {
        this(40);
    }

    public Wolf(int maxAge) {
//        eatMap.put("Bear",0);
//        eatMap.put("Cat",50);
//        eatMap.put("Dog",20);
//        eatMap.put("Fox",10);
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
        return "\uD83D\uDC3A";
    }
}

