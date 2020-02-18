package ma.norsys.airport.repository;

import ma.norsys.airport.Flight;
import ma.norsys.airport.Passenger;

public class FlightRepository {

    public void addPassenger(Flight flight, Passenger passenger) {
        System.out.println(flight.flightType+" "+passenger.getName());
    }

    public void removePassenger(Flight flight, Passenger passenger) {
        System.out.println(flight.flightType+" "+passenger.getName());
    }
}
