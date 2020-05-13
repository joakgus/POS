package se.kth.iv1350.controller;

import se.kth.iv1350.integration.*;
import se.kth.iv1350.model.Sale;
import se.kth.iv1350.model.SaleObserver;
import se.kth.iv1350.view.TotalRevenueView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Controller{
    private Sale sale;
    private ItemDTO item;
    private ExternalInventory invent;
    private List<SaleObserver> saleObservers = new ArrayList<>();
    private LogHandler i;
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
        try {
            this.item = invent.findItem(id, quantity);

        }catch (ItemNotFoundException e){
            try {
                this.i = new LogHandler();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            i.logException(e);
        }
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
        sale.addSaleObservers(saleObservers);
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

    public void addSaleObserver(SaleObserver obs) {
        saleObservers.add(obs);
    }
}
