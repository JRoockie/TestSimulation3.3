package org.TestSimulation.Model;

public interface Nature extends Runnable {
    void eat();
    void move(); // у растений возвращать 0
    void multiply();
    void setCoordinates(int x, int y);

    default boolean get() {
        return false;
    }
    void setMultiply(boolean isMultiply);
    void setEaten(boolean isEaten);
    boolean getEaten();


}
