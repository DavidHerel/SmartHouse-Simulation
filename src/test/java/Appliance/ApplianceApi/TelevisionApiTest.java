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
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author fuji
 */
public class TelevisionApiTest {
    
    public TelevisionApiTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of broken method, of class TelevisionApi.
     */
    @Test
    public void testBroken() {
        System.out.println("broken");
        Appliance app = new Television(5, new Documentation(100), 0);
        TelevisionApi instance = new TelevisionApi();
        int expResult = instance.broken(app);
        assertEquals(expResult, -10);
    }

    /**
     * Test of createDocumentation method, of class FridgeApi.
     */
    @Test
    public void testCreateDocumentation() {
        System.out.println("createDocumentation");
        TelevisionApi instance = new TelevisionApi();
        Documentation expResult = instance.createDocumentation();
        assertEquals(expResult.getRepairTime(), new Documentation(180).getRepairTime());
    }
    
}
