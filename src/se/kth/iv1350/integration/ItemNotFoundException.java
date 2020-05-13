package se.kth.iv1350.integration;

public class ItemNotFoundException extends NullPointerException{
    public ItemNotFoundException(String msg){
        System.out.println(msg);
    }
}
