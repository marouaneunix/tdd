package ma.norsys.airport;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Flight {

    public String flightType;
    public Set<Passenger> passengers = new HashSet<>();


    public Flight(String flightType) {
        this.flightType = flightType;
    }

    public boolean addPassenger(Passenger passenger) {
        if(!flightType.equals("economy") && !flightType.equals("vip")) {
            throw new IllegalArgumentException();
        }
        if(flightType.equals("vip") && !passenger.isVip()) {
            return false;
        }
        return this.passengers.add(passenger);
    }

    public boolean removePassenger(Passenger passenger) {
        if(!passenger.isVip()){
            return false;
        }

        Set<Passenger> newPassengers = new HashSet<>();
        boolean isDeleted = false;
        for (Passenger currentPassenger: this.passengers) {
            if(currentPassenger.getName().equals(passenger.getName())) {
                isDeleted = true;
            } else {
                newPassengers.add(currentPassenger);
            }
        }
        this.passengers = newPassengers;
        return isDeleted;
    }
}
