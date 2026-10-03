package inheritance.assigment_problems;

import java.util.Locale;

abstract class Vehicle {
    protected String type;
    protected int hours;

    public Vehicle(String type, int hours) {
        this.type = type;
        this.hours = hours;
    }

    public String getType() {
        return type;
    }

    public abstract double calculateCharge();
}

class Bike extends Vehicle {
    public Bike(int hours) {
        super("BIKE", hours);
    }

    @Override
    public double calculateCharge() {
        return hours * 10.0;
    }
}

class Car extends Vehicle {
    public Car(int hours) {
        super("CAR", hours);
    }

    @Override
    public double calculateCharge() {
        if (hours <= 0) return 0.0;
        return 30.0 + (hours - 1) * 20.0;
    }
}

class Truck extends Vehicle {
    public Truck(int hours) {
        super("TRUCK", hours);
    }

    @Override
    public double calculateCharge() {
        return Math.max(100.0, hours * 50.0);
    }
}

public class CampusParkingCalculator {

    public static void processVehicles(Vehicle[] vehicles) {
        double total = 0.0;
        for (Vehicle v : vehicles) {
            double charge = v.calculateCharge();
            System.out.printf(Locale.US, "%s: %.2f%n", v.getType(), charge);
            total += charge;
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }

    public static void main(String[] args) {
        Vehicle[] vehicles = {
            new Bike(3),
            new Car(4),
            new Truck(1),
            new Car(1)
        };
        processVehicles(vehicles);
    }
}