package org.TestSimulation.Model.plants;

public class Grass extends Plant{

    public Grass() {
        this(40);
    }

    public Grass(int maxAge) {

        this.maxAge = maxAge;
        this.weight = 20;
        this.maxMovementSpeed = 1;
        this.maxNatureCount = 30;

    }

    @Override
    public String toString() {
        return "\uD83C\uDF3F";
    }

}
