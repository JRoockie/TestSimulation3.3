package org.TestSimulation.Model;


import org.TestSimulation.Database.Database;
import org.TestSimulation.Database.Island;
import org.TestSimulation.Model.Herbivores.Herbivore;
import org.TestSimulation.Model.Plants.Plant;
import org.TestSimulation.Model.Predators.Predator;

import java.util.ArrayList;
import java.util.List;

public class Model {
    public static Island island = Island.getInstance();
    public static Database database = Database.getInstance();
    public static List<Predator> predatorList = new ArrayList<>();
    public static ArrayList<Nature> simulationList = new ArrayList<>();
    public static List<Plant> plantList = new ArrayList<>();
    public static List<Herbivore> herbivoreList = new ArrayList<>();

    public void init() throws Exception {
        UtilityClass.fillAllLists();

        island.makeIsland(3, 3);

        UtilityClass.fillSimulationList(3, 5, 4);

        System.out.println(simulationList.toString());

        island.setStartRandomPosition(simulationList);

        island.showIsland();


    }

}
