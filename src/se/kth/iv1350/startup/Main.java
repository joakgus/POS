package se.kth.iv1350.startup;
import se.kth.iv1350.controller.Controller;
import se.kth.iv1350.integration.ExternalInventory;
import se.kth.iv1350.integration.FailToConnectToDatabaseException;
import se.kth.iv1350.view.View;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws FailToConnectToDatabaseException {
            ExternalInventory external = new ExternalInventory();
            Controller contr = new Controller(external);
            View view = new View(contr);
            view.rfe();
    }
}
