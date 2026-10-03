package abstraction.assigment_problems;

import java.util.Locale;

interface Insurable {
    double calculateInsurance();
}

abstract class Parcel {
    protected String type;
    protected double weightKg;
    protected double declaredValue;

    public Parcel(String type, double weightKg, double declaredValue) {
        this.type = type;
        this.weightKg = weightKg;
        this.declaredValue = declaredValue;
    }

    public String getType() {
        return type;
    }

    public abstract double calculateShippingCharge();
}

class StandardParcel extends Parcel {
    public StandardParcel(double weightKg, double declaredValue) {
        super("STANDARD", weightKg, declaredValue);
    }

    @Override
    public double calculateShippingCharge() {
        return 40.0 + (10.0 * weightKg);
    }
}

class ExpressParcel extends Parcel implements Insurable {
    public ExpressParcel(double weightKg, double declaredValue) {
        super("EXPRESS", weightKg, declaredValue);
    }

    @Override
    public double calculateShippingCharge() {
        return 80.0 + (15.0 * weightKg);
    }

    @Override
    public double calculateInsurance() {
        return 0.02 * declaredValue;
    }
}

class FragileParcel extends Parcel implements Insurable {
    public FragileParcel(double weightKg, double declaredValue) {
        super("FRAGILE", weightKg, declaredValue);
    }

    @Override
    public double calculateShippingCharge() {
        return 40.0 + (10.0 * weightKg) + 50.0;
    }

    @Override
    public double calculateInsurance() {
        return 0.02 * declaredValue;
    }
}

public class ParcelShippingDesk {

    public static void processParcels(Parcel[] parcels) {
        double grandTotal = 0.0;
        for (Parcel p : parcels) {
            double charge = p.calculateShippingCharge();
            double insurance = (p instanceof Insurable) ? ((Insurable) p).calculateInsurance() : 0.0;
            double total = charge + insurance;
            System.out.printf(Locale.US, "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n", p.getType(), charge, insurance, total);
            grandTotal += total;
        }
        System.out.printf(Locale.US, "Grand Total: %.2f%n", grandTotal);
    }

    public static void main(String[] args) {
        Parcel[] parcels = {
            new StandardParcel(3, 500),
            new ExpressParcel(2, 1000),
            new FragileParcel(4, 2000)
        };
        processParcels(parcels);
    }
}