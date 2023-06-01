package org.TestSimulation.Database;

import java.util.ArrayList;

public class Island implements Runnable{
    private volatile static Island instance;

    private Object[][] matrix;

    public Object[][] getMatrix() {
        return matrix;
    }

    private int xSize;
    private int ySize;

    public void setAnimalPosition(int x, int y){





    }



    public void makeIsland(int x, int y) {
        xSize = x;
        ySize = y;

        matrix = new Object[xSize][ySize];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = new ArrayList<>();
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
