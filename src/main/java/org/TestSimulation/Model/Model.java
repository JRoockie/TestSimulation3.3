package org.TestSimulation.Model;


import org.TestSimulation.Database.Database;
import org.TestSimulation.Database.Island;
import org.TestSimulation.Model.Herbivores.Herbivore;
import org.TestSimulation.Model.Plants.Plant;
import org.TestSimulation.Model.Predators.Predator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Model {
    public static Island island = Island.getInstance();
    public static Database database = Database.getInstance();
    public static List<Predator> predatorList = new ArrayList<>();
    public static ArrayList<Nature> simulationList = new ArrayList<>();
    public static List<Plant> plantList = new ArrayList<>();
    public static List<Herbivore> herbivoreList = new ArrayList<>();
    ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);

    public void init() throws Exception {
        UtilityClass.fillAllLists();

        island.setMaxTick(10);
        island.makeIsland(4, 4);

        UtilityClass.fillSimulationList(1, 0, 0);

        island.setStartRandomPosition(simulationList);

//        System.out.println(simulationList.toString());
        scheduledThreadPool.scheduleWithFixedDelay(island, 0, 2, TimeUnit.SECONDS);
        island.startNature();



    }

}
