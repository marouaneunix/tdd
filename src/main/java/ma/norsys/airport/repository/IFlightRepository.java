package ma.norsys.airport.repository;

import ma.norsys.airport.Flight;
import ma.norsys.airport.Passenger;

public interface IFlightRepository {

    void addPassenger(Flight flight, Passenger passenger);
    void removePassenger(Flight flight, Passenger passenger);
}
