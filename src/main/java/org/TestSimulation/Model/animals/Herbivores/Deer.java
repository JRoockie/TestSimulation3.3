package org.TestSimulation.Model.animals.Herbivores;

import org.TestSimulation.Model.animals.Animal;
import org.TestSimulation.Model.plants.Grass;

public class Deer extends Animal {
    public Deer() {
        this(40);
    }

    public Deer(int maxAge) {
        this.eatMap.put(Grass.class, 80);
        this.maxAge = maxAge;
        this.weight = 40;
        this.maxMovementSpeed = 2;
        this.maxNatureCount = 20;
    }
    @Override
    public String toString() {
        return "\uD83E\uDD8C";
    }
}
