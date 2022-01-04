/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appliance.ApplianceApi;

import Appliance.Appliance;
import Appliance.Documentation;
import Appliance.Television;
import Appliance.Xbox;
import House.Measurable;
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
public class XboxApiTest {

    /**
     * Check if CofeeMaker consumes energy during a work
     * @throws Exception
     */
    @Test
    @Order(6)
    @Tag("House")
    public void testConsumptionXbox() throws Exception{
        System.out.println("Consumption test");
        Appliance app = new Xbox(5, new Documentation(45), 0, "Samsung");
        XboxApi instance = new XboxApi();
        //start the device
        int workTime = instance.work(app);
        //measure consumption
        int expResult = instance.getConsumption(app);
        assertTrue("Consumption has to be greater than 0 ",expResult>0);
    }


    /**
     * Test if Xbox is working correctly
     * Listening time should be higher than 0
     */
    @Test
    @Order(1)
    @Tag("House")
    public void testWorkXbox() throws Exception {
        System.out.println("work");
        Appliance app = new Xbox(5, new Documentation(45), 0, "Aas");
        XboxApi instance = new XboxApi();
        int expResult = instance.work(app);
        assertTrue("Playtime should not be 0", expResult > 0);
    }


    /**
     * Test of broken method, of class XboxApi.
     */
    @Test
    @Order(3)
    @Tag("House")
    public void testBrokenXbox() throws Exception {
        System.out.println("broken");
        Appliance app = new Xbox(5, new Documentation(100), 0, "Aas");
        XboxApi instance = new XboxApi();
        int expResult = instance.broken(app);
        assertEquals(expResult, -20);
    }

    /**
     * Test of createDocumentation method, of class XboxApi.
     */
    @Test
    @Order(4)
    @Tag("House")
    public void testCreateDocumentationXbox() {
        System.out.println("createDocumentation");
        XboxApi instance = new XboxApi();
        Documentation expResult = instance.createDocumentation();
        assertEquals(expResult.getRepairTime(), new Documentation(50).getRepairTime());
    }

    @ParameterizedTest
    @ArgumentsSource(CDPlayerInput.class)
    @Order(5)
    @Tag("House")
    public void testLoadfromSourceXbox(Integer brokenProb, Integer repairTime, Integer workTime, String name, String expected) {
        if (expected.equals("Exception")) {
            Exception ex = assertThrows(Exception.class, () -> {
                Appliance app = new Xbox(brokenProb, new Documentation(repairTime), workTime, name);
            }, "Exception was not trown");
        }
        if (expected.equals("success")) {
            assertDoesNotThrow(() -> {
                Appliance app = new Xbox(brokenProb, new Documentation(repairTime), workTime, name);
            });
        }
    }
}
