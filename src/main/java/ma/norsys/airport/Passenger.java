package ma.norsys.airport;

import java.util.Objects;

public class Passenger {

    private String name;
    private boolean vip;

    public Passenger(String name, boolean vip) {
        this.name = name;
        this.vip = vip;
    }

    public boolean isVip() {
        return vip;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", vip=" + vip +
                '}';
    }
}
