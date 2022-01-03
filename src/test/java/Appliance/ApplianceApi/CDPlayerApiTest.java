/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appliance.ApplianceApi;

import Appliance.Appliance;
import Appliance.CDPlayer;
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
public class CDPlayerApiTest {

    /**
     * Test of broken method, of class CDPlayerApi.
     */
    @Test
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
    public void testCreateDocumentation() {
        System.out.println("createDocumentation");
        CDPlayerApi instance = new CDPlayerApi();
        Documentation expResult = instance.createDocumentation();
        assertEquals(expResult.getRepairTime(), new Documentation(45).getRepairTime());
    }

    
}
