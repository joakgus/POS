package se.kth.iv1350.model;

import se.kth.iv1350.integration.ItemDTO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Receipt {

    public void receipt(LocalDateTime startTime, ArrayList<ItemDTO> sale){
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        System.out.println(startTime.format(formatter));
        sale.forEach((n) -> System.out.println(n.getId()));
    }
}
