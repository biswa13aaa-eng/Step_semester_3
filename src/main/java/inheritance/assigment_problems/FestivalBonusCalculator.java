package inheritance.assigment_problems;

import java.util.Locale;

abstract class Employee {
    protected String name;
    protected double monthlySalary;

    public Employee(String name, double monthlySalary) {
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    public String getName() {
        return name;
    }

    public abstract double calculateBonus();
}

class FullTimeEmployee extends Employee {
    public FullTimeEmployee(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    @Override
    public double calculateBonus() {
        return monthlySalary * 0.10;
    }
}

class PartTimeEmployee extends Employee {
    public PartTimeEmployee(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    @Override
    public double calculateBonus() {
        return monthlySalary * 0.05;
    }
}

class InternEmployee extends Employee {
    public InternEmployee(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    @Override
    public double calculateBonus() {
        return 2000.0;
    }
}

public class FestivalBonusCalculator {

    public static void processEmployees(Employee[] employees) {
        double total = 0.0;
        for (Employee e : employees) {
            double bonus = e.calculateBonus();
            System.out.printf(Locale.US, "%s: %.2f%n", e.getName(), bonus);
            total += bonus;
        }
        System.out.printf(Locale.US, "Total Bonus: %.2f%n", total);
    }

    public static void main(String[] args) {
        Employee[] employees = {
            new FullTimeEmployee("Asha", 50000),
            new PartTimeEmployee("Ravi", 30000),
            new InternEmployee("Neha", 15000)
        };
        processEmployees(employees);
    }
}