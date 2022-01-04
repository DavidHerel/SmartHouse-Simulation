/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appliance.ApplianceApi;

import Appliance.Appliance;
import Appliance.CoffeeMaker;
import Appliance.Computer;
import Appliance.Documentation;
import House.Measurable;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import sources.CDPlayerInput;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 *
 * @author fuji
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ComputerApiTest {

    /**
     * Check if Computer consumes energy during a work
     * @throws Exception
     */
    @Test
    @Order(6)
    @Tag("House")
    public void testConsumptionOfComputer() throws Exception{
        System.out.println("Consumption test");
        Appliance app = new Computer(5, new Documentation(45), 0, "Samsung");
        ComputerApi instance = new ComputerApi();
        //start the device
        int workTime = instance.work(app);
        //measure consumption
        int expResult = instance.getConsumption(app);
        assertTrue("Consumption has to be greater than 0 ",expResult>0);
    }

    /**
     * Test of work method, of class ComputerApi.
     */
    @Test
    @Order(2)
    @Tag("House")
    public void testWorkComputer() throws Exception {
        System.out.println("work");
        Appliance app = new Computer(5, new Documentation(100), 0, "Aas");
        ComputerApi instance = new ComputerApi();
        int expResult = instance.work(app);
        assertEquals(expResult, 24*60);
    }
    /**
     * Test of broken method, of class ComputerApi.
     */
    @Test
    @Order(3)
    @Tag("House")
    public void testBrokenComputer() throws Exception {
        System.out.println("broken");
        Appliance app = new Computer(5, new Documentation(100), 0, "Aas");
        ComputerApi instance = new ComputerApi();
        int expResult = instance.broken(app);
        assertEquals(expResult, -100);
    }

    /**
     * Test of createDocumentation method, of class ComputerApi.
     */
    @Test
    @Order(4)
    @Tag("House")
    public void testCreateDocumentationComputer() {
        System.out.println("createDocumentation");
        ComputerApi instance = new ComputerApi();
        Documentation expResult = instance.createDocumentation();
        assertEquals(expResult.getRepairTime(), new Documentation(100).getRepairTime());
    }

    @ParameterizedTest
    @ArgumentsSource(CDPlayerInput.class)
    @Order(5)
    @Tag("House")
    public void testLoadfromSourceComputer(Integer brokenProb, Integer repairTime, Integer workTime, String name, String expected) {
        if (expected.equals("Exception")) {
            Exception ex = assertThrows(Exception.class, () -> {
                Appliance app = new Computer(brokenProb, new Documentation(repairTime), workTime, name);
            }, "Exception was not trown");
        }
        if (expected.equals("success")) {
            assertDoesNotThrow(() -> {
                Appliance app = new Computer(brokenProb, new Documentation(repairTime), workTime, name);
            });
        }
    }
}
