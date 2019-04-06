/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appliance.ApplianceApi;

import Appliance.Appliance;
import Appliance.Documentation;
import Appliance.MassageChair;
import Appliance.WashingMachine;
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
public class WashingMachineApiTest {
    
    public WashingMachineApiTest() {
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
     * Test of work method, of class WashingMachineApi.
     */
    @Test
    public void testWork() {
        System.out.println("work");
        Appliance app = new WashingMachine(5, new Documentation(100), 0);
        WashingMachineApi instance = new WashingMachineApi();
        int expResult = instance.work(app);
        assertEquals(expResult, 10);
    }
    /**
     * Test of broken method, of class MassageChairApi.
     */
    @Test
    public void testBroken() {
        System.out.println("broken");
        Appliance app = new MassageChair(5, new Documentation(100), 0);
        WashingMachineApi instance = new WashingMachineApi();
        int expResult = instance.broken(app);
        assertEquals(expResult, -10);
    }

    /**
     * Test of createDocumentation method, of class MassageChairApi.
     */
    @Test
    public void testCreateDocumentation() {
        System.out.println("createDocumentation");
        WashingMachineApi instance = new WashingMachineApi();
        Documentation expResult = instance.createDocumentation();
        assertEquals(expResult.getRepairTime(), new Documentation(420).getRepairTime());
    }
    
    
}
