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
public class FridgeApiTest {
    
    public FridgeApiTest() {
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
     * Test of broken method, of class FridgeApi.
     */
    @Test
    public void testBroken() {
        System.out.println("broken");
        Appliance app = new Fridge(5, new Documentation(100), 0);
        FridgeApi instance = new FridgeApi();
        int expResult = instance.broken(app);
        assertEquals(expResult, -15);
    }

    /**
     * Test of createDocumentation method, of class FridgeApi.
     */
    @Test
    public void testCreateDocumentation() {
        System.out.println("createDocumentation");
        FridgeApi instance = new FridgeApi();
        Documentation expResult = instance.createDocumentation();
        assertEquals(expResult.getRepairTime(), new Documentation(120).getRepairTime());
    }
    
}
