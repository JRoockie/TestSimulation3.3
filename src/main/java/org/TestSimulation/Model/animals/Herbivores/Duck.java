package org.TestSimulation.Model.animals.Herbivores;

import org.TestSimulation.Model.animals.Animal;
import org.TestSimulation.Model.plants.Grass;

public class Duck extends Animal {
    public Duck() {
        this(40);
    }

    public Duck(int maxAge) {
        this.eatMap.put(Grass.class, 80);
        this.maxAge = maxAge;
        this.weight = 10;
        this.maxMovementSpeed = 2;
        this.maxNatureCount = 40;
    }
    @Override
    public String toString() {
        return "\uD83E\uDD86";
    }
}
