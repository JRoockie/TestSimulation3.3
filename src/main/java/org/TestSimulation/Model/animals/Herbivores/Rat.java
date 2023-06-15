package org.TestSimulation.Model.animals.Herbivores;

import org.TestSimulation.Model.animals.Animal;
import org.TestSimulation.Model.plants.Grass;

public class Rat extends Animal {

    public Rat() {
        this(40);
    }

    public Rat(int maxAge) {
        this.eatMap.put(Grass.class, 80);
        this.maxAge = maxAge;
        this.weight = 1;
        this.maxMovementSpeed = 2;
        this.maxNatureCount = 60;
    }

    @Override
    public String toString() {
        return "\uD83D\uDC01";
    }
}
