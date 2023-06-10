package org.TestSimulation.Model.Herbivores;



import org.TestSimulation.Model.Nature;
import java.util.HashMap;
import java.util.Map;

public class Sheep extends Herbivore implements Nature {
    private final String ID = "Sheep";
    private final Map<String,Integer > eatMap = new HashMap<>();{
        eatMap.put("Grass",80);

    }
    public Sheep(int maxAge) {
        this.maxAge = maxAge;
    }

    private int maxAge;
    private int age = 0;
    private final int maxWeight = 150;
    private int weight = 10;
    private int weightIncrement = 15;
    private final int maxMovementSpeed = 1;
    private int maxSaturation = 100;
    private int saturation = 70 ;
    private int saturationDecrement = 20;
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
        return "\uD83D\uDC0F";
    }

}
