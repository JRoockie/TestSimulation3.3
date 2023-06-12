package org.TestSimulation.Model.Herbivores;



import org.TestSimulation.Model.Nature;

import java.util.HashMap;
import java.util.Map;


public class Rabbit extends Herbivore implements Nature {

    private final String ID = "Rabbit";
    private final Map<String,Integer > eatMap = new HashMap<>();{
        eatMap.put("Grass",80);

    }
    public Rabbit(int maxAge) {
        this.maxAge = maxAge;
    }

    private final int maxAge;
    private int age = 0;
    private final int maxWeight = 20;
    private int weight = 2;
    private int weightIncrement = 3;
    private final int maxMovementSpeed = 4;
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
    public void setCoordinates(int x, int y) {

    }

    @Override
    public void setMultiply(boolean isMultiply) {

    }

    @Override
    public void run() {

    }
    @Override
    public String toString() {
        return "\uD83D\uDC07";
    }

}
