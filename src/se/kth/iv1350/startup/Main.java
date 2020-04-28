package se.kth.iv1350.startup;
import se.kth.iv1350.controller.Controller;
import se.kth.iv1350.integration.ExternalInventory;
import se.kth.iv1350.view.View;

public class Main {

    public static void main(String[] args) {
        Controller contr = new Controller();
        View view = new View(contr);
        ExternalInventory external = new ExternalInventory();
        view.rfe();
    }
}
