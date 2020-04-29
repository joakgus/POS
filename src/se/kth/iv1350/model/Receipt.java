package se.kth.iv1350.model;

import se.kth.iv1350.integration.ItemDTO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * Holds and object of receipt.
 */
public class Receipt {
    private LocalDateTime time;
    private ArrayList<ItemDTO> boughtItems;
    private int totalprice;
    private int totalvat;
    private String storename;
    private String address;

    private void createNewReceipt(){
        boughtItems =  new ArrayList<ItemDTO>();
        storename = "Apple";
        address = "Sveavagen 8";
    }
    /**
     * Creates new instance of a receipt.
     */
    public Receipt(){
        createNewReceipt();
    }

    /**
     * Prints out the receipt
     * @param startTime
     * @param sale
     * @param saletotalprice
     */
    public void receipt(LocalDateTime startTime, ArrayList<ItemDTO> sale, int saletotalprice){
        this.totalprice = saletotalprice;
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        boughtItems = sale;
        time = startTime;
        System.out.println(startTime.format(formatter));
        for (ItemDTO item:boughtItems) {
            System.out.println(item.getPrice() + "kr " + item.getVat()+" tax "+ item.getQuantity()+"st");
        }
        System.out.println(totalprice);
        System.out.println(address);
        System.out.println(storename);
    }

}
