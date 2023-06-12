package org.TestSimulation.Model.Predators;


import org.TestSimulation.Model.Nature;

import java.util.HashMap;
import java.util.Map;

public class Wolf extends Predator implements Nature {
    private final String ID = "Wolf";

    private final Map<String,Integer > eatMap = new HashMap<>();{
        eatMap.put("Bear",0);
        eatMap.put("Cat",50);
        eatMap.put("Dog",20);
        eatMap.put("Fox",10);
    }

    public Wolf(int maxAge) {
        this.maxAge = maxAge;
    }
    private int maxAge;
    private int age = 0;
    private final int maxWeight = 50;
    private int weight = 10;
    private int weightIncrement = 5;
    private final int maxMovementSpeed = 3;
    private int maxSaturation = 100;
    private int saturation = 70 ;
    private int saturationDecrement = 10;
    private int xPos = 0;
    private int yPos = 0;
    public boolean isEaten = false;
    @Override
    public void setEaten(boolean isEaten){
        this.isEaten = true;
    }

    @Override
    public boolean getEaten() {
        return isEaten;
    }
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
        return "\uD83D\uDC3A";
    }
}

