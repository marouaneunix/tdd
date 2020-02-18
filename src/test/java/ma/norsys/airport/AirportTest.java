package ma.norsys.airport;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("An Airport test")
class AirportTest {

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
            void shouldAddToEconomyFlight() {
                assertAll(
                    () -> assertTrue(economyFlight.addPassenger(ayoub)),
                    () -> assertFalse(economyFlight.removePassenger(ayoub)),
                    () -> assertFalse(economyFlight.removePassenger(new Passenger("test", true))));
            }

            @Test
            @DisplayName("Then : Should add him one")
            void shouldAddHimOnce() {
                economyFlight.addPassenger(ayoub);
                economyFlight.addPassenger(ayoub);
                assertEquals(1, economyFlight.passengers.size());
            }
        }

        @Nested
        @DisplayName("When : We have a vip passenger")
        class VipPassengerTest {

            @Test
            @DisplayName("Then : You can add and remove him from an economy flight")
            void shouldRemoveOrAddFromEconomyFlight() {
                assertAll(
                        () -> assertTrue(economyFlight.addPassenger(marouane)),
                        () -> assertTrue(economyFlight.removePassenger(marouane)));
            }
        }
    }

    @Nested
    @DisplayName("Given there is an vip flight")
    class VipFlightTest {
        private Flight vipFlight;
        private Passenger marouane;
        private Passenger ayoub;

        @BeforeEach
        void setup() {
            vipFlight = new Flight("vip");
            marouane = new Passenger("marouane", true);
            ayoub = new Passenger("ayoub", false);
        }

        @Nested
        @DisplayName("When : We have a usual passenger")
        class UsualPassengerTest {

            @Test
            @DisplayName("Then : You can't add him from an vip flight")
            void shouldNotAddAUsualPassengerToVipFlightTest() {
                assertFalse(vipFlight.addPassenger(ayoub));
                assertEquals(0, vipFlight.passengers.size());
            }
        }

        @Nested
        @DisplayName("When : We have a vip passenger")
        class VipPassengerTest {

            @Test
            @DisplayName("Then : You can add and remove him from an economy flight")
            void shouldRemoveOrAddVipPassengerTest() {
                assertAll(
                        () -> assertTrue(vipFlight.addPassenger(marouane)),
                        () -> assertEquals(1, vipFlight.passengers.size()),
                        () -> assertTrue(vipFlight.removePassenger(marouane)),
                        () -> assertEquals(0, vipFlight.passengers.size()));
            }
        }
    }

    @Nested
    @DisplayName("Given there is an unknown flight type")
    class UnknownFlightTest {

        private Flight unknownFlight;
        private Passenger vip;
        private Passenger usual;

        @BeforeEach
        void setup() {
            unknownFlight = new Flight("unknown");
            vip = new Passenger("marouane", true);
            usual = new Passenger("ayoub", false);
        }

        @Nested
        @DisplayName("When: We have a vip or a usual passenger")
        class UsIpPassenger {
            @Test
            @DisplayName("Then : you can do nothing")
            void shouldThrowException() {
                assertThrows(IllegalArgumentException.class, () -> unknownFlight.addPassenger(vip));
                assertThrows(IllegalArgumentException.class, () -> unknownFlight.addPassenger(usual));
            }
        }
    }
}
