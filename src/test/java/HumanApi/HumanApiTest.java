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
public class HumanApiTest {
    /**
     * Test of goSleep method, of class HumanApi.
     */
    @Test
    @Order(1)
    @Tag("Living")
    public void testGoSleep() throws Exception {
        System.out.println("goSleep");
        MainApi api = MainApi.getApi();
        House house = new FamilyHouseBuilder().buildHouse(api);
        Human hm = new Adult(null, "name", house, 10, "male");
        HumanApi ap = new HumanApi(hm);
        ap.goSleep();
        assertTrue("Has to be greater than 0", hm.getBusyTime() > 0);
    }

    /**
     * Test of repairAppliance method, of class HumanApi.
     */
    @Test
    @Order(2)
    @Tag("Living")
    public void testRepairAppliance() throws Exception {
        System.out.println("repairAppliance");
        MainApi api = MainApi.getApi();
        House house = new FamilyHouseBuilder().buildHouse(api);
        ArrayList<HumanAbility> abilities = new ArrayList<>();
        abilities.add(HumanAbility.CAN_REPAIR);
        abilities.add(HumanAbility.CAN_SPORT);
        Human david = HumanFactory.createHuman("Adult", abilities, "David", house, 10, "Male");
        Appliance apl = new CoffeeMaker(1, new Documentation(5), 1, "Aas");
        david.getApi().repairAppliance(apl);
        assertTrue("Greater than 0", david.getBusyTime() > 0);
    }

    /**
     * Test of doSport method, of class HumanApi.
     */
    @Test
    @Order(3)
    @Tag("Living")
    public void testDoSport() throws Exception {
        System.out.println("DoSport");
        MainApi api = MainApi.getApi();
        House house = new FamilyHouseBuilder().buildHouse(api);
        ArrayList<HumanAbility> abilities = new ArrayList<>();
        abilities.add(HumanAbility.CAN_REPAIR);
        abilities.add(HumanAbility.CAN_SPORT);
        Human david = HumanFactory.createHuman("Adult", abilities, "David", house, 10, "Male");
        
        david.getApi().doSport();
        assertTrue("BusyTime (" + david.getBusyTime() + ") should be  60 (" + 60 + ")", david.getBusyTime() == 60);
    }

    /**
     * Test of findRandomRoomWithAppliance method, of class HumanApi.
     */
    @Test
    @Order(4)
    @Tag("Living")
    public void testFindRandomRoomWithAppliance() throws Exception {
        System.out.println("findRandomRoomWithAppliance");
        System.out.println("findRandomRoomWithAppliance");
        MainApi api = MainApi.getApi();
        House house = new FamilyHouseBuilder().buildHouse(api);
        Human hm = new Adult(null, "name", house, 10, "male");
        HumanApi ap = new HumanApi(hm);
        Room instance = ap.findRandomRoomWithAppliance();
        assertTrue("Has to be greater than 0", instance.getAppliance().size() > 0);
    }

    /**
     * Test of findRandomFreeAppliance method, of class HumanApi.
     */
    @Test
    @Order(5)
    @Tag("Living")
    public void testFindRandomFreeAppliance() throws Exception {
        System.out.println("findRandomFreeAppliance");
        MainApi api = MainApi.getApi();
        House house = new FamilyHouseBuilder().buildHouse(api);
        Human hm = new Adult(null, "name", house, 10, "male");
        HumanApi ap = new HumanApi(hm);
        Room instance = ap.findRandomRoomWithAppliance();
        Appliance app = ap.findRandomFreeAppliance(instance.getAppliance());
        assertTrue("Has to be 0", app.getBusyTime() == 0);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/SmartHouse-output-2-uni-expected.csv", numLinesToSkip = 1)
    @Order(6)
    @Tag("Living")
    public void testLoadfromCSVHuman(String name, Integer age, String gender, String expected) throws Exception {
        MainApi api = MainApi.getApi();
        House house = new FamilyHouseBuilder().buildHouse(api);
        if (expected.equals("Exception")) {
            Exception ex = assertThrows(Exception.class, () -> {
                Human human = HumanFactory.createHuman("Kid", null, name, house, age, gender);
            }, "Exception was not trown");
        } if (expected.equals("success")) {
            assertDoesNotThrow(() -> {
                Human human = HumanFactory.createHuman("Kid", null, name, house, age, gender);
            });
        }

    }


    
}
