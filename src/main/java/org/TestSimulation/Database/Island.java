package org.TestSimulation.Database;

import org.TestSimulation.Model.Nature;
import org.TestSimulation.Model.UtilityClass;

import java.util.ArrayList;

public class Island implements Runnable {
    private volatile static Island instance;

    private Object[][] matrix;

    public Object[][] getMatrix() {
        return matrix;
    }

    Object[][] displayMatrix;

    private int xSize;
    private int ySize;

    private int pigCount = 0;
    private int RabbitCount = 0;
    private int SheepCount = 0;
    private int plantsCount = 0;
    private int dogCount = 0;
    private int FoxCount = 0;
    private int WolfCount = 0;
    private int PredatorsCount = 0;
    private int PlantsCount = 0;
    private int HerbivoresCount = 0;

    public void showIsland() {



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

        displayMatrix = new Object[xSize][ySize];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = new ArrayList<String>();
            }
        }
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
