package Sensor;
import Appliance.Appliance;
import Appliance.CoffeeMaker;
import Appliance.Documentation;
import Appliance.State.StateBroken;
import Controls.MainApi;
import House.Builder.FamilyHouseBuilder;
import House.House;
import Pet.Pet;
import Pet.PetType;
import RandomEvents.RandomEvent;
import RandomEvents.RandomEventType;
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

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SensorApiTest {

    /**
     * Test sensor reaction to storm
     */
    @Test
    @Order(1)
    @Tag("House")
    public void testReactToStorm() throws Exception {
        System.out.println("Testing method: reactToStorm");
        MainApi api = MainApi.getApi();
        House house = new FamilyHouseBuilder().buildHouse(api);
        Sensor sensor = new Sensor(house);
        RandomEvent randomEvent = new RandomEvent(RandomEventType.STORM, house, 10);
        //breaks one appliance
        sensor.getApi().visit(randomEvent, sensor);

        //check
        sensor.getHouse().getWindows().forEach(window -> {  assertTrue("Windows has to be shut", window.getIsShut());
            assertTrue("Windows has to be shut", window.getBlinds().isClosed());

        });
    }

    /**
     * Test sensor reaction to sun
     */
    @Test
    @Order(2)
    @Tag("House")
    public void testReactToSun() throws Exception {
        System.out.println("Testing method: reactToSun");
        MainApi api = MainApi.getApi();
        House house = new FamilyHouseBuilder().buildHouse(api);
        Sensor sensor = new Sensor(house);
        RandomEvent randomEvent = new RandomEvent(RandomEventType.SUN, house, 10);

        //breaks one appliance
        sensor.getApi().visit(randomEvent, sensor);

        //check
        sensor.getHouse().getWindows().forEach(window -> {  assertFalse("Windows can not be shut", window.getIsShut());
            assertTrue("Windows has to be shut", window.getBlinds().isClosed());

        });
        sensor.getApi().restoreState(sensor);
    }


    /**
     * Test sensor reaction to Snow
     */
    @Test
    @Order(3)
    @Tag("House")
    public void testReactToSnow() throws Exception {
        System.out.println("Testing method: reactToSnow");
        MainApi api = MainApi.getApi();
        House house = new FamilyHouseBuilder().buildHouse(api);
        Sensor sensor = new Sensor(house);
        RandomEvent randomEvent = new RandomEvent(RandomEventType.SNOW, house, 10);

        //breaks one appliance
        sensor.getApi().visit(randomEvent, sensor);

        //check
        assertTrue("Temperature has to be 27 Celsius",   sensor.getHouse().getTemperature() == 27);
        sensor.getApi().restoreState(sensor);
    }

    /**
     * Test sensor reaction to Wind.
     */
    @Test
    @Order(4)
    @Tag("House")
    public void testReactToWind() throws Exception {
        System.out.println("Testing method: reactToEvent");
        MainApi api = MainApi.getApi();
        House house = new FamilyHouseBuilder().buildHouse(api);
        Sensor sensor = new Sensor(house);
        RandomEvent randomEvent = new RandomEvent(RandomEventType.WIND, house, 10);

        //breaks one appliance
        sensor.getApi().visit(randomEvent, sensor);

        //check
        sensor.getHouse().getWindows().forEach(window -> {  assertTrue("Windows has to be shut", window.getIsShut());
        });
        sensor.getApi().restoreState(sensor);
    }

    /**
     * Test of doRandomStuff method, of class PetApi.
     */
    @Test
    @Order(5)
    @Tag("House")
    public void testReactToUnknown() throws Exception {
        System.out.println("Testing method: reactToEvent");
        MainApi api = MainApi.getApi();
        House house = new FamilyHouseBuilder().buildHouse(api);
        Sensor sensor = new Sensor(house);
        Exception ex = assertThrows(Exception.class, () -> {
            RandomEvent randomEvent = new RandomEvent("Mist", house, 10);
        }, "Exception was not trown");
    }

}
