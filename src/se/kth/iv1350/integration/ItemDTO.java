package se.kth.iv1350.integration;

/**
 * holds a object of item.
 */
public final class ItemDTO {
    private final int price;
    final int id;
    private final int vat;
    private int quantity;
    private final String desc;

    public int getPrice(){
        return this.price;
    }
    public int getVat(){
        return this.vat;
    }
    public int getId(){
        return this.id;
    }
    public int getQuantity(){return this.quantity;}
    public String getDesc() {return desc;}

    /**
     * Creates a new instance of item.
     * @param id
     * @param price
     * @param vat
     * @param quantity
     * @param desc
     */
    public ItemDTO (int id, int price, int vat, int quantity, String desc){
        this.id = id;
        this.price = price;
        this.vat = vat;
        this.quantity = quantity;
        this.desc = desc;
    }

    public void setQuantity(int newQuantity) {
        this.quantity = newQuantity;
    }
}
