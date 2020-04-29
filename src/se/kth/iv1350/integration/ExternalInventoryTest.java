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
        ItemDTO item = new ItemDTO(2345,25,6,10,"hi");
        int id1 = item.getId();
        int id2 = anItem.getId();
        assertEquals(id1,id2,"Wrong item");
    }

    void vat() {
        ItemDTO anItem = external.findItem(2345,10);
        ItemDTO item = new ItemDTO(2345,25,6,10,"hi");
        int vat1 = item.getVat();
        int vat2 = anItem.getVat();
        assertEquals(vat1,vat2,"Wrong item");
    }

}