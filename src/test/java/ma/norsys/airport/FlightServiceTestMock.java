package ma.norsys.airport;

import ma.norsys.airport.repository.IFlightRepository;
import ma.norsys.airport.service.FlightService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

public class FlightServiceTestMock {

    private FlightService flightService;
    private IFlightRepository flightRepository;

    @BeforeEach
    void setUp() {
        flightRepository = new MockFlightRepository();
        flightService = new FlightService(flightRepository);
    }

    @DisplayName("Should add Passenger")
    @Test
    public void shouldAddPassenger() {
        Flight flight = new Flight("vip");
        Passenger passenger = new Passenger("marouane", true);
        flightService.addPassenger(flight, passenger);
    }
}
