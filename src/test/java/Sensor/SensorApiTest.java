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
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class SensorApiTest {

    public SensorApiTest() {
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
    public void testReactToStorm() throws Exception {
        System.out.println("Testing method: reactToEvent");
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
}
