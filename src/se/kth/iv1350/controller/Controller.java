package se.kth.iv1350.controller;

import se.kth.iv1350.integration.ExternalAccounting;
import se.kth.iv1350.integration.ExternalInventory;
import se.kth.iv1350.integration.ItemDTO;
import se.kth.iv1350.model.Sale;

public class Controller{
    private Sale sale;
    private ItemDTO item;
    private ExternalInventory invent;

    /**
     *
     * @param external
     */
    public Controller(ExternalInventory external){
        this.invent = external;
    }

    /**
     * Start a new sale object
     */
    public void startSale() {
        sale = new Sale();
    }

    /**
     * Take two integers to get a item from the "database". First is the id for the product and the second integer is to
     * specify how many of the products
     * @param id
     * @param quantity
     */
    public void enterItem(int id, int quantity){
        this.item = invent.findItem(id, quantity);
        sale.addItem(this.item);
    }

    /**
     * end the sale and returns an integer to specify how much to pay.
     * @return
     */
    public int endSale(){
        return sale.endSale();
    }

    /**
     * take the amount paid and returns how much to money to give to the user customer.
     * @param amount
     * @return
     */
    public int payment(int amount){
        if (sale.getTotalPrice() <= amount){
            ExternalAccounting.sendAmount(amount);
            sale.sendReceipt();
            invent.lowerQuantity(sale);
            return amount - sale.getTotalPrice();
        }
        else {
            System.out.println("Pay more " + (sale.getTotalPrice() - amount));
        }
        return 0;


    }
}
