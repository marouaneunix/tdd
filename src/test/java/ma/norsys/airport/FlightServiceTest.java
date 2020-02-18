package ma.norsys.airport;

import ma.norsys.airport.repository.FlightRepository;
import ma.norsys.airport.service.FlightService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.lenient;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class FlightServiceTest {

    @Mock
    FlightRepository flightRepository;



    @DisplayName("Should add Passenger")
    @Test
    public void shouldAddPassenger() {
        lenient().doNothing().when(flightRepository).removePassenger(any(), any());
        Flight flight = new Flight("vip");
        Passenger passenger = new Passenger("marouane", true);
        FlightService flightService = new FlightService(flightRepository);

        Assertions.assertTrue(flightService.addPassenger(flight, passenger));


    }
}
