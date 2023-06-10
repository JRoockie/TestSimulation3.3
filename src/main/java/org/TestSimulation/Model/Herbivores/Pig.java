package org.TestSimulation.Model.Herbivores;

import org.TestSimulation.Database.Island;
import org.TestSimulation.Model.Nature;
import org.TestSimulation.Model.Plants.Plant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.TestSimulation.Database.Island.MAX_TICK;

public class Pig extends Herbivore implements Nature {
    public volatile boolean isEaten = false;
    public volatile boolean isMultiply = false;
    public volatile boolean isMoved = false;

    private final String ID = "Pig";
    private final Map<String, Integer> eatMap = new HashMap<>();

    {
        eatMap.put("\uD83C\uDF3F", 80);

    }

    public Pig(int maxAge) {
        this.maxAge = maxAge;
    }

    public ArrayList<Nature> getCurrentNode;
    private int maxAge;
    private int age = 0;
    private final int maxWeight = 200;
    private int weight = 20;
    private int weightIncrement = 10;
    private final int maxMovementSpeed = 1;
    private int maxSaturation = 100;
    private int saturation = 70;
    private int saturationDecrement = 10;
    private int saturationIncrement = 20;
    private int xPos = 0;
    private int yPos = 0;


    @Override
    public void eat() {
        System.out.println("im eating " + saturation);
        saturation += saturationIncrement;

    }

    @Override
    public void move() {
        System.out.println("i'm moving " + saturation);

    }

    @Override
    public void multiply() {


        System.out.println("im multiplying " + saturation);

    }

    @Override
    public void setCoordinates(int x, int y) {
        xPos = x;
        yPos = y;
    }

    public void action() {

    }

    public boolean wantMultiply() {

        return false;
    }

    public boolean wantEat() {
        for (var i : getCurrentNode) {
            if (i instanceof Plant){
                return true;
            }
        }
        return false;
    }

    @Override
    public void run() {

        while (saturation != 0 && age < maxAge && !isEaten) {

            getCurrentNode = (ArrayList<Nature>) Island.getInstance().getMatrix()[xPos][yPos];

            if (wantEat()) {
                eat();
            } else if (wantMultiply()) {
                multiply();
            } else {
                move();
            }

            saturation -= saturationDecrement;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        Thread.currentThread().interrupt();

    }

    @Override
    public String toString() {
        return "\uD83D\uDC16";
    }
}
