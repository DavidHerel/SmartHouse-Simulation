package RandomEventsApi;

import static org.junit.Assert.*;

import Controls.MainApi;
import House.Builder.FamilyHouseBuilder;
import House.House;
import Pet.Pet;
import RandomEvents.RandomEvent;
import RandomEvents.RandomEventType;
import Sensor.Sensor;
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
public class RandomEventsApiTest {

    @ParameterizedTest
    @CsvSource(value = {
            //SUCCESS
            "Storm;9;success",
            "Sun;5;success",
            "Snow;1;success",
            "Sun;3;success",

            //Exception
            //empty type
            ";5;Exception",
            //empty type and wrong strength
            ";420;Exception",
            //wrong type and negative strength
            "Mist;-2;Exception",
            //Too much big sntregth
            "Cloudy;11;Exception",
    }, delimiter = ';')
    @Order(1)
    void testLoadParametrizedRandomEvent(String eventType, Integer strength, String expected) throws Exception {
        MainApi api = MainApi.getApi();
        House house = new FamilyHouseBuilder().buildHouse(api);
        if (expected.equals("Exception")) {
            Exception ex = assertThrows(Exception.class, () -> {
                RandomEvent randomEvent = new RandomEvent(eventType, house, strength);
            }, "Exception was not trown");
        } if (expected.equals("success")) {
            assertDoesNotThrow(() -> {
                RandomEvent randomEvent = new RandomEvent(eventType, house, strength);
            });
        }
    }
}
