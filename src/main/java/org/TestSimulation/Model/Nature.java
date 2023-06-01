package org.TestSimulation.Model;

import java.util.concurrent.Callable;

public interface Nature extends Callable {
    void eat();
    void move();
    void multiply();
}
