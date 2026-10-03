package inheritance.assigment_problems;

import java.util.Locale;

abstract class Room {
    protected String type;
    protected int units;

    public Room(String type, int units) {
        this.type = type;
        this.units = units;
    }

    public String getType() {
        return type;
    }

    public abstract double calculateBill();
}

class SingleRoom extends Room {
    public SingleRoom(int units) {
        super("SINGLE", units);
    }

    @Override
    public double calculateBill() {
        return units * 8.0;
    }
}

class SharedRoom extends Room {
    private int occupants;

    public SharedRoom(int units, int occupants) {
        super("SHARED", units);
        this.occupants = occupants;
    }

    @Override
    public double calculateBill() {
        return (units * 6.0) / occupants;
    }
}

class ACRoom extends Room {
    public ACRoom(int units) {
        super("AC", units);
    }

    @Override
    public double calculateBill() {
        return (units * 10.0) + 200.0;
    }
}

public class HostelElectricityBill {

    public static void processRooms(Room[] rooms) {
        double total = 0.0;
        for (Room r : rooms) {
            double bill = r.calculateBill();
            System.out.printf(Locale.US, "%s: %.2f%n", r.getType(), bill);
            total += bill;
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }

    public static void main(String[] args) {
        Room[] rooms = {
            new SingleRoom(120),
            new SharedRoom(150, 3),
            new ACRoom(100)
        };
        processRooms(rooms);
    }
}