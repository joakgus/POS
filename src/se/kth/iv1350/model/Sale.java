package se.kth.iv1350.model;

import se.kth.iv1350.integration.ItemDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Holds the current sale.
 */
public class Sale {
    private LocalDateTime startTime;
    private Receipt receipt;
    private ArrayList<ItemDTO> sale;
    private int totalPrice;
    private List<SaleObserver> saleObservers = new ArrayList<>();

    /**
     * Creates a new instance of sale.
     */
    public Sale(){
        startTime =  LocalDateTime.now();
        receipt = new Receipt();
        sale = new ArrayList<ItemDTO>();
    };

    /**
     * Add a item to the current sale.
     * @param item
     */
    public void addItem(ItemDTO item){
        if (item != null) {
            boolean sameArticle = false;
            for (ItemDTO saleItem : sale) {
                if (item.getId() == saleItem.getId()) {
                    saleItem.setQuantity(saleItem.getQuantity() + item.getQuantity());
                    sameArticle = true;
                    break;
                }
            }
            if (sameArticle == false) {
                sale.add(item);
                totalPrice += item.getPrice() * item.getQuantity();
            }
        }
        else {
            System.out.println("Can't find item");
        }
    }

    /**
     * Returns the total price of the sale.
     * @return
     */
    public int endSale(){
        return totalPrice;
    }
    private void notifyObservers(){
        for (SaleObserver obs : saleObservers){
            obs.newSale(totalPrice);
        }
    }

    /**
     * Sends a receipt to print.
     */
    public void sendReceipt(){
        receipt.receipt(startTime,sale, totalPrice);
        notifyObservers();
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public ArrayList<ItemDTO> getItems() {
        return sale;
    }

    public void addSaleObserver(SaleObserver obs) {
        saleObservers.add(obs);
    }

    public void addSaleObservers(List<SaleObserver> observers) {
        saleObservers.addAll(observers);
    }
}
