package se.kth.iv1350.integration;

/**
 * Catches null pointer exceptions of a item.
 */
public class ItemNotFoundException extends NullPointerException{
    public ItemNotFoundException(String msg){
        System.out.println(msg);
    }
}
