package org.TestSimulation.Model.Plants;


import org.TestSimulation.Model.Nature;
import org.TestSimulation.Model.PlantFace;

import java.util.concurrent.Callable;

public class Grass extends Plant implements PlantFace,Nature {
    public Grass(int maxAge) {
        this.maxAge = maxAge;
    }

    private final int maxAge;
    private int age = 0;
    private int xPos = 0;
    private int yPos = 0;
    @Override
    public void multiply() {

    }

    @Override
    public void setCoordinates(int x, int y) {

    }



    @Override
    public void run() {

    }
    @Override
    public String toString() {
        return "\uD83C\uDF3F";
    }


}
