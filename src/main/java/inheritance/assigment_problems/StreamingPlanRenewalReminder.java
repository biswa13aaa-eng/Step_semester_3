package inheritance.assigment_problems;

import java.time.LocalDate;

abstract class SubscriptionPlan {
    protected String name;
    protected LocalDate startDate;

    public SubscriptionPlan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    public String getName() {
        return name;
    }

    public abstract LocalDate getRenewalDate();
}

class BasicPlan extends SubscriptionPlan {
    public BasicPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    public LocalDate getRenewalDate() {
        return startDate.plusDays(30);
    }
}

class StandardPlan extends SubscriptionPlan {
    public StandardPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    public LocalDate getRenewalDate() {
        return startDate.plusDays(90);
    }
}

class PremiumPlan extends SubscriptionPlan {
    public PremiumPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    public LocalDate getRenewalDate() {
        return startDate.plusDays(365);
    }
}

public class StreamingPlanRenewalReminder {

    public static void printRenewals(SubscriptionPlan[] subscribers) {
        for (SubscriptionPlan s : subscribers) {
            System.out.println(s.getName() + ": " + s.getRenewalDate());
        }
    }

    public static void main(String[] args) {
        SubscriptionPlan[] subscribers = {
            new BasicPlan("Asha", LocalDate.of(2024, 1, 15)),
            new StandardPlan("Ravi", LocalDate.of(2024, 2, 1)),
            new PremiumPlan("Neha", LocalDate.of(2024, 3, 10)),
            new BasicPlan("Kiran", LocalDate.of(2024, 12, 20))
        };
        printRenewals(subscribers);
    }
}