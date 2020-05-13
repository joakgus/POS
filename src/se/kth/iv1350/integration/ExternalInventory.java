package se.kth.iv1350.integration;

import se.kth.iv1350.model.Sale;

import java.util.ArrayList;
import java.util.List;
import se.kth.iv1350.integration.LogHandler;

/**
 * Holds objects of items and fetches them.
 */
public class ExternalInventory {
    private List <ItemDTO> items = new ArrayList<>();

    /**
     * Creates a new instance of External inventory
     */
    private void addItems(){
        items.add(new ItemDTO(2345,25,6,20,"hi"));
        items.add(new ItemDTO(2341,23,6,20,"dive"));
    }

     public ExternalInventory(){
        addItems();
    }

    /**
     * Finds the requested item. If not found then it throws a ItemNotFoundException
     * @param id
     * @param quantity
     * @return item
     * @throws ItemNotFoundException
     */
    public ItemDTO findItem(int id, int quantity) throws ItemNotFoundException{
        for (ItemDTO item : items){
            if ((item.getId() == (id)) && (item.getQuantity() >= quantity)) {
                return new ItemDTO(item.getId(),item.getPrice(),item.getVat(),quantity,item.getDesc());
            }
        }
        throw new ItemNotFoundException("There is no such item");
    }

    /**
     * Lowers the quantity in the database by taking a parameter of object sale.
     * @param sale
     */
    public void lowerQuantity(Sale sale) {
       ArrayList<ItemDTO> saleItems = sale.getItems();
       for(ItemDTO saleItem : saleItems){
           for (ItemDTO inventoryItem : items){
               if (saleItem.getId() == inventoryItem.getId()){
                   int newQuantity = inventoryItem.getQuantity() - saleItem.getQuantity();
                   inventoryItem.setQuantity(newQuantity);
                   System.out.println("changed quantity for item " + inventoryItem.getId() + " with "
                           + saleItem.getQuantity());
               }
           }
       }

    }
}
