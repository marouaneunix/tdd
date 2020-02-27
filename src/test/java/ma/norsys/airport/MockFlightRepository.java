package ma.norsys.airport;

import ma.norsys.airport.repository.IFlightRepository;

public class MockFlightRepository implements IFlightRepository {

    @Override
    public void addPassenger(Flight flight, Passenger passenger) {
        System.out.println("Is mock for add Passenger");
    }

    @Override
    public void removePassenger(Flight flight, Passenger passenger) {
        System.out.println("Is mock for remove Passenger");
    }
}
