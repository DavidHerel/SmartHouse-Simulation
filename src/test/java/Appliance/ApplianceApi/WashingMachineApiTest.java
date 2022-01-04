/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appliance.ApplianceApi;

import Appliance.Appliance;
import Appliance.Documentation;
import Appliance.MassageChair;
import Appliance.WashingMachine;
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
public class WashingMachineApiTest {

    /**
     * Check if CofeeMaker consumes energy during a work
     * @throws Exception
     */
    @Test
    @Order(6)
    public void testConsumptionWashingMachine() throws Exception{
        System.out.println("Consumption test");
        Appliance app = new WashingMachine(5, new Documentation(45), 0, "Samsung");
        WashingMachineApi instance = new WashingMachineApi();
        //start the device
        int workTime = instance.work(app);
        //measure consumption
        int expResult = instance.getConsumption(app);
        assertTrue("Consumption has to be greater than 0 ",expResult>0);
    }

   /**
     * Test of work method, of class WashingMachineApi.
     */
    @Test
    @Order(2)
    public void testWorkWashingMachine() throws Exception {
        System.out.println("work");
        Appliance app = new WashingMachine(5, new Documentation(100), 0, "Aas");
        WashingMachineApi instance = new WashingMachineApi();
        int expResult = instance.work(app);
        assertEquals(expResult, 10);
    }
    /**
     * Test of broken method, of class MassageChairApi.
     */
    @Test
    @Order(3)
    public void testBrokenWashingMachine() throws Exception {
        System.out.println("broken");
        Appliance app = new WashingMachine(5, new Documentation(100), 0, "Aas");
        WashingMachineApi instance = new WashingMachineApi();
        int expResult = instance.broken(app);
        assertEquals(expResult, -10);
    }

    /**
     * Test of createDocumentation method, of class MassageChairApi.
     */
    @Test
    @Order(4)
    public void testCreateDocumentationWashingMachine() {
        System.out.println("createDocumentation");
        WashingMachineApi instance = new WashingMachineApi();
        Documentation expResult = instance.createDocumentation();
        assertEquals(expResult.getRepairTime(), new Documentation(420).getRepairTime());
    }

    @ParameterizedTest
    @ArgumentsSource(CDPlayerInput.class)
    @Order(5)
    public void testLoadfromSourceWashingMachine(Integer brokenProb, Integer repairTime, Integer workTime, String name, String expected) {
        if (expected.equals("Exception")) {
            Exception ex = assertThrows(Exception.class, () -> {
                Appliance app = new WashingMachine(brokenProb, new Documentation(repairTime), workTime, name);
            }, "Exception was not trown");
        }
        if (expected.equals("success")) {
            assertDoesNotThrow(() -> {
                Appliance app = new WashingMachine(brokenProb, new Documentation(repairTime), workTime, name);
            });
        }
    }
    
}
