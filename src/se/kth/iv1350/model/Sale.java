package se.kth.iv1350.model;

import se.kth.iv1350.integration.ItemDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Holds the current sale.
 */
public class Sale {
    private LocalDateTime startTime;
    private Receipt receipt;
    private ArrayList<ItemDTO> sale;
    private int totalPrice;

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

    /**
     * Sends a receipt to print.
     */
    public void sendReceipt(){
        receipt.receipt(startTime,sale, totalPrice);
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public ArrayList<ItemDTO> getItems() {
        return sale;
    }
}
