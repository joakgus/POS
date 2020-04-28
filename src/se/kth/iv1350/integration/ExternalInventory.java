package se.kth.iv1350.integration;

import java.util.ArrayList;
import java.util.List;

public class ExternalInventory {
    private List <ItemDTO> items = new ArrayList<>();

    private void addItems(){
        items.add(new ItemDTO(2345,25,6));
        items.add(new ItemDTO(2341,23,6));
    }
     public ExternalInventory(){
        addItems();
    }
    public ItemDTO findItem(int id, int quantity){
        for (ItemDTO item : items){
            if (item.getId() == (id)) {
                System.out.println(toString(item));
                return item;
            }
        }
        return null;
    }

    public String toString(ItemDTO item) {
        return item.getPrice()+" "+item.getId()+" "+item.getVat();
    }
}
