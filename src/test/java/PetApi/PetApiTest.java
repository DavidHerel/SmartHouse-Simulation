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
import static org.junit.Assert.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author fuji
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PetApiTest {

    /**
     * Test of doRandomStuff method, of class PetApi.
     */
    @Test
    @Order(1)
    @Tag("Living")
    public void testDoRandomStuff() throws Exception {
        System.out.println("Testing method: doRandomStuff");
        MainApi api = MainApi.getApi();
        House house = new FamilyHouseBuilder().buildHouse(api);
        Pet pet = new Pet("Luk", PetType.DOG, house, 10);
        //breaks one appliance
        pet.getApi().doRandomStuff();
        for (Room room : house.getRooms()){
            for (Appliance appliance : room.getAppliance()){
                
                //should find one  broken appliance
                if (appliance.getState().getClass().equals((new StateBroken(appliance)).getClass())){
                    assertEquals("Has to equal",new StateBroken(appliance).getClass(), appliance.getState().getClass());
                }
            }
        }
    }

    /**
     * Test of findRandomRoomWithAppliance method, of class PetApi.
     */
    @Test
    @Order(2)
    @Tag("Living")
    public void testFindRandomRoomWithAppliance() throws Exception {
        System.out.println("findRandomRoomWithAppliance");
        MainApi api = MainApi.getApi();
        House house = new FamilyHouseBuilder().buildHouse(api);
        Pet pet = new Pet("Luk", PetType.DOG, house, 10);
        PetApi ap = new PetApi(pet);
        Room instance = ap.findRandomRoomWithAppliance();
        assertTrue("Has to be greater than 0",instance.getAppliance().size() > 0);
    }

    /**
     * Test of goSleep method, of class PetApi.
     */
    @Test
    @Order(3)
    @Tag("Living")
    public void testGoSleep() throws Exception {
        MainApi api = MainApi.getApi();
        House house = new FamilyHouseBuilder().buildHouse(api);
        Pet pet = new Pet("Luk", PetType.DOG, house, 10);
        PetApi ap = new PetApi(pet);
        ap.goSleep();
        assertTrue("Has to be greater than 0",pet.getBusyTime() > 0);
    }

    /**
     * Test of slaveTheHumanRace method, of class PetApi.
     */
    @Test
    @Order(4)
    @Tag("Living")
    public void testSlaveTheHumanRace() throws Exception {
        System.out.println("slaveTheHumanRace");
        MainApi api = MainApi.getApi();
        House house = new FamilyHouseBuilder().buildHouse(api);
        Pet pet = new Pet("Luk", PetType.DOG, house, 10);
        PetApi instance = new PetApi(pet);
        instance.slaveTheHumanRace();
    }

    @ParameterizedTest
    @CsvSource(value = {
            //SUCCESS
            "Luk;Dog;14;success",
            "Las Des;Allien;23;success",
            "Vlasta Emre;Monkey;11;success",
            "Katua Kerem;Cat;3;success",
            "Kris Ott;Dog;9;success",

            //Exception
            //empty name and invalidt age
            ";Cat;150;Exception",
            //long name and invalid age
            "Hodne dlouhe jmeno snad je to uz dost;Dog;420;Exception",
            //wrong pet type and empty full name
            ";Parrot;28;Exception",
            //Negative age and pet type
            "Bobisek;Rhino;-4;Exception",
            //empty pet type name
            "Lucino;;45;Exception"
    }, delimiter = ';')
    @Order(5)
    @Tag("Living")
    void testLoadParametrizedPet(String name, String petType, Integer age, String expected) throws Exception {
        MainApi api = MainApi.getApi();
        House house = new FamilyHouseBuilder().buildHouse(api);
        if (expected.equals("Exception")) {
            Exception ex = assertThrows(Exception.class, () -> {
                Pet pet = new Pet(name, petType, house, age);
            }, "Exception was not trown");
        } if (expected.equals("success")) {
            assertDoesNotThrow(() -> {
                Pet pet = new Pet(name, petType, house, age);
            });
        }
    }

    
}
