package org.TestSimulation.Database;

import org.TestSimulation.Model.Herbivores.Herbivore;
import org.TestSimulation.Model.Herbivores.Pig;
import org.TestSimulation.Model.Herbivores.Rabbit;
import org.TestSimulation.Model.Herbivores.Sheep;
import org.TestSimulation.Model.Nature;
import org.TestSimulation.Model.Plants.Grass;
import org.TestSimulation.Model.Plants.Plant;
import org.TestSimulation.Model.Predators.Dog;
import org.TestSimulation.Model.Predators.Fox;
import org.TestSimulation.Model.Predators.Predator;
import org.TestSimulation.Model.Predators.Wolf;
import org.TestSimulation.Model.UtilityClass;

import java.util.*;

public class Island implements Runnable {
    private volatile static Island instance;

    private Object[][] matrix;

    public Object[][] getMatrix() {
        return matrix;
    }

    String[][] displayMatrix;

    private int xSize;
    private int ySize;
    private int pigCount = 0;
    private int rabbitCount = 0;
    private int sheepCount = 0;
    private int dogCount = 0;
    private int foxCount = 0;
    private int grassCount = 0;
    private int wolfCount = 0;
    private int plantsCount = 0;
    private int predatorsCount = 0;
    private int herbivoresCount = 0;
    private HashMap<String, Integer> currentIndexNature = new HashMap<>();


    public void showIsland() throws Exception {
        fillDisplayMatrix();
//        for (int i = 0; i < displayMatrix.length; i++) {
//            for (int j = 0; j < displayMatrix[i].length; j++) {
//                System.out.print(displayMatrix[i][j]);
//            }
//            System.out.println();
//        }
    }

    public void fillDisplayMatrix() throws Exception {
        for (int x = 0; x < displayMatrix.length; x++) {
            for (int y = 0; y < displayMatrix[x].length; y++) {
                ArrayList<Nature> tempList = (ArrayList<Nature>) matrix[x][y];
                if (tempList != null) {
                    currentIndexNature = new HashMap<>();
                    for (var i : tempList) {
                        currentIndexNature.put(i.toString(), identifyAnimalCounter(i));

                    }
                    System.out.println("\nКоличество в ячейке");
                    currentIndexNature.forEach((key, value) -> System.out.println(key + ": " + value));
                    System.out.println("-------------------");

                    for (Map.Entry<String, Integer> i : currentIndexNature.entrySet()) {
                        displayMatrix[x][y] = i.getKey() + "(" + i.getValue().toString() + ")";
                    }


                }
            }
        }
    }

    public int identifyAnimalCounter(Nature i) throws Exception {
        int temp = 0;
        if (i instanceof Herbivore) {
            herbivoresCount++;
            if (i instanceof Pig) {
                pigCount++;

                return pigCount;

            } else if (i instanceof Rabbit) {
                rabbitCount++;
                return rabbitCount;
            } else if (i instanceof Sheep) {
                sheepCount++;
                return sheepCount;
            }
        } else if (i instanceof Predator) {
            predatorsCount++;
            if (i instanceof Dog) {
                dogCount++;
                return dogCount;
            } else if (i instanceof Fox) {
                foxCount++;
                return foxCount;
            } else if (i instanceof Wolf) {
                wolfCount++;
                return wolfCount;
            }
        } else if (i instanceof Plant) {
            plantsCount++;
            if (i instanceof Grass) {
                grassCount++;
                return grassCount;
            }

        } else {
            throw new Exception("Неизвестное существо");
        }
        return -1;
    }

    public void setAnimalPosition(int x, int y, Nature nature) {
        if (x < xSize && y < ySize) {
            ArrayList<Nature> tempList = (ArrayList<Nature>) matrix[x][y];
            tempList.add(nature);
            matrix[x][y] = tempList;
        } else {
            throw new RuntimeException("Вариации координат выходят за границы массива");
        }

    }

    public void setStartRandomPosition(ArrayList<Nature> arrayList) {
        for (Nature nature : arrayList) {
            setAnimalPosition(UtilityClass.random(xSize - 1), UtilityClass.random(ySize - 1), nature);
        }
        System.out.println();
        System.out.println("Как на самом деле заполнена матрица Object[][]");
        System.out.println();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }


    public void makeIsland(int x, int y) {
        xSize = x;
        ySize = y;

        matrix = new Object[xSize][ySize];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = new ArrayList<Nature>();
            }
        }

        displayMatrix = new String[xSize][ySize];

    }

    private Island() {
    }

    public static Island getInstance() {
        if (instance == null) { // Первая проверка без блокировки
            synchronized (Island.class) {
                if (instance == null) { // Вторая проверка внутри синхронизированного блока
                    instance = new Island();
                }
            }
        }
        return instance;
    }

    @Override
    public void run() {

    }
}
