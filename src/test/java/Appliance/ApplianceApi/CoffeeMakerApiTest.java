/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appliance.ApplianceApi;

import Appliance.Appliance;
import Appliance.CDPlayer;
import Appliance.CoffeeMaker;
import Appliance.Documentation;
import House.Measurable;
import org.junit.jupiter.api.*;
import sources.CDPlayerInput;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 *
 * @author fuji
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CoffeeMakerApiTest {


    /**
     * Check if CofeeMaker consumes energy during a work
     * @throws Exception
     */
    @Test
    @Order(6)
    @Tag("House")
    public void testConsumption() throws Exception{
        System.out.println("Consumption test");
        Appliance app = new CoffeeMaker(5, new Documentation(45), 0, "Samsung");
        CoffeeMakerApi instance = new CoffeeMakerApi();
        //start the device
        int workTime = instance.work(app);
        //measure consumption
        int expResult = instance.getConsumption(app);
        assertTrue("Consumption has to be greater than 0 ",expResult>0);
    }

    /**
     * Test if Cofee Maker is working correctly
     * Listening time should be higher than 0
     */
    @Test
    @Order(1)
    @Tag("House")
    public void testWorkCoffeeMaker() throws Exception {
        System.out.println("work");
        Appliance app = new CoffeeMaker(5, new Documentation(45), 0, "Aas");
        CoffeeMakerApi instance = new CoffeeMakerApi();
        int expResult = instance.work(app);
        assertEquals(expResult, 1);
    }

    /**
     * Test of broken method, of class CoffeeMakerApi.
     */
    @Test
    @Order(2)
    @Tag("House")
    public void testBrokenCoffeeMaker() throws Exception {
        System.out.println("broken");
        Appliance app = new CoffeeMaker(5, new Documentation(45), 0, "Aas");
        CoffeeMakerApi instance = new CoffeeMakerApi();
        int expResult = instance.broken(app);
        assertEquals(expResult, -1);
    }

    /**
     * Test of createDocumentation method, of class CoffeeMakerApi.
     */
    @Test
    @Order(3)
    @Tag("House")
    public void testCreateDocumentationCoffeeMaker() {
        System.out.println("createDocumentation");
        CoffeeMakerApi instance = new CoffeeMakerApi();
        Documentation expResult = instance.createDocumentation();
        assertEquals(expResult.getRepairTime(), new Documentation(10).getRepairTime());
    }

    /**
     * Test of toString method, of class CoffeeMakerApi.
     */
    @Test
    @Order(4)
    @Tag("House")
    public void testToStringCoffeeMaker() {
        System.out.println("toString");
        CoffeeMakerApi instance = new CoffeeMakerApi();
        String expResult = instance.toString();
        assertEquals(expResult, "CoffeeMaker");
    }

    @ParameterizedTest
    @ArgumentsSource(CDPlayerInput.class)
    @Order(5)
    @Tag("House")
    public void testLoadfromSourceCoffeeMaker(Integer brokenProb, Integer repairTime, Integer workTime, String name, String expected) {
        if (expected.equals("Exception")) {
            Exception ex = assertThrows(Exception.class, () -> {
                Appliance app = new CoffeeMaker(brokenProb, new Documentation(repairTime), workTime, name);
            }, "Exception was not trown");
        }
        if (expected.equals("success")) {
            assertDoesNotThrow(() -> {
                Appliance app = new CoffeeMaker(brokenProb, new Documentation(repairTime), workTime, name);
            });
        }
    }

}
