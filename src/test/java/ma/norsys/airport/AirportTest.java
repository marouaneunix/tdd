package ma.norsys.airport;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("An Airport test")
public class AirportTest {

    //Given : a Flight with two passengers, vip and not vip
    // When : I remove a simple passenger
    // Then : I can not remove it

    // When : i remove a vip passenger
    // Then : i can remove it

    @Nested
    @DisplayName("Given there is an economy flight")
    class EconomyFlightTest {
        private Flight economyFlight;
        private Passenger marouane;
        private Passenger ayoub;

        @BeforeEach
        void setup() {
            economyFlight = new Flight("economy");
            marouane = new Passenger("marouane", true);
            ayoub = new Passenger("ayoub", false);
        }

        @Nested
        @DisplayName("When : We have a usual passenger")
        class UsualPassengerTest {

            @Test
            @DisplayName("Then : You can add and remove him from an economy flight")
            void shouldRemoveOrAddTest() {
                assertAll(
                    () -> assertTrue(economyFlight.addPassenger(ayoub)),
                    () -> assertFalse(economyFlight.removePassenger(ayoub)));
            }
        }

        @Nested
        @DisplayName("When : We have a vip passenger")
        class VipPassengerTest {

            @Test
            @DisplayName("Then : You can add and remove him from an economy flight")
            void shouldRemoveOrAddTest() {
                assertAll(
                        () -> assertTrue(economyFlight.addPassenger(marouane)),
                        () -> assertTrue(economyFlight.removePassenger(marouane)));
            }
        }


    }
}
