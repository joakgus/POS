package se.kth.iv1350.controller;

import se.kth.iv1350.integration.ExternalInventory;
import se.kth.iv1350.integration.ItemDTO;
import se.kth.iv1350.model.Sale;

public class Controller {
    private Sale sale;
    private ItemDTO item;
    private ExternalInventory invent;

    public void startSale() {
        sale = new Sale();
        invent = new ExternalInventory();
    }

    public void enterItem(int id, int quantity){
        this.item = invent.findItem(id, quantity);
        System.out.println(item.getId());
        sale.addItem(this.item);
    }

    public void endSale(){
        sale.endSale();
    }
}
