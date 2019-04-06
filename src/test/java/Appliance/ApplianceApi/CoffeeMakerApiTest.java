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
public class CoffeeMakerApiTest {
    
    public CoffeeMakerApiTest() {
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
     * Test of work method, of class CoffeeMakerApi.
     */
    @Test
    public void testWork() {
        System.out.println("work");
        Appliance app = new CoffeeMaker(5, new Documentation(45), 0);
        CoffeeMakerApi instance = new CoffeeMakerApi();
        int expResult = instance.work(app);
        assertEquals(expResult, 1);
    }
    /**
     * Test of broken method, of class CoffeeMakerApi.
     */
    @Test
    public void testBroken() {
        System.out.println("broken");
        Appliance app = new CoffeeMaker(5, new Documentation(45), 0);
        CoffeeMakerApi instance = new CoffeeMakerApi();
        int expResult = instance.broken(app);
        assertEquals(expResult, -1);
    }

    /**
     * Test of createDocumentation method, of class CoffeeMakerApi.
     */
    @Test
    public void testCreateDocumentation() {
        System.out.println("createDocumentation");
        CoffeeMakerApi instance = new CoffeeMakerApi();
        Documentation expResult = instance.createDocumentation();
        assertEquals(expResult.getRepairTime(), new Documentation(10).getRepairTime());
    }

    /**
     * Test of toString method, of class CoffeeMakerApi.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        CoffeeMakerApi instance = new CoffeeMakerApi();
        String expResult = instance.toString();
        assertEquals(expResult, "CoffeeMaker");
    }

}
