package org.TestSimulation.Model.Herbivores;

import org.TestSimulation.Database.Island;
import org.TestSimulation.Model.Factories.NatureFactory;
import org.TestSimulation.Model.Nature;
import org.TestSimulation.Model.Plants.Plant;
import org.TestSimulation.Model.UtilityClass;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;


public class Pig extends Herbivore implements Nature {
    public boolean isEaten = false;
    public boolean isMultiply = false;
    public boolean isMoved = false;

    public String getID() {
        return ID;
    }

    private final String ID = "Pig";
    private final Map<String, Integer> eatMap = new HashMap<>();

    {
        eatMap.put("\uD83C\uDF3F", 80);
    }

    public Pig(int maxAge) {
        this.maxAge = maxAge;
    }

    public Pig() {
        maxAge = 40;
    }

    public ArrayList<Nature> getRawCurrentNode;

    private int maxAge;
    private int age = 0;
    private final int maxWeight = 200;
    private int weight = 20;
    private int weightIncrement = 10;
    private final int maxMovementSpeed = 1;
    private final int[] movementSpeedArray = new int[]{1, -1};
    private int maxSaturation = 100;
    private int saturation = 60;
    private int saturationDecrement = 10;
    private int saturationIncrement = 20;
    private int xPos = 0;
    private int yPos = 0;

    private int currentMultiplyLevel = 1;
    private int maxMultiplyLevel = 3;

    private Nature partner;

    @Override
    public void eat() {

        System.out.println(this + " im eating " + saturation);

        saturation += saturationIncrement;

    }

    @Override
    public void move() {
        synchronized (Island.class) {

            Island island = Island.getInstance();

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
                int newY = yPos + randomY;
                int newX = xPos + randomX;
                island.removeAnimal(xPos, yPos, this);
                island.setAnimalPosition(newX, newY, this);
            }
        }
        System.out.println(this + " i'm moving " + saturation);


    }

    @Override
    public void multiply() {
        //блокировать свинью, если ее выбрали для спаривания.
        // Чтобы свинья ожидала спаривания, и не делала ничего

        System.out.println(this + "@" + this.hashCode() + " im multiplying with" + saturation + "@" + partner.hashCode());

        partner = null;
        currentMultiplyLevel = 0;
    }

    @Override
    public void setCoordinates(int x, int y) {
        xPos = x;
        yPos = y;
    }

    @Override
    public boolean get() {
        return isMultiply;
    }

    @Override
    public void setMultiply(boolean isMultiply) {
        this.isMultiply = isMultiply;
    }

    public void action() {

    }

    public boolean wantMultiply() {
        if (isMultiply == true) {
            return false;
        }
        if (currentMultiplyLevel != maxMultiplyLevel) {
            return false;
        }
        synchronized (Island.class) {
            if (saturation >= 70) {
                try {
                    getRawCurrentNode = Island.getInstance().showActualNode(xPos, yPos);
                    ArrayList<Nature> list = (ArrayList<Nature>) getRawCurrentNode.stream()
                            .filter(x -> x != this && x.getClass().isInstance(this))
                            .collect(Collectors.toList());
                    partner = list.get(UtilityClass.random(list.size()));
                    partner.setMultiply(true);
                    return true;
                } catch (RuntimeException e) {
                    System.out.println("No pigs nearby");
                    return false;
                }

            }
            return false;
        }
    }

    public boolean wantEat() {
        synchronized (Island.class) {
            ArrayList<Nature> temp = (ArrayList<Nature>) Island.getInstance().getMatrix()[xPos][yPos];
            if (this.saturation < 70) {
                for (var i : temp) {
                    if (i instanceof Plant) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    @Override
    public void run() {

        while (saturation != 0 && age < maxAge && !isEaten && Island.getInstance().isOver()) {
            if (!isMultiply) {
                if (currentMultiplyLevel < maxMultiplyLevel) {
                    currentMultiplyLevel++;
                } else {
                    currentMultiplyLevel = maxMultiplyLevel;
                }
                if (wantEat()) {
                    eat();

                } else if (wantMultiply()) {
                    multiply();
                    // Не забыть о том, что первая свинья может мгновенно сдохнуть от размножения
                    // ты написал переменные- флаги наверху
                } else {
                    move();
                }
            }
            saturation -= saturationDecrement;

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if (isMultiply) {
                isMultiply = false;
                currentMultiplyLevel = 0;
                try {
                    Island.getInstance().setAnimalPosition(xPos, yPos, NatureFactory.create(this.getClass()));

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
        }


        Island island = Island.getInstance();
        island.removeDead(this, xPos, yPos);

        Thread.currentThread().interrupt();


    }

    @Override
    public String toString() {
        return "\uD83D\uDC16";
    }
}
