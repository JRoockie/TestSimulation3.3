package org.TestSimulation.Model.animals.Herbivores;



import org.TestSimulation.Model.plants.Grass;
import org.TestSimulation.Model.animals.Animal;

public class Sheep extends Animal {
    public Sheep() {
        this(40);
    }

    public Sheep(int maxAge) {
        this.eatMap.put(Grass.class, 80);
        this.maxAge = maxAge;
        this.weight = 30;
        this.maxMovementSpeed = 2;
        this.maxNatureCount = 20;

    }
    @Override
    public String toString() {
        return "\uD83D\uDC0F";
    }

}
