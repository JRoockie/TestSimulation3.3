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
        return "Rabbit";
    }

}
