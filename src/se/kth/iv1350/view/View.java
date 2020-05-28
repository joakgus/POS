package se.kth.iv1350.view;

import se.kth.iv1350.controller.Controller;
import se.kth.iv1350.integration.FailToConnectToDatabaseException;
import se.kth.iv1350.integration.ItemNotFoundException;

import java.io.IOException;

/**
 * Is the mocked view of the program
 */
public class View {
    private Controller contr;

    /**
     * Creates a new instance of View.
     * @param contr
     */
    public View(Controller contr){
        this.contr = contr;
        contr.addSaleObserver(new TotalRevenueView());
    }

    /**
     * Is a typical run of a sale.
     */
    public void rfe() throws FailToConnectToDatabaseException{
        contr.startSale();
        try {
            System.out.println("Started new sale");
            contr.enterItem(1, 1);
            contr.enterItem(2345, 10);
            System.out.println("Item 2345 has been added to this sale");
            contr.enterItem(2341, 3);
            System.out.println("item 2341 has been added to this sale");
            int totalprice = contr.endSale();
            System.out.println("Please pay: " + totalprice);
            int change = contr.payment(319);
            System.out.println("please return " + change + " in change");
            contr.startSale();
            System.out.println("Started new sale");
            contr.enterItem(2345, 10);
            System.out.println("Item 2345 has been added to this sale");
            contr.enterItem(2341, 3);
            System.out.println("item 2341 has been added to this sale");
            totalprice = contr.endSale();
            System.out.println("Please pay: " + totalprice);
            change = contr.payment(319);
            System.out.println("please return " + change + " in change");
        } catch (ItemNotFoundException e){
            e.printStackTrace();
        }
    }
}
