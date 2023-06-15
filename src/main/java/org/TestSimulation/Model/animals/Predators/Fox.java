package org.TestSimulation.Model.animals.Predators;


import org.TestSimulation.Model.animals.Animal;
import org.TestSimulation.Model.animals.Herbivores.Pig;
import org.TestSimulation.Model.animals.Herbivores.Rabbit;
import org.TestSimulation.Model.animals.Herbivores.Sheep;

public class Fox  extends Animal {

    public Fox() {
        this(40);
    }

    public Fox(int maxAge) {
//        eatMap.put("Cat",30);
//        eatMap.put("Dog",60);
//        eatMap.put("Bear",0);
//        eatMap.put("Wolf",40);
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
        return "\uD83E\uDD8A";
    }
}

