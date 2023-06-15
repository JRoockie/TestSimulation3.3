package org.TestSimulation.Model.animals.Herbivores;

import org.TestSimulation.Model.animals.Animal;
import org.TestSimulation.Model.plants.Grass;

public class Grasshopper extends Animal {
    public Grasshopper() {
        this(40);
    }

    public Grasshopper(int maxAge) {
        this.eatMap.put(Grass.class, 80);
        this.maxAge = maxAge;
        this.weight = 1;
        this.maxMovementSpeed = 1;
        this.maxNatureCount = 100;
    }
    @Override
    public String toString() {
        return "\uD83E\uDD97";
    }
}
