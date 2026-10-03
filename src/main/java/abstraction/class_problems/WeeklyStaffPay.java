package abstraction.class_problems;

import java.util.Locale;

abstract class Staff {
    protected String name;

    public Staff(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double calculatePay();
}

class FullTimeStaff extends Staff {
    private double weeklySalary;

    public FullTimeStaff(String name, double weeklySalary) {
        super(name);
        this.weeklySalary = weeklySalary;
    }

    @Override
    public double calculatePay() {
        return weeklySalary;
    }
}

class HourlyStaff extends Staff {
    private double hours;
    private double rate;

    public HourlyStaff(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    @Override
    public double calculatePay() {
        if (hours <= 40) {
            return hours * rate;
        } else {
            return (40 * rate) + ((hours - 40) * 1.5 * rate);
        }
    }
}

class InternStaff extends Staff {
    private double stipend;

    public InternStaff(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    @Override
    public double calculatePay() {
        return stipend;
    }
}

public class WeeklyStaffPay {

    public static void processPayroll(Staff[] staffList) {
        double totalPayroll = 0.0;
        for (Staff s : staffList) {
            double pay = s.calculatePay();
            System.out.printf(Locale.US, "%s: %.2f%n", s.getName(), pay);
            totalPayroll += pay;
        }
        System.out.printf(Locale.US, "Total Payroll: %.2f%n", totalPayroll);
    }

    public static void main(String[] args) {
        Staff[] staffList = {
            new FullTimeStaff("Asha", 12000),
            new HourlyStaff("Ravi", 45, 200),
            new InternStaff("Neha", 5000)
        };
        processPayroll(staffList);
    }
}