package org.TestSimulation.Model.Plants;


import org.TestSimulation.Database.Island;
import org.TestSimulation.Model.Factories.NatureFactory;
import org.TestSimulation.Model.Nature;
import org.TestSimulation.Model.PlantFace;
import org.TestSimulation.Model.UtilityClass;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

public class Grass extends Plant implements PlantFace, Nature {
    public Grass(int maxAge) {
        this.maxAge = maxAge;
    }

    public Grass() {
        this.maxAge = 40;
    }

    private int chanceOfExpansion = 10;
    private final int[] movementSpeedArray = new int[]{1, -1};
    public boolean isEaten = false;
    @Override
    public void setEaten(boolean isEaten){
        this.isEaten = true;
    }

    @Override
    public boolean getEaten() {
        return isEaten;
    }
    private int currentMultiplyLevel = 1;
    private int maxMultiplyLevel = 5;
    private final int maxAge;
    private int age = 0;
    private int xPos = 0;
    private int yPos = 0;

    public boolean wantMultiply() {
        return currentMultiplyLevel == maxMultiplyLevel;
    }

    @Override
    public void multiply() {
        int newY = yPos;
        int newX = xPos;
        currentMultiplyLevel = 0;
        try {
            synchronized (Island.class) {
                Island island = Island.getInstance();
                if (chanceOfExpansion > UtilityClass.random(100)) {
                    int randomX = UtilityClass.random(movementSpeedArray);
                    int randomY = UtilityClass.random(movementSpeedArray);
                    if (randomX + xPos < 0 || randomY + yPos < 0) {
                        if (randomX + xPos < 0) {
                            randomX = Math.abs(randomX);
                        }
                        if (randomY + yPos < 0) {
                            randomY = Math.abs(randomY);
                        }
                    }
                    if (randomX + xPos > island.getxSize() - 1 || randomY + yPos > island.getySize() - 1) {
                        if (randomX + xPos > island.getxSize()) {
                            randomX = -randomX;
                        }
                        if (randomY + yPos > island.getySize()) {
                            randomY = -randomY;
                        }
                    }
                    if (xPos + randomX < island.getxSize() && yPos + randomY < island.getySize()) {
                        newY = yPos + randomY;
                        newX = xPos + randomX;
                    }
                }
            }
            Island.getInstance().setAnimalPosition(newX, newY, NatureFactory.create(this.getClass()));
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void setCoordinates(int x, int y) {
        xPos = x;
        yPos = y;
    }

    @Override
    public void run() {
        while (age < maxAge && !isEaten && Island.getInstance().isOver()) {
            if (currentMultiplyLevel < maxMultiplyLevel) {
                currentMultiplyLevel++;
            } else {
                currentMultiplyLevel = maxMultiplyLevel;
            }
            if (wantMultiply()) {
                multiply();

            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        Island island = Island.getInstance();
        island.removeDead(this, xPos, yPos);
        Thread.currentThread().interrupt();
    }


    @Override
    public String toString() {
        return "\uD83C\uDF3F";
    }


}
