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

    public void addPassenger(Passenger passenger) {
        if(this.flightType.equals("economy")){
            this.passengers.add(passenger);
        }else {
            if(passenger.isVip()) {
                this.passengers.add(passenger);
            } else {
                throw new RuntimeException("ERROR");
            }
        }
    }

    public void removePassenger(Passenger passenger) {

        if(passenger.isVip()) {
            this.passengers = this.passengers
                    .stream()
                    .filter(passenger1 -> passenger.getName().equals(passenger1.getName()))
                    .collect(Collectors.toList());
            } else {
            throw new RuntimeException("Error");
        }
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightType='" + flightType + '\'' +
                ", passengers=" + passengers +
                '}';
    }
}
