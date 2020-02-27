package ma.norsys.airport.repository;

import ma.norsys.airport.Flight;
import ma.norsys.airport.Passenger;

import java.util.*;

public class FlightRepository implements IFlightRepository{

    private Map<Flight, Set<Passenger>> flight;


    public FlightRepository() {
        this.flight = Map.of(
                new Flight("economy"), Set.of(new Passenger("marouane", true)),
                new Flight("economy"), Set.of(new Passenger("marouane", true)),
                new Flight("economy"), Set.of(new Passenger("marouane", true)),
                new Flight("economy"), Set.of(new Passenger("marouane", true)),
                new Flight("economy"), Set.of(new Passenger("marouane", true)));
    }

    public void addPassenger(Flight flight, Passenger passenger) {
        if (this.flight.containsKey(flight)) {
            this.flight.get(flight).add(passenger);
        }
        this.flight.put(flight, Set.of(passenger));
        System.out.println(flight.flightType+" "+passenger.getName());
    }

    public void removePassenger(Flight flight, Passenger passenger) {
        Objects.requireNonNull(flight, "Should not be null");
        Objects.requireNonNull(passenger, "Should not be null");

        if(!this.flight.containsKey(flight)) {
            throw new IllegalArgumentException();
        }
            this.flight.get(flight).remove(passenger);
    }
}
