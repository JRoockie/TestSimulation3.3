package org.TestSimulation.Model.animals.Herbivores;

import org.TestSimulation.Model.plants.Grass;
import org.TestSimulation.Model.animals.Animal;


public class Pig extends Animal {

    public Pig() {
        this(40);
    }

    public Pig(int maxAge) {
        this.eatMap.put(Grass.class, 80);
        this.maxAge = maxAge;
        this.weight = 50;
        this.maxMovementSpeed = 2;
        this.maxNatureCount = 40;
    }

    @Override
    public String toString ()  {
        return "\uD83D\uDC16";
    }
}
