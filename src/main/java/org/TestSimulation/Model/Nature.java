package org.TestSimulation.Model;

import java.util.ArrayList;

abstract public class Nature implements Runnable {

    protected boolean isEaten = false;
    protected boolean isMultiply = false;

    protected ArrayList<Nature> getRawCurrentNode;
    protected Nature partner;
    protected Nature eatableNature;

    protected int maxMovementSpeed;
    protected int maxAge;
    protected int age = 0;
    protected int weight;
    protected int saturation = 60;
    protected int saturationDecrement = 5;
    protected int saturationIncrement = 20;
    protected int xPos;
    protected int yPos;
    protected int currentMultiplyLevel = 0;
    protected int maxMultiplyLevel = 10;
    protected int maxNatureCount;

    public boolean isEaten() {
        return isEaten;
    }

    public void setEaten(boolean eaten) {
        isEaten = eaten;
    }

    public boolean isMultiply() {
        return isMultiply;
    }

    public void setMultiply(boolean multiply) {
        isMultiply = multiply;
    }

    public void setCoordinates(int x, int y) {
        xPos = x;
        yPos = y;
    }

    public int getMaxNatureCount(){
        return maxNatureCount;
    }

    abstract public void action();

    @Override
    public void run() {
        this.action();
    }
}

