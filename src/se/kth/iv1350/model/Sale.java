package se.kth.iv1350.model;

import se.kth.iv1350.integration.ItemDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Sale {
    private LocalDateTime startTime;
    private Receipt receipt;
    private ArrayList<ItemDTO> sale;
    public Sale(){
        startTime =  LocalDateTime.now();
        receipt = new Receipt();
        sale = new ArrayList<ItemDTO>();
    };
    public void addItem(ItemDTO item){
        System.out.println(item.getId());
        sale.add(item);
    }
    public void endSale(){
        receipt.receipt(startTime,sale);
    }

}
