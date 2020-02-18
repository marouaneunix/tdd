package ma.norsys.airport.service;

import ma.norsys.airport.Flight;
import ma.norsys.airport.Passenger;
import ma.norsys.airport.repository.FlightRepository;

import java.util.HashSet;
import java.util.Set;

public class FlightService {

    private FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public boolean addPassenger(Flight flight, Passenger passenger) {
        if(!flight.flightType.equals("economy") && !flight.flightType.equals("vip")) {
            throw new IllegalArgumentException();
        }
        if(flight.flightType.equals("vip") && !passenger.isVip()) {
            return false;
        }
        this.flightRepository.addPassenger(flight, passenger);
        return true;
    }

    public boolean removePassenger(Flight flight, Passenger passenger) {
        if(!passenger.isVip()){
            return false;
        }
        boolean isDeleted = false;
        for (Passenger currentPassenger: flight.passengers) {
            if(currentPassenger.getName().equals(passenger.getName())) {
                isDeleted = true;
                this.flightRepository.removePassenger(flight,passenger);
                break;
            }
        }
        return isDeleted;
    }
}
