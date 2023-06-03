package org.TestSimulation.Model.Plants;


import org.TestSimulation.Model.PlantFace;

public class Grass extends Plant implements PlantFace {
    public Grass(int maxAge) {
        this.maxAge = maxAge;
    }

    private final int maxAge;
    private int age = 0;
    @Override
    public void multiply() {

    }
    @Override
    public String toString() {
        return "\uD83C\uDF3F";
    }

}
