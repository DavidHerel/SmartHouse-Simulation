package HouseApi;

import Appliance.Appliance;
import Controls.MainApi;
import Equipment.Equipment;
import Furniture.Furniture;
import House.Builder.FamilyHouseBuilder;
import House.FamilyHouse;
import House.House;
import Room.Room;
import Room.RoomType;
import House.Window;
import org.junit.jupiter.api.*;
import Appliance.Computer;
import Appliance.Documentation;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

/**
 *
 * @author fuji
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HouseApiTest {

    /**
     * Test blinds and windows functionality
     * @throws Exception
     */
    @Test
    @Order(4)
    @Tag("House")
    public void testBlinds() throws Exception{
        System.out.println("Test if closing blinds affects multiple windows");
        MainApi api = MainApi.getApi();
        House myHouse = new FamilyHouseBuilder().buildHouse(api);
        //family house has 4 windows initially
        ArrayList<Window> windows = myHouse.getWindows();
        int numBlinds = 0;
        int closedCounter = 0;
        int openCounter = 0;
        //open all the blinds
        for (int i = 0; i < windows.size(); i++) {
            windows.get(i).getBlinds().setClosed(Boolean.FALSE);
            numBlinds += 1;
        }
        //close blinds of a window
        windows.get(0).getBlinds().setClosed(Boolean.TRUE);
        for (int i = 0; i < windows.size(); i++) {
            if (windows.get(i).getBlinds().isClosed() == Boolean.TRUE) {
                closedCounter += 1;
            } else {
                openCounter += 1;
            }
        }
        assertTrue("All blinds accept from one should be open ", numBlinds==openCounter+closedCounter);
    }

    /**
     * Check if adding an appliance to a House increases the energy consumption
     * @throws Exception
     */
    @Test
    @Order(3)
    @Tag("House")
    public void testConsumptionOfHouseAddAppliance() throws Exception{
        System.out.println("Consumption test when we add a new appliance");
        MainApi api = MainApi.getApi();
        House myHouse = new FamilyHouseBuilder().buildHouse(api);
        ArrayList<Room> rooms = myHouse.getRooms();
        Room firstRoom = rooms.get(0);
        ArrayList<Appliance> appliancesInFirstRoom = firstRoom.getAppliance();
        Appliance newAppliance = new Computer(5, new Documentation(45), 0, "Samsung");

        // turn all appliances on and measure initial consumption
        for (int i = 0; i < appliancesInFirstRoom.size(); i++) {
            appliancesInFirstRoom.get(i).getApi().work(appliancesInFirstRoom.get(i));
        }
        int initConsumption = myHouse.getConsumption(myHouse);

        //add a new appliance to first room, turn all appliances on and measure the house consumption
        firstRoom.addAppliance(newAppliance);
        for (int i = 0; i < appliancesInFirstRoom.size(); i++) {
            appliancesInFirstRoom.get(i).getApi().work(appliancesInFirstRoom.get(i));
        }
        int finalConsumption = myHouse.getConsumption(myHouse);
        assertTrue("House consumption increased when we add a new appliance ", finalConsumption>initConsumption);
    }

    /**
     * Check if House consumes energy when appliances are working
     * @throws Exception
     */
    @Test
    @Order(2)
    @Tag("House")
    public void testConsumptionOfHouseWhenAppliancesWorking() throws Exception{
        System.out.println("Consumption test when appliances are working");
        MainApi api = MainApi.getApi();
        House myHouse = new FamilyHouseBuilder().buildHouse(api);
        ArrayList<Room> rooms = myHouse.getRooms();
        ArrayList<Appliance> appliancesInFirstRoom = rooms.get(0).getAppliance();

        //consumption before we activate an equipment, this should equal zero
        int initConsumption = myHouse.getConsumption(myHouse);
        assertTrue("Initial house consumption should be 0 ", initConsumption==0);

        // turn all appliances on
        for (int i = 0; i < appliancesInFirstRoom.size(); i++) {
            appliancesInFirstRoom.get(i).getApi().work(appliancesInFirstRoom.get(i));
        }
        int finalConsumption = myHouse.getConsumption(myHouse);
        assertTrue("House consumption increased when appliances are working ", finalConsumption>0);
    }

    /**
     * Check if empty House consumes no energy
     * @throws Exception
     */
    @Test
    @Order(1)
    @Tag("House")
    public void testConsumptionOfEmptyHouse() throws Exception{
        System.out.println("Consumption test of an empty house");
        MainApi api = MainApi.getApi();
        Room room = new Room(RoomType.BEDROOM, new ArrayList<Appliance>(), new ArrayList<Furniture>(), 0, 1);
        ArrayList<Room> rooms = new ArrayList<Room>();
        rooms.add(room);
        House emptyHouse = new FamilyHouse(rooms, new ArrayList<Window>(), new ArrayList<Equipment>(), api);
        ArrayList<Appliance> appliancesInFirstRoom = room.getAppliance();
        // turn all appliances on
        for (int i = 0; i < appliancesInFirstRoom.size(); i++) {
            appliancesInFirstRoom.get(i).getApi().work(appliancesInFirstRoom.get(i));
        }
        int finalConsumption = emptyHouse.getConsumption(emptyHouse);
        assertTrue("Empty house should consume no energy ", finalConsumption==0);
    }

}
