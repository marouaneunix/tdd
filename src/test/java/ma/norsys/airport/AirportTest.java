package ma.norsys.airport;

import org.junit.jupiter.api.*;

import java.util.function.Predicate;

@DisplayName("An Airport test")
public class AirportTest {

    //Given : a Flight with two passengers, vip and not vip
    // When : I remove a simple passenger
    // Then : I can not remove it

    // When : i remove a vip passenger
    // Then : i can remove it

    Flight flight;

    @BeforeEach
    @Test
    @DisplayName("Given : A Flight with two passengers, vip and not vip")
    public void setUp() {
        flight = new Flight("f1");
        flight.passengers.add(new Passenger("marouane", false));
        flight.passengers.add(new Passenger("ayoub", true));
        Assertions.assertAll(
                () -> flight.passengers.stream().anyMatch(Passenger::isVip),
                () -> flight.passengers.stream().anyMatch(Predicate.not(Passenger::isVip)));
    }


}
