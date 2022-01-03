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
public class ComputerApiTest {
    
    public ComputerApiTest() {
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
     * Test of work method, of class ComputerApi.
     */
    @Test
    public void testWork() throws Exception {
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
    public void testBroken() throws Exception {
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
    public void testCreateDocumentation() {
        System.out.println("createDocumentation");
        ComputerApi instance = new ComputerApi();
        Documentation expResult = instance.createDocumentation();
        assertEquals(expResult.getRepairTime(), new Documentation(100).getRepairTime());
    }
}
