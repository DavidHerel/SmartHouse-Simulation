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

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author fuji
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CDPlayerApiTest {

    /**
     * Test of broken method, of class CDPlayerApi.
     */
    @Test
    @Order(1)
    public void testBroken() throws Exception {
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
    public void testCreateDocumentation() {
        System.out.println("createDocumentation");
        CDPlayerApi instance = new CDPlayerApi();
        Documentation expResult = instance.createDocumentation();
        assertEquals(expResult.getRepairTime(), new Documentation(45).getRepairTime());
    }


    @ParameterizedTest
    @ArgumentsSource(CDPlayerInput.class)
    @Order(3)
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
