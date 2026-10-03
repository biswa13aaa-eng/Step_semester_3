package inheritance.assigment_problems;

import java.util.Locale;

abstract class Customer {
    protected String type;
    protected double amount;

    public Customer(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public abstract double calculateFinalAmount();
}

class StudentCustomer extends Customer {
    public StudentCustomer(double amount) {
        super("STUDENT", amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount * 0.90;
    }
}

class StaffCustomer extends Customer {
    public StaffCustomer(double amount) {
        super("STAFF", amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount * 0.95;
    }
}

class GuestCustomer extends Customer {
    public GuestCustomer(double amount) {
        super("GUEST", amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount + 10.0;
    }
}

public class CanteenBillingCounter {

    public static void processBills(Customer[] customers) {
        double total = 0.0;
        for (Customer c : customers) {
            double finalAmount = c.calculateFinalAmount();
            System.out.printf(Locale.US, "%s: %.2f%n", c.getType(), finalAmount);
            total += finalAmount;
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }

    public static void main(String[] args) {
        Customer[] customers = {
            new StudentCustomer(200),
            new StaffCustomer(300),
            new GuestCustomer(150)
        };
        processBills(customers);
    }
}