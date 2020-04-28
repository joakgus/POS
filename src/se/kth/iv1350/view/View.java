package se.kth.iv1350.view;

import se.kth.iv1350.controller.Controller;

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
    }

    /**
     * Is a typical run of a sale.
     */
    public void rfe(){
        contr.startSale();
        System.out.println("Started new sale");
        contr.enterItem(2345,10);
        System.out.println("Item 2345 has been added to this sale");
        contr.enterItem(2341,3);
        System.out.println("item 2341 has been added to this sale");
        int totalprice = contr.endSale();
        System.out.println("Please pay: " + totalprice);
        int change = contr.payment(319);
        System.out.println("please return "+ change + " in change");
    }
}
