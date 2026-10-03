package abstraction.assigment_problems;

import java.util.Locale;

interface NightServiceable {}

abstract class Cab {
    protected String type;
    protected double km;

    public Cab(String type, double km) {
        this.type = type;
        this.km = km;
    }

    public String getType() {
        return type;
    }

    public abstract double getRatePerKm();

    public double calculateBaseFare() {
        return Math.max(100.0, km * getRatePerKm());
    }
}

class MiniCab extends Cab {
    public MiniCab(double km) {
        super("MINI", km);
    }

    @Override
    public double getRatePerKm() {
        return 10.0;
    }
}

class SedanCab extends Cab implements NightServiceable {
    public SedanCab(double km) {
        super("SEDAN", km);
    }

    @Override
    public double getRatePerKm() {
        return 14.0;
    }
}

class SUVCab extends Cab implements NightServiceable {
    public SUVCab(double km) {
        super("SUV", km);
    }

    @Override
    public double getRatePerKm() {
        return 18.0;
    }
}

public class CityCabFareMeter {

    public static void processTrips(Cab[] cabs, String[] times) {
        double total = 0.0;
        for (int i = 0; i < cabs.length; i++) {
            Cab cab = cabs[i];
            String time = times[i];
            if ("NIGHT".equalsIgnoreCase(time)) {
                if (!(cab instanceof NightServiceable)) {
                    System.out.println(cab.getType() + ": night service not available");
                    continue;
                }
                double fare = cab.calculateBaseFare() * 1.20;
                System.out.printf(Locale.US, "%s: %.2f%n", cab.getType(), fare);
                total += fare;
            } else {
                double fare = cab.calculateBaseFare();
                System.out.printf(Locale.US, "%s: %.2f%n", cab.getType(), fare);
                total += fare;
            }
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }

    public static void main(String[] args) {
        Cab[] cabs = {
            new MiniCab(8),
            new SedanCab(10),
            new SUVCab(20),
            new MiniCab(5)
        };
        String[] times = {"DAY", "NIGHT", "DAY", "NIGHT"};
        processTrips(cabs, times);
    }
}