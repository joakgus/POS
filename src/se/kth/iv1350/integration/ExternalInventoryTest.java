package se.kth.iv1350.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExternalInventoryTest {
        private ExternalInventory external;
    @BeforeEach
    void setUp() {
        external = new ExternalInventory();
    }

    @AfterEach
    void tearDown() {
        external = null;
    }

    @Test
    void id() {
        ItemDTO anItem = external.findItem(2345,10);
        ItemDTO expectedItem = new ItemDTO(2345,25,6,10,"hi");
        int id1 = expectedItem.getId();
        int id2 = anItem.getId();
        assertEquals(id1,id2,"Wrong item");
    }
    @Test
    void vat() {
        ItemDTO anItem = external.findItem(2345,10);
        ItemDTO expectedItem = new ItemDTO(2345,25,6,10,"hi");
        int vat1 = expectedItem.getVat();
        int vat2 = anItem.getVat();
        assertEquals(vat1,vat2,"Wrong item");
    }
    @Test
    void quantity(){
        ItemDTO anItem = external.findItem(2345,10);
        ItemDTO expectedItem = new ItemDTO(2345,25,6,10,"hi");
        int quant1 = expectedItem.getQuantity();
        int quant2 = anItem.getQuantity();
        assertEquals(quant1,quant2,"Wrong item");
    }
    @Test
    void desc(){
        ItemDTO anItem = external.findItem(2345,10);
        ItemDTO expectedItem = new ItemDTO(2345,25,6,10,"hi");
        String desc1 = expectedItem.getDesc();
        String desc2 = anItem.getDesc();
        assertEquals(desc1,desc2,"Wrong item");
    }
    @Test
    void price(){
        ItemDTO anItem = external.findItem(2345,10);
        ItemDTO expectedItem = new ItemDTO(2345,25,6,10,"hi");
        int desc1 = expectedItem.getPrice();
        int desc2 = anItem.getPrice();
        assertEquals(desc1,desc2,"Wrong item");
    }
    @Test
    void notId(){
        ItemDTO anItem = external.findItem(2345,10);
        ItemDTO expectedItem = new ItemDTO(2,25,6,10,"hi");
        int desc1 = expectedItem.getId();
        int desc2 = anItem.getId();
        assertNotEquals(desc1,desc2,"Wrong item");
    }
    @Test
    void itemNotFound(){
        try {
            ItemDTO anItem = external.findItem(2,10);
        }
        catch (ItemNotFoundException e){
            assertEquals(null,e,"catches the null item");
        }
    }
}