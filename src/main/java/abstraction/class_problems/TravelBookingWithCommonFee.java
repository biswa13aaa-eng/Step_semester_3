package abstraction.class_problems;

import java.util.Locale;

abstract class TravelBooking {
    protected static final double BOOKING_FEE = 50.0;
    protected String mode;
    protected double distanceKm;

    public TravelBooking(String mode, double distanceKm) {
        this.mode = mode;
        this.distanceKm = distanceKm;
    }

    public String getMode() {
        return mode;
    }

    public abstract double calculateBaseFare();

    public double calculateTotalFare() {
        return calculateBaseFare() + BOOKING_FEE;
    }
}

class BusBooking extends TravelBooking {
    public BusBooking(double distanceKm) {
        super("BUS", distanceKm);
    }

    @Override
    public double calculateBaseFare() {
        return 2.0 * distanceKm;
    }
}

class TrainBooking extends TravelBooking {
    public TrainBooking(double distanceKm) {
        super("TRAIN", distanceKm);
    }

    @Override
    public double calculateBaseFare() {
        return 1.5 * distanceKm;
    }
}

class FlightBooking extends TravelBooking {
    public FlightBooking(double distanceKm) {
        super("FLIGHT", distanceKm);
    }

    @Override
    public double calculateBaseFare() {
        return 2500.0 + (4.0 * distanceKm);
    }
}

public class TravelBookingWithCommonFee {

    public static void processBookings(TravelBooking[] bookings) {
        for (TravelBooking b : bookings) {
            System.out.printf(Locale.US, "%s: %.2f%n", b.getMode(), b.calculateTotalFare());
        }
    }

    public static void main(String[] args) {
        TravelBooking[] bookings = {
            new BusBooking(200),
            new TrainBooking(300),
            new FlightBooking(500)
        };
        processBookings(bookings);
    }
}