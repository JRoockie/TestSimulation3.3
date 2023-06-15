package org.TestSimulation.Model;

import org.TestSimulation.Database.Database;
import org.TestSimulation.Database.Island;
import org.TestSimulation.Model.animals.Animal;
import org.TestSimulation.Model.plants.Plant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Model {

    public static Island island = Island.getInstance();
    public static Database database = Database.getInstance();
    public static List<Animal> predatorList = new ArrayList<>();
    public static ArrayList<Nature> simulationList = new ArrayList<>();
    public static List<Plant> plantList = new ArrayList<>();
    public static List<Animal> herbivoreList = new ArrayList<>();
    public static ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);

    public void init() throws Exception {
        UtilityClass.fillAllLists();

        island.setMaxTick(20);
        island.makeIsland(150, 20,100);

        UtilityClass.fillSimulationList(200, 1000 , 100);
//        System.out.println(simulationList.toString());

        island.setStartRandomPosition(simulationList);


        scheduledThreadPool.scheduleWithFixedDelay(island, 0, 2, TimeUnit.SECONDS);
        island.startNature();

    }
}
