package se.kth.iv1350.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.controller.Controller;
import se.kth.iv1350.integration.ExternalInventory;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ViewTest {
    private View instanceOfTest;
    private ByteArrayOutputStream printoutBuffer;
    private PrintStream originalSysOut;

    @BeforeEach
    void setUp() {
        ExternalInventory external = new ExternalInventory();
        Controller contr = new Controller(external);
        instanceOfTest = new View(contr);

        printoutBuffer = new ByteArrayOutputStream();
        PrintStream inMemSysOut = new PrintStream(printoutBuffer);
        originalSysOut = System.out;
        System.setOut(inMemSysOut);
    }

    @AfterEach
    void tearDown() {
        instanceOfTest = null;

        printoutBuffer = null;
        System.setOut(originalSysOut);
    }

    @Test
    void fullrun() {
        instanceOfTest.rfe();
        String printout = printoutBuffer.toString();
        String expectedOutput = "change";
        assertTrue(printout.contains(expectedOutput), "UI Didn't run correctly");
    }

    @Test
    void change(){
        instanceOfTest.rfe();
    }
}