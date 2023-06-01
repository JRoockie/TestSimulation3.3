package org.TestSimulation.Model.Predators;



import org.TestSimulation.Model.Nature;

import java.util.HashMap;
import java.util.Map;

public class Dog  extends Predator implements Nature {
    private final String ID = "Dog";


    private final Map<String, Integer> eatMap = new HashMap<>();

    {
        eatMap.put("Cat", 65);
        eatMap.put("Dog", 40);
        eatMap.put("Fox", 30);
        eatMap.put("Wolf", 20);
    }

    public Dog(int maxAge) {
        this.maxAge = maxAge;
    }

    private int maxAge;
    private int age = 0;
    private final int maxWeight = 50;
    private int weight = 15;
    private int weightIncrement = 3;
    private final int maxMovementSpeed = 2;
    private int maxSaturation = 100;
    private int saturation = 70;
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
        return "Dog";
    }
}