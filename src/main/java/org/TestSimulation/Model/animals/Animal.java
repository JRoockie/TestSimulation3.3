package org.TestSimulation.Model.animals;

import org.TestSimulation.Database.Island;
import org.TestSimulation.Model.*;
import org.TestSimulation.Model.Factories.NatureFactory;
import org.TestSimulation.Model.behavior.CouldEat;
import org.TestSimulation.Model.behavior.CouldMove;
import org.TestSimulation.Model.behavior.CouldMultiply;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class Animal extends Nature implements CouldEat, CouldMultiply, CouldMove {
    protected final Map<Class<?>, Integer> eatMap = new HashMap<>();

    public boolean wantMultiply() {
        if (isMultiply) {
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
//                    System.out.println("No pigs nearby");
                    return false;
                }
            }
            return false;
        }
    }

    public void multiply() {
//        System.out.println(this + "@" + this.hashCode() + " im multiplying with" + saturation + "@" + partner.hashCode());
        partner = null;
        currentMultiplyLevel = 0;
    }

    public boolean wantEat() {

        synchronized (Island.class) {
            ArrayList<Nature> temp = (ArrayList<Nature>) Island.getInstance().getMatrix()[xPos][yPos];
            if (this.saturation < 70) {
                for (var i : temp) {
                    if (eatMap.containsKey(i.getClass())) {

                        return true;

                    }
                }
            }
            return false;
        }
    }

    //    public void eat(Class<?> clazz) {
    public void eat() {
        synchronized (Island.class) {
            try {

                getRawCurrentNode = Island.getInstance().showActualNode(xPos, yPos);
                ArrayList<Nature> list = (ArrayList<Nature>) getRawCurrentNode.stream()
                        .filter(x -> eatMap.containsKey(x.getClass()))
                        .collect(Collectors.toList());
                // eatmap сюда вставить

                eatableNature = list.get(UtilityClass.random(list.size()));
                boolean chance = eatMap.get(eatableNature.getClass()) >= UtilityClass.random(100);
                if (!eatableNature.isEaten() && chance) {
                    eatableNature.setEaten(true);
                    saturation += saturationIncrement;
//                    System.out.println(this + " im eating " + saturation);
                } else {
                    throw new RuntimeException();
                }
            } catch (RuntimeException e) {
//                System.out.println("Nothing to eat " + saturation);
            }
        }
    }

    public void move() {
        synchronized (Island.class) {

            Island island = Island.getInstance();

            int randomX = UtilityClass.randomMove(maxMovementSpeed);
            int randomY = UtilityClass.randomMove(maxMovementSpeed);

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

                if(island.checkAnimalCount(newX,newY, this)){
                    island.removeAnimal(xPos, yPos, this);
                    island.setAnimalPosition(newX, newY, this);
                }
            }
        }
//        System.out.println(this + " i'm moving " + saturation);
    }

    public void action() {
        while (saturation != 0 && age < maxAge && !isEaten && Island.getInstance().isOver()) {
            age++;
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
                Island.getInstance().setAnimalPosition(xPos, yPos, NatureFactory.create(this.getClass()));
            }
        }
        Island island = Island.getInstance();
        island.removeDead(this, xPos, yPos);
        Thread.currentThread().interrupt();
    }
}
