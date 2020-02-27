package ma.norsys.airport;

import ma.norsys.airport.repository.FlightRepository;
import ma.norsys.airport.service.FlightService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.doubleThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FlightServiceTest {

    @Mock
    FlightRepository flightRepository;

    @InjectMocks
    FlightService flightService;

    @DisplayName("Should add Passenger")
    @Test
    public void shouldAddPassenger() {
        doNothing().when(flightRepository).addPassenger(any(), any());
        Flight flight = new Flight("vip");
        Passenger passenger = new Passenger("marouane", true);
        flightService.addPassenger(flight, passenger);


        verify(flightRepository).addPassenger(any(), any());


    }
}
