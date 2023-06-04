package org.TestSimulation;


import org.TestSimulation.Controller.Controller;
import org.TestSimulation.Database.Database;
import org.TestSimulation.Database.Island;
import org.TestSimulation.Model.Model;
import org.TestSimulation.Model.UtilityClass;
import org.TestSimulation.View.View;

public class MainMVC {
    public static Island island = Island.getInstance();
    public static Database database = Database.getInstance();

    public static void main(String[] args) throws Exception {

        Model model = new Model();
        Controller controller = new Controller(model);
        View view = new View(controller);

        model.init();

    }
}