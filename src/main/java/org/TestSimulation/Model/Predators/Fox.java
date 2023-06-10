package org.TestSimulation.Model.Predators;


import org.TestSimulation.Model.Nature;

import java.util.HashMap;
import java.util.Map;

public class Fox  extends Predator implements Nature {
    private final String ID = "Fox";
    private final Map<String,Integer > eatMap = new HashMap<>();{
        eatMap.put("Cat",30);
        eatMap.put("Dog",60);
        eatMap.put("Bear",0);
        eatMap.put("Wolf",40);
    }

    public Fox(int maxAge) {
        this.maxAge = maxAge;
    }

    private int maxAge;
    private int age = 0;
    private final int maxWeight = 80;
    private int weight = 10;
    private int weightIncrement = 5;
    private final int maxMovementSpeed = 2;
    private int maxSaturation = 100;
    private int saturation = 70 ;
    private int saturationDecrement = 10;
    private int xPos = 0;
    private int yPos = 0;

    @Override
    public void eat() {

    }

    @Override
    public void move() {

    }

    @Override
    public void multiply() {

    }

    @Override
    public void run() {

    }

    @Override
    public String toString() {
        return "\uD83E\uDD8A";
    }
}

