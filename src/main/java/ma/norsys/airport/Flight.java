package ma.norsys.airport;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Flight {

    public String flightType;
    public List<Passenger> passengers = new ArrayList<>();


    public Flight(String flightType) {
        this.flightType = flightType;
    }

    public boolean addPassenger(Passenger passenger) {
        if(!this.flightType.equals("economy") && this.flightType.equals("vip")) {
            return false;
        }
        return this.passengers.add(passenger);
    }

    public boolean removePassenger(Passenger passenger) {
        if(!passenger.isVip()){
            return false;
        }
        this.passengers = this.passengers
            .stream()
            .filter(passenger1 -> passenger.getName().equals(passenger1.getName()))
            .collect(Collectors.toList());
        return true;

    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightType='" + flightType + '\'' +
                ", passengers=" + passengers +
                '}';
    }
}
