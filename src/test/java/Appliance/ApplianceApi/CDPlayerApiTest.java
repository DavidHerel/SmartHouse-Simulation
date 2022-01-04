/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appliance.ApplianceApi;

import Appliance.Appliance;
import Appliance.CDPlayer;
import Appliance.Documentation;
import static org.junit.Assert.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import sources.CDPlayerInput;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author fuji
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CDPlayerApiTest {

    /**
     * Check if CDplayer consumes energy during a work
     * @throws Exception
     */
    @Test
    @Order(5)
    @Tag("House")
    public void testConsumptionOfCDPlayer() throws Exception{
        System.out.println("Consumption test");
        Appliance app = new CDPlayer(5, new Documentation(45), 0, "Samsung");
        CDPlayerApi instance = new CDPlayerApi();
        //start the device
        int workTime = instance.work(app);
        //measure consumption
        int expResult = instance.getConsumption(app);
        assertTrue("Consumption has to be greater than 0 ",expResult>0);
    }

    /**
     * Test if CD player is working correctly
     * Listening time should be higher than 0
     */
    @Test
    @Order(4)
    @Tag("House")
    public void testWorkOfCDPlayer() throws Exception {
        System.out.println("work");
        Appliance app = new CDPlayer(5, new Documentation(45), 0, "Samsung");
        CDPlayerApi instance = new CDPlayerApi();
        int expResult = instance.work(app);
        assertTrue("Listening time should be greater than 0 ",expResult>0);
    }

    /**
     * Test if CD Player can be broken
     */
    @Test
    @Order(1)
    @Tag("House")
    public void testBrokenCDPLayer() throws Exception {
        System.out.println("broken");
        Appliance app = new CDPlayer(5, new Documentation(45), 0, "Samsung");
        CDPlayerApi instance = new CDPlayerApi();
        int expResult = instance.broken(app);
        assertEquals(expResult, -4);
    }

    /**
     * Test of createDocumentation method, of class CDPlayerApi.
     */
    @Test
    @Order(2)
    @Tag("House")
    public void testCreateDocumentationCDPlayer() {
        System.out.println("createDocumentation");
        CDPlayerApi instance = new CDPlayerApi();
        Documentation expResult = instance.createDocumentation();
        assertEquals(expResult.getRepairTime(), new Documentation(45).getRepairTime());
    }


    @ParameterizedTest
    @ArgumentsSource(CDPlayerInput.class)
    @Order(3)
    @Tag("House")
    public void testLoadfromSourceCDplayer(Integer brokenProb, Integer repairTime, Integer workTime, String name, String expected) {
        if (expected.equals("Exception")) {
            Exception ex = assertThrows(Exception.class, () -> {
                Appliance app = new CDPlayer(brokenProb, new Documentation(repairTime), workTime, name);
            }, "Exception was not trown");
        }
        if (expected.equals("success")) {
            assertDoesNotThrow(() -> {
                Appliance app = new CDPlayer(brokenProb, new Documentation(repairTime), workTime, name);
            });
        }
    }

}
