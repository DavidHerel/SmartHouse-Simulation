/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appliance.ApplianceApi;

import Appliance.Appliance;
import Appliance.Documentation;
import Appliance.Fridge;
import Appliance.Television;
import House.Measurable;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
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
public class TelevisionApiTest {

    /**
     * Check if Television consumes energy during a work
     * @throws Exception
     */
    @Test
    @Order(6)
    public void testConsumptionTelevision() throws Exception{
        System.out.println("Consumption test");
        Appliance app = new Television(5, new Documentation(45), 0, "Samsung");
        TelevisionApi instance = new TelevisionApi();
        //start the device
        int workTime = instance.work(app);
        //measure consumption
        int expResult = instance.getConsumption(app);
        assertTrue("Consumption has to be greater than 0 ",expResult>0);
    }


    /**
     * Test if Television is working correctly
     * Listening time should be higher than 0
     */
    @Test
    @Order(1)
    public void testWorkTelevision() throws Exception {
        System.out.println("work");
        Appliance app = new Television(5, new Documentation(45), 0, "Aas");
        TelevisionApi instance = new TelevisionApi();
        int expResult = instance.work(app);
        assertTrue("Watchtime should not be empty", expResult>0);
    }


    /**
     * Test of broken method, of class TelevisionApi.
     */
    @Test
    @Order(3)
    public void testBrokenTelevision() throws Exception {
        System.out.println("broken");
        Appliance app = new Television(5, new Documentation(100), 0, "Aas");
        TelevisionApi instance = new TelevisionApi();
        int expResult = instance.broken(app);
        assertEquals(expResult, -10);
    }

    /**
     * Test of createDocumentation method, of class FridgeApi.
     */
    @Test
    @Order(4)
    public void testCreateDocumentationTelevision() {
        System.out.println("createDocumentation");
        TelevisionApi instance = new TelevisionApi();
        Documentation expResult = instance.createDocumentation();
        assertEquals(expResult.getRepairTime(), new Documentation(180).getRepairTime());
    }

    @ParameterizedTest
    @ArgumentsSource(CDPlayerInput.class)
    @Order(5)
    public void testLoadfromSourceTelevision(Integer brokenProb, Integer repairTime, Integer workTime, String name, String expected) {
        if (expected.equals("Exception")) {
            Exception ex = assertThrows(Exception.class, () -> {
                Appliance app = new Television(brokenProb, new Documentation(repairTime), workTime, name);
            }, "Exception was not trown");
        }
        if (expected.equals("success")) {
            assertDoesNotThrow(() -> {
                Appliance app = new Television(brokenProb, new Documentation(repairTime), workTime, name);
            });
        }
    }
    
}
