package se.kth.iv1350.view;

import se.kth.iv1350.controller.Controller;

public class View {
    private Controller contr;

    public View(Controller contr){
        this.contr = contr;
    }


    public void rfe(){
        contr.startSale();
        contr.enterItem(2345,2);
        contr.endSale();
    }
}
