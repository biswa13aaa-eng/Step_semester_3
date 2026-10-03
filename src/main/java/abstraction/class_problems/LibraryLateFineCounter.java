package abstraction.class_problems;

import java.util.Locale;

abstract class LibraryItem {
    protected String title;
    protected int daysLate;

    public LibraryItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }

    public String getTitle() {
        return title;
    }

    public abstract double calculateFine();
}

class BookItem extends LibraryItem {
    public BookItem(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        return daysLate * 2.0;
    }
}

class DVDItem extends LibraryItem {
    public DVDItem(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        return Math.min(50.0, daysLate * 5.0);
    }
}

class MagazineItem extends LibraryItem {
    public MagazineItem(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        return daysLate * 1.0;
    }
}

public class LibraryLateFineCounter {

    public static void countFines(LibraryItem[] items) {
        double totalFines = 0.0;
        for (LibraryItem item : items) {
            double fine = item.calculateFine();
            System.out.printf(Locale.US, "%s: %.2f%n", item.getTitle(), fine);
            totalFines += fine;
        }
        System.out.printf(Locale.US, "Total Fines: %.2f%n", totalFines);
    }

    public static void main(String[] args) {
        LibraryItem[] items = {
            new BookItem("Algebra", 4),
            new DVDItem("Inception", 12),
            new MagazineItem("Sports", 3)
        };
        countFines(items);
    }
}