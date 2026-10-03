package abstraction.assigment_problems;

import java.util.Locale;

abstract class Ticket {
    protected static final double CONVENIENCE_FEE = 20.0;
    protected String seatType;
    protected int count;

    public Ticket(String seatType, int count) {
        this.seatType = seatType;
        this.count = count;
    }

    public String getSeatType() {
        return seatType;
    }

    public abstract double getPricePerTicket();

    public double calculateTotal() {
        return count * (getPricePerTicket() + CONVENIENCE_FEE);
    }
}

class RegularTicket extends Ticket {
    public RegularTicket(int count) {
        super("REGULAR", count);
    }

    @Override
    public double getPricePerTicket() {
        return 150.0;
    }
}

class PremiumTicket extends Ticket {
    public PremiumTicket(int count) {
        super("PREMIUM", count);
    }

    @Override
    public double getPricePerTicket() {
        return 250.0;
    }
}

class ReclinerTicket extends Ticket {
    public ReclinerTicket(int count) {
        super("RECLINER", count);
    }

    @Override
    public double getPricePerTicket() {
        return 400.0;
    }
}

public class MovieTicketCounter {

    public static void processBookings(Ticket[] tickets) {
        double total = 0.0;
        for (Ticket t : tickets) {
            double amount = t.calculateTotal();
            System.out.printf(Locale.US, "%s: %.2f%n", t.getSeatType(), amount);
            total += amount;
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }

    public static void main(String[] args) {
        Ticket[] tickets = {
            new RegularTicket(3),
            new PremiumTicket(2),
            new ReclinerTicket(1)
        };
        processBookings(tickets);
    }
}