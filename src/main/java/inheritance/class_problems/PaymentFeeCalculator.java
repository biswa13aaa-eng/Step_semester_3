package inheritance.class_problems;

import java.util.Locale;

abstract class PaymentMethod {
    protected String type;
    protected double amount;

    public PaymentMethod(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public abstract double calculateFinalAmount();
}

class CardPayment extends PaymentMethod {
    public CardPayment(double amount) {
        super("CARD", amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount * 1.02;
    }
}

class WalletPayment extends PaymentMethod {
    public WalletPayment(double amount) {
        super("WALLET", amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount * 1.01;
    }
}

class BankTransferPayment extends PaymentMethod {
    public BankTransferPayment(double amount) {
        super("BANKTRANSFER", amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount;
    }
}

public class PaymentFeeCalculator {

    public static void processPayments(PaymentMethod[] payments) {
        double total = 0.0;
        for (PaymentMethod p : payments) {
            double finalAmount = p.calculateFinalAmount();
            System.out.printf(Locale.US, "%s: %.2f%n", p.getType(), finalAmount);
            total += finalAmount;
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }

    public static void main(String[] args) {
        PaymentMethod[] payments = {
            new CardPayment(1000),
            new WalletPayment(500),
            new BankTransferPayment(2000)
        };
        processPayments(payments);
    }
}