/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PetApi;

import Appliance.Appliance;
import Appliance.CoffeeMaker;
import Appliance.Documentation;
import Appliance.State.StateBroken;
import Controls.MainApi;
import House.Builder.FamilyHouseBuilder;
import House.House;
import Pet.Pet;
import Pet.PetType;
import Room.Room;
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
public class PetApiTest {
    
    public PetApiTest() {
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
     * Test of doRandomStuff method, of class PetApi.
     */
    @Test
    public void testDoRandomStuff() {
        System.out.println("Testing method: doRandomStuff");
        MainApi api = MainApi.getApi();
        House house = new FamilyHouseBuilder().buildHouse(api);
        Pet pet = new Pet("Luk", PetType.DOG, house);
        //breaks one appliance
        pet.getApi().doRandomStuff();
        for (Room room : house.getRooms()){
            for (Appliance appliance : room.getAppliance()){
                
                //should find one  broken appliance
                if (appliance.getState().getClass().equals((new StateBroken(appliance)).getClass())){
                    assertEquals(new StateBroken(appliance).getClass(), appliance.getState().getClass());
                }
            }
        }
    }

    /**
     * Test of findRandomRoomWithAppliance method, of class PetApi.
     */
    @Test
    public void testFindRandomRoomWithAppliance() {
        System.out.println("findRandomRoomWithAppliance");
        MainApi api = MainApi.getApi();
        House house = new FamilyHouseBuilder().buildHouse(api);
        Pet pet = new Pet("Luk", PetType.DOG, house);
        PetApi ap = new PetApi(pet);
        Room instance = ap.findRandomRoomWithAppliance();
        assertTrue("Has to be greater than 0", instance.getAppliance().size() > 0);
    }

    /**
     * Test of goSleep method, of class PetApi.
     */
    @Test
    public void testGoSleep() {
        MainApi api = MainApi.getApi();
        House house = new FamilyHouseBuilder().buildHouse(api);
        Pet pet = new Pet("Luk", PetType.DOG, house);
        PetApi ap = new PetApi(pet);
        ap.goSleep();
        assertTrue("Has to be greater than 0", pet.getBusyTime() > 0);
    }

    /**
     * Test of slaveTheHumanRace method, of class PetApi.
     */
    @Test
    public void testSlaveTheHumanRace() {
        System.out.println("slaveTheHumanRace");
                MainApi api = MainApi.getApi();
        House house = new FamilyHouseBuilder().buildHouse(api);
                Pet pet = new Pet("Luk", PetType.DOG, house);
        PetApi instance = new PetApi(pet);
        instance.slaveTheHumanRace();
    }
    
}
