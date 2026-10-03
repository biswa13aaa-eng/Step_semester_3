package abstraction.assigment_problems;

import java.util.Locale;

interface SaverModeCapable {}

abstract class Appliance {
    protected String name;
    protected double powerWatts;
    protected double hours;

    public Appliance(String name, double powerWatts, double hours) {
        this.name = name;
        this.powerWatts = powerWatts;
        this.hours = hours;
    }

    public String getName() {
        return name;
    }

    public double calculateBaseUnits() {
        return (powerWatts * hours) / 1000.0;
    }
}

class FridgeAppliance extends Appliance {
    public FridgeAppliance(double hours) {
        super("FRIDGE", 150.0, hours);
    }
}

class ACAppliance extends Appliance implements SaverModeCapable {
    public ACAppliance(double hours) {
        super("AC", 1500.0, hours);
    }
}

class TVAppliance extends Appliance {
    public TVAppliance(double hours) {
        super("TV", 100.0, hours);
    }
}

class WasherAppliance extends Appliance implements SaverModeCapable {
    public WasherAppliance(double hours) {
        super("WASHER", 500.0, hours);
    }
}

public class HomeApplianceEnergyReport {

    public static void processAppliances(Appliance[] appliances, boolean[] isSaverMode) {
        double totalCost = 0.0;
        for (int i = 0; i < appliances.length; i++) {
            Appliance a = appliances[i];
            boolean saver = isSaverMode[i];
            if (saver && !(a instanceof SaverModeCapable)) {
                System.out.println(a.getName() + ": saver mode not supported");
                continue;
            }
            double units = a.calculateBaseUnits();
            if (saver) {
                units *= 0.75;
            }
            double cost = units * 8.0;
            System.out.printf(Locale.US, "%s: Units=%.2f Cost=%.2f%n", a.getName(), units, cost);
            totalCost += cost;
        }
        System.out.printf(Locale.US, "Total Cost: %.2f%n", totalCost);
    }

    public static void main(String[] args) {
        Appliance[] appliances = {
            new FridgeAppliance(24),
            new ACAppliance(8),
            new TVAppliance(5),
            new WasherAppliance(2)
        };
        boolean[] isSaver = {false, true, false, true};
        processAppliances(appliances, isSaver);
    }
}