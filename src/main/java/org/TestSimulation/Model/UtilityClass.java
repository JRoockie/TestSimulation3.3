package org.TestSimulation.Model;

import org.TestSimulation.Model.Factories.NatureFactory;
import org.TestSimulation.Model.Herbivores.Pig;
import org.TestSimulation.Model.Herbivores.Rabbit;
import org.TestSimulation.Model.Herbivores.Sheep;
import org.TestSimulation.Model.Plants.Grass;
import org.TestSimulation.Model.Predators.Dog;
import org.TestSimulation.Model.Predators.Fox;
import org.TestSimulation.Model.Predators.Wolf;

import java.util.concurrent.ThreadLocalRandom;

import static org.TestSimulation.Model.Model.*;

public class UtilityClass {
    public static int random(int bound) {
        return ThreadLocalRandom.current().nextInt(bound);
    }

    public static int random(int from, int to) {
        return ThreadLocalRandom.current().nextInt();
    }
    public static int random(int[] bound){
        return bound[ThreadLocalRandom.current().nextInt(bound.length)] ;
    }


    public static void fillAllLists() {
        fillHerbivoreList();
        fillPlantsList();
        fillPredatorList();
    }

    public static void fillHerbivoreList() {
        herbivoreList.add(new Pig(20));
        herbivoreList.add(new Rabbit(20));
        herbivoreList.add(new Sheep(20));
    }

    public static void fillPredatorList() {
        predatorList.add(new Dog(20));
        predatorList.add(new Fox(20));
        predatorList.add(new Wolf(20));
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







