package org.TestSimulation.Model;

import org.TestSimulation.Model.Factories.NatureFactory;
import org.TestSimulation.Model.animals.Herbivores.*;
import org.TestSimulation.Model.animals.Predators.*;
import org.TestSimulation.Model.plants.Grass;

import java.util.concurrent.ThreadLocalRandom;

import static org.TestSimulation.Model.Model.*;

public class UtilityClass {

    public static int random(int bound) {
        return ThreadLocalRandom.current().nextInt(bound);
    }

    public static int random(int[] bound) {
        return bound[ThreadLocalRandom.current().nextInt(bound.length)];
    }

    public static int randomMove(int n) {

        int[] numbers = new int[n * 2];
        int index = 0;
        for (int i = -n; i <= n; i++) {
            if (i != 0) {
                numbers[index] = i;
                index++;
            }
        }
        return random(numbers);
    }


    public static void fillAllLists() {
        fillHerbivoreList();
        fillPlantsList();
        fillPredatorList();
    }

    public static void fillHerbivoreList() {
        herbivoreList.add(new Pig(60));
        herbivoreList.add(new Rabbit(40));
        herbivoreList.add(new Sheep(50));
        herbivoreList.add(new Cow(30));
        herbivoreList.add(new Chicken(30));
        herbivoreList.add(new Deer(60));
        herbivoreList.add(new Duck(40));
        herbivoreList.add(new Grasshopper(50));
        herbivoreList.add(new Horse(60));
        herbivoreList.add(new Rat(20));

    }

    public static void fillPredatorList() {
        predatorList.add(new Dog(50));
        predatorList.add(new Bear(50));
        predatorList.add(new Cat(50));
        predatorList.add(new Fox(50));
        predatorList.add(new Wolf(50));
    }

    public static void fillPlantsList() {
        plantList.add(new Grass(50));
    }

    public static void fillSimulationList(int herbivoreCount, int PlantCount, int PredatorCount) {
        NatureFactory factory = new NatureFactory();

        for (int i = 0; i < herbivoreCount; i++) {
            simulationList.add(factory.createHerbivore());
        }
        for (int i = 0; i < PlantCount; i++) {
            simulationList.add(factory.createPlant());
        }
        for (int i = 0; i < PredatorCount; i++) {
            simulationList.add(factory.createPredator());
        }
    }
}







