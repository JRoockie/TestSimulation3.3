package org.TestSimulation.Database;

public class Database {
    private static Database INSTANCEDATA;
    public static Database getInstance() {
        if (INSTANCEDATA == null) {
            INSTANCEDATA = new Database();
        }
        return INSTANCEDATA;
    }









}
