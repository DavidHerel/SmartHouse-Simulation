/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HumanApi;

import Appliance.Appliance;
import Appliance.CoffeeMaker;
import Appliance.Documentation;
import Appliance.Fridge;
import Controls.MainApi;
import House.Builder.FamilyHouseBuilder;
import House.House;
import Human.Adult;
import Human.Human;
import Human.HumanAbility;
import HumanFactory.HumanFactory;
import Pet.Pet;
import Pet.PetType;
import PetApi.PetApi;
import Room.Room;
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
public class HumanApiTest {
    
    public HumanApiTest() {
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
     * Test of goSleep method, of class HumanApi.
     */
    @Test
    public void testGoSleep() {
        System.out.println("goSleep");
        MainApi api = MainApi.getApi();
        House house = new FamilyHouseBuilder().buildHouse(api);
        Human hm = new Adult(null, "name", house, 10);
        HumanApi ap = new HumanApi(hm);
        ap.goSleep();
        assertTrue("Has to be greater than 0", hm.getBusyTime() > 0);
    }

    /**
     * Test of repairAppliance method, of class HumanApi.
     */
    @Test
    public void testRepairAppliance() {
        System.out.println("repairAppliance");
        MainApi api = MainApi.getApi();
        House house = new FamilyHouseBuilder().buildHouse(api);
        ArrayList<HumanAbility> abilities = new ArrayList<>();
        abilities.add(HumanAbility.CAN_REPAIR);
        abilities.add(HumanAbility.CAN_SPORT);
        Human david = HumanFactory.createHuman("Adult", abilities, "David", house, 10);
        Appliance apl = new CoffeeMaker(1, new Documentation(5), 1);
        david.getApi().repairAppliance(apl);
        assertTrue("Greater than 0", david.getBusyTime() > 0);
    }

    /**
     * Test of doSport method, of class HumanApi.
     */
    @Test
    public void testDoSport() {
        System.out.println("DoSport");
        MainApi api = MainApi.getApi();
        House house = new FamilyHouseBuilder().buildHouse(api);
        ArrayList<HumanAbility> abilities = new ArrayList<>();
        abilities.add(HumanAbility.CAN_REPAIR);
        abilities.add(HumanAbility.CAN_SPORT);
        Human david = HumanFactory.createHuman("Adult", abilities, "David", house, 10);
        
        david.getApi().doSport();
        assertTrue("BusyTime (" + david.getBusyTime() + ") should be  60 (" + 60 + ")", david.getBusyTime() == 60);
    }

    /**
     * Test of findRandomRoomWithAppliance method, of class HumanApi.
     */
    @Test
    public void testFindRandomRoomWithAppliance() {
        System.out.println("findRandomRoomWithAppliance");
        System.out.println("findRandomRoomWithAppliance");
        MainApi api = MainApi.getApi();
        House house = new FamilyHouseBuilder().buildHouse(api);
        Human hm = new Adult(null, "name", house, 10);
        HumanApi ap = new HumanApi(hm);
        Room instance = ap.findRandomRoomWithAppliance();
        assertTrue("Has to be greater than 0", instance.getAppliance().size() > 0);
    }

    /**
     * Test of findRandomFreeAppliance method, of class HumanApi.
     */
    @Test
    public void testFindRandomFreeAppliance() {
        System.out.println("findRandomFreeAppliance");
        MainApi api = MainApi.getApi();
        House house = new FamilyHouseBuilder().buildHouse(api);
        Human hm = new Adult(null, "name", house, 10);
        HumanApi ap = new HumanApi(hm);
        Room instance = ap.findRandomRoomWithAppliance();
        Appliance app = ap.findRandomFreeAppliance(instance.getAppliance());
        assertTrue("Has to be 0", app.getBusyTime() == 0);
    }


    
}
