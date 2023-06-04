package org.TestSimulation.Database;


import org.TestSimulation.Model.Nature;
import org.TestSimulation.Model.UtilityClass;

import java.util.*;
import java.util.stream.Collectors;

public class Island implements Runnable {
    private volatile static Island instance;

    private Object[][] matrix;

    public Object[][] getMatrix() {
        return matrix;
    }


    private int xSize;
    private int ySize;


    private HashMap<String, Long> currentIndexNature = new HashMap<>();
    private HashMap<String, Long> natureStats;

    public void showIsland() throws Exception {
        fillDisplayMatrix();
        generalNatureStats();

    }

    public void generalNatureStats() {
        List<Nature> statsList = new ArrayList<>();
        natureStats = new HashMap<>();
        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix[x].length; y++) {
                ArrayList<Nature> tempList = (ArrayList<Nature>) matrix[x][y];
                if (!tempList.isEmpty()) {
                    statsList.addAll(tempList);
                    for (var i : statsList.stream().map(Object::toString).collect(Collectors.toSet())) {
                        natureStats.put(i, statsList.stream().filter(k -> Objects.equals(k.toString(), i)).count());
                    }
                }
            }
        }
        System.out.println("----------------------------------------------\n");
        System.out.println("Статистика по острову:\n");
        System.out.println("\t" + natureStats);
        System.out.println("\n----------------------------------------------");
    }

    public void fillDisplayMatrix() throws Exception {
        System.out.println("Как работает дисплей пользователя:\n");
        HashMap<String, Long>[][] result = new HashMap[xSize][ySize];

        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix[x].length; y++) {
                ArrayList<Nature> tempList = (ArrayList<Nature>) matrix[x][y];
                if (!tempList.isEmpty()) {
                    currentIndexNature = new HashMap<>();
                    for (var i : tempList.stream().map(Object::toString).collect(Collectors.toSet())) {
                        currentIndexNature.put(i, tempList.stream().filter(f -> Objects.equals(f.toString(), i)).count());
                    }
                    result[x][y] = currentIndexNature;
                }
            }
        }
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                if (result[i][j] == null) {
                    System.out.print("\t{}");
                } else {
                    System.out.print("\t" + result[i][j]);
                }
            }
            System.out.println();
        }
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
                System.out.print("\t" + matrix[i][j]);
            }
            System.out.println("\t");
        }

        System.out.println("----------------------------------------------\n");
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
