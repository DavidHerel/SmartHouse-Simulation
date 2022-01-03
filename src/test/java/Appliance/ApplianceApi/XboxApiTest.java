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
public class XboxApiTest {
    
    public XboxApiTest() {
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
     * Test of broken method, of class XboxApi.
     */
    @Test
    public void testBroken() throws Exception {
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
    public void testCreateDocumentation() {
        System.out.println("createDocumentation");
        XboxApi instance = new XboxApi();
        Documentation expResult = instance.createDocumentation();
        assertEquals(expResult.getRepairTime(), new Documentation(50).getRepairTime());
    }
    
}
