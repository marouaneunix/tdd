package ma.norsys.airport;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Airport {
    private final static Logger LOGGER = Logger.getLogger(Airport.class.getName());

    public static void main(String[] args) {
        Flight economyFlight = new Flight("economy");

        economyFlight.addPassenger(new Passenger("marouane", true));
        economyFlight.addPassenger(new Passenger("ayoub", false));
        LOGGER.log(Level.INFO, "After adding : ${0}", economyFlight);

        economyFlight.removePassenger(new Passenger("marouane", true));
        LOGGER.log(Level.INFO, "After removing : ${0}", economyFlight);


        economyFlight.removePassenger(new Passenger("ayoub", false));
        LOGGER.log(Level.INFO, "After 2nd removing : ${0}", economyFlight);

    }
}
