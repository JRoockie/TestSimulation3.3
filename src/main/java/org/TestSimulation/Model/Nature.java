package org.TestSimulation.Model;

import java.util.concurrent.Callable;

public interface Nature extends Runnable {
    void eat();
    void move(); // у растений возвращать 0
    void multiply();
    void setCoordinates(int x, int y);
    int TICK_RATE = 3000;
}
