/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appliance.ApplianceApi;

import Appliance.Accessories.Food.Food;
import Appliance.Appliance;
import Appliance.Computer;
import Appliance.Documentation;
import Appliance.Fridge;
import House.Measurable;
import java.util.ArrayList;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import sources.CDPlayerInput;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;


/**
 *
 * @author fuji
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FridgeApiTest {

    /**
     * Check if Fridge consumes energy during a work
     * Fridge is empty so consumption should be 0
     * @throws Exception
     */
    @Test
    @Order(6)
    @Tag("House")
    public void testConsumptionFridge() throws Exception{
        System.out.println("Consumption test");
        Appliance app = new Fridge(5, new Documentation(45), 0, "Samsung");
        FridgeApi instance = new FridgeApi();
        //start the device
        int workTime = instance.work(app);
        //measure consumption
        int expResult = instance.getConsumption(app);
        assertTrue("Consumption has to be 0 ",expResult==0);
    }



    /**
     * Test if Fridge is working correctly
     * Should be empty
     */
    @Test
    @Order(1)
    @Tag("House")
    public void testWorkFridge() throws Exception {
        System.out.println("work");
        Appliance app = new Fridge(5, new Documentation(45), 0, "Aas");
        FridgeApi instance = new FridgeApi();
        int expResult = instance.work(app);
        assertEquals(expResult, 0);
    }

    /**
     * Test of broken method, of class FridgeApi.
     */
    @Test
    @Order(3)
    @Tag("House")
    public void testBrokenFridge() throws Exception {
        System.out.println("broken");
        Appliance app = new Fridge(5, new Documentation(100), 0, "Aas");
        FridgeApi instance = new FridgeApi();
        int expResult = instance.broken(app);
        assertEquals(expResult, -15);
    }

    /**
     * Test of createDocumentation method, of class FridgeApi.
     */
    @Test
    @Order(4)
    @Tag("House")
    public void testCreateDocumentationFridge() {
        System.out.println("createDocumentation");
        FridgeApi instance = new FridgeApi();
        Documentation expResult = instance.createDocumentation();
        assertEquals(expResult.getRepairTime(), new Documentation(120).getRepairTime());
    }


    @ParameterizedTest
    @ArgumentsSource(CDPlayerInput.class)
    @Order(5)
    @Tag("House")
    public void testLoadfromSourceFridge(Integer brokenProb, Integer repairTime, Integer workTime, String name, String expected) {
        if (expected.equals("Exception")) {
            Exception ex = assertThrows(Exception.class, () -> {
                Appliance app = new Fridge(brokenProb, new Documentation(repairTime), workTime, name);
            }, "Exception was not trown");
        }
        if (expected.equals("success")) {
            assertDoesNotThrow(() -> {
                Appliance app = new Fridge(brokenProb, new Documentation(repairTime), workTime, name);
            });
        }
    }
}
