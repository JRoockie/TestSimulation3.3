package org.TestSimulation.Model.Herbivores;

import org.TestSimulation.Model.Nature;
import java.util.HashMap;
import java.util.Map;

public class Pig  extends Herbivore implements Nature {
    private final String ID = "Pig";
    private final Map<String,Integer > eatMap = new HashMap<>();{
        eatMap.put("Grass",80);

    }
    public Pig(int maxAge) {
        this.maxAge = maxAge;
    }
    private int maxAge;
    private int age = 0;
    private final int maxWeight = 200;
    private int weight = 20;
    private int weightIncrement = 10;
    private final int maxMovementSpeed = 1;
    private int maxSaturation = 100;
    private int saturation = 70 ;
    private int saturationDecrement = 20;
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
    public Object call() throws Exception {
        return null;
    }
    @Override
    public String toString() {
        return "Pig";
    }

}