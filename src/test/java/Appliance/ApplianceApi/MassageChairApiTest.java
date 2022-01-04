/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appliance.ApplianceApi;

import Appliance.Appliance;
import Appliance.Computer;
import Appliance.Documentation;
import Appliance.MassageChair;
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
public class MassageChairApiTest {

    /**
     * Check if MassageChair consumes energy during a work
     * @throws Exception
     */
    @Test
    @Order(6)
    public void testConsumptionMassageChair() throws Exception{
        System.out.println("Consumption test");
        Appliance app = new MassageChair(5, new Documentation(45), 0, "Samsung");
        MassageChairApi instance = new MassageChairApi();
        //start the device
        int workTime = instance.work(app);
        //measure consumption
        int expResult = instance.getConsumption(app);
        assertTrue("Consumption has to be greater than 0 ",expResult>0);
    }

   /**
     * Test of work method, of class MassageChairApi.
     */
    @Test
    @Order(2)
    public void testWorkMassageChair() throws Exception {
        System.out.println("work");
        Appliance app = new MassageChair(5, new Documentation(100), 0, "Aas");
        MassageChairApi instance = new MassageChairApi();
        int expResult = instance.work(app);
        assertEquals(expResult, 30);
    }
    /**
     * Test of broken method, of class MassageChairApi.
     */
    @Test
    @Order(3)
    public void testBrokenMassageChair() throws Exception {
        System.out.println("broken");
        Appliance app = new MassageChair(5, new Documentation(100), 0, "Aas");
        MassageChairApi instance = new MassageChairApi();
        int expResult = instance.broken(app);
        assertEquals(expResult, -1);
    }

    /**
     * Test of createDocumentation method, of class MassageChairApi.
     */
    @Test
    @Order(4)
    public void testCreateDocumentationMassageChair() {
        System.out.println("createDocumentation");
        MassageChairApi instance = new MassageChairApi();
        Documentation expResult = instance.createDocumentation();
        assertEquals(expResult.getRepairTime(), new Documentation(420).getRepairTime());
    }


    @ParameterizedTest
    @ArgumentsSource(CDPlayerInput.class)
    @Order(5)
    public void testLoadfromSourceMassageChair(Integer brokenProb, Integer repairTime, Integer workTime, String name, String expected) {
        if (expected.equals("Exception")) {
            Exception ex = assertThrows(Exception.class, () -> {
                Appliance app = new MassageChair(brokenProb, new Documentation(repairTime), workTime, name);
            }, "Exception was not trown");
        }
        if (expected.equals("success")) {
            assertDoesNotThrow(() -> {
                Appliance app = new MassageChair(brokenProb, new Documentation(repairTime), workTime, name);
            });
        }
    }
}
