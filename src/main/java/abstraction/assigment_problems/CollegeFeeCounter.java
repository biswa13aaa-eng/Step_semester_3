package abstraction.assigment_problems;

import java.util.Locale;

interface BusUser {
    double BUS_FEE = 12000.0;
}

abstract class Student {
    protected String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double getTuition();

    public double calculateTotalFee() {
        double fee = getTuition();
        if (this instanceof BusUser) {
            fee += BusUser.BUS_FEE;
        }
        return fee;
    }
}

class DayScholarStudent extends Student implements BusUser {
    public DayScholarStudent(String name) {
        super(name);
    }

    @Override
    public double getTuition() {
        return 40000.0;
    }
}

class HostellerStudent extends Student {
    public HostellerStudent(String name) {
        super(name);
    }

    @Override
    public double getTuition() {
        return 40000.0 + 60000.0;
    }
}

class ScholarshipStudent extends Student implements BusUser {
    public ScholarshipStudent(String name) {
        super(name);
    }

    @Override
    public double getTuition() {
        return 20000.0;
    }
}

public class CollegeFeeCounter {

    public static void processStudents(Student[] students) {
        double totalCollected = 0.0;
        for (Student s : students) {
            double fee = s.calculateTotalFee();
            System.out.printf(Locale.US, "%s: %.2f%n", s.getName(), fee);
            totalCollected += fee;
        }
        System.out.printf(Locale.US, "Total Collected: %.2f%n", totalCollected);
    }

    public static void main(String[] args) {
        Student[] students = {
            new DayScholarStudent("Asha"),
            new HostellerStudent("Ravi"),
            new ScholarshipStudent("Neha")
        };
        processStudents(students);
    }
}