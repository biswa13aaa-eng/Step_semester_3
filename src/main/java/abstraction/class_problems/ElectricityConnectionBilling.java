package abstraction.class_problems;

import java.util.Locale;

abstract class ElectricityConnection {
    protected String type;
    protected int units;

    public ElectricityConnection(String type, int units) {
        this.type = type;
        this.units = units;
    }

    public String getType() {
        return type;
    }

    public abstract double calculateBill();
}

class HomeConnection extends ElectricityConnection {
    public HomeConnection(int units) {
        super("HOME", units);
    }

    @Override
    public double calculateBill() {
        if (units <= 100) {
            return units * 5.0;
        } else {
            return (100 * 5.0) + ((units - 100) * 7.0);
        }
    }
}

class ShopConnection extends ElectricityConnection {
    public ShopConnection(int units) {
        super("SHOP", units);
    }

    @Override
    public double calculateBill() {
        return (units * 8.0) + 100.0;
    }
}

class FactoryConnection extends ElectricityConnection {
    public FactoryConnection(int units) {
        super("FACTORY", units);
    }

    @Override
    public double calculateBill() {
        return Math.max(1000.0, units * 6.0);
    }
}

public class ElectricityConnectionBilling {

    public static void generateBills(ElectricityConnection[] connections) {
        double total = 0.0;
        for (ElectricityConnection c : connections) {
            double bill = c.calculateBill();
            System.out.printf(Locale.US, "%s: %.2f%n", c.getType(), bill);
            total += bill;
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }

    public static void main(String[] args) {
        ElectricityConnection[] connections = {
            new HomeConnection(150),
            new ShopConnection(90),
            new FactoryConnection(120)
        };
        generateBills(connections);
    }
}