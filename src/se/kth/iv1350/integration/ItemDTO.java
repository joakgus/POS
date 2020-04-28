package se.kth.iv1350.integration;

public final class ItemDTO {
    private final int price;
    final int id;
    private final int vat;
    private int quantity;

    public int getPrice(){
        return this.price;
    }
    public int getVat(){
        return this.vat;
    }
    public int getId(){
        return this.id;
    };

    public ItemDTO (int id, int price, int vat){
        this.id = id;
        this.price = price;
        this.vat = vat;
    }
}
