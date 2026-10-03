package inheritance.class_problems;

import java.util.Locale;

abstract class Transport {
    protected String type;
    protected double distance;

    public Transport(String type, double distance) {
        this.type = type;
        this.distance = distance;
    }

    public String getType() {
        return type;
    }

    public abstract double calculateFare();
}

class BusTransport extends Transport {
    public BusTransport(double distance) {
        super("BUS", distance);
    }

    @Override
    public double calculateFare() {
        return Math.min(10.0, 2.0 + (0.10 * distance));
    }
}

class TrainTransport extends Transport {
    public TrainTransport(double distance) {
        super("TRAIN", distance);
    }

    @Override
    public double calculateFare() {
        return 3.0 + (0.15 * distance);
    }
}

class MetroTransport extends Transport {
    private double peakHourFactor;

    public MetroTransport(double distance, double peakHourFactor) {
        super("METRO", distance);
        this.peakHourFactor = peakHourFactor;
    }

    @Override
    public double calculateFare() {
        return (1.50 + (0.20 * distance)) * peakHourFactor;
    }
}

public class TransportFareCalculator {

    public static void processTransports(Transport[] transports) {
        double total = 0.0;
        for (Transport t : transports) {
            double fare = t.calculateFare();
            System.out.printf(Locale.US, "%s: %.2f%n", t.getType(), fare);
            total += fare;
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }

    public static void main(String[] args) {
        Transport[] transports = {
            new BusTransport(15),
            new TrainTransport(50),
            new MetroTransport(10, 1.5)
        };
        processTransports(transports);
    }
}