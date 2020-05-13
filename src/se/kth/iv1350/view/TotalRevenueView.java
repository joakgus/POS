package se.kth.iv1350.view;

import se.kth.iv1350.model.SaleObserver;

public class TotalRevenueView implements SaleObserver {
    private int total;

    public TotalRevenueView (){

    }

    public void newSale (int totalPrice){
        this.total += totalPrice;
        System.out.println("running tally is " + this.total);
    }
}
