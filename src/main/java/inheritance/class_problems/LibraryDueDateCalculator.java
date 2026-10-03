package inheritance.class_problems;

import java.time.LocalDate;

abstract class LibraryItem {
    protected String title;
    protected int borrowDays;

    public LibraryItem(String title, int borrowDays) {
        this.title = title;
        this.borrowDays = borrowDays;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate calculateDueDate(LocalDate fromDate) {
        return fromDate.plusDays(borrowDays);
    }
}

class BookItem extends LibraryItem {
    public BookItem(String title) {
        super(title, 14);
    }
}

class DVDItem extends LibraryItem {
    public DVDItem(String title) {
        super(title, 7);
    }
}

class MagazineItem extends LibraryItem {
    public MagazineItem(String title) {
        super(title, 3);
    }
}

public class LibraryDueDateCalculator {

    public static void printDueDates(LibraryItem[] items, LocalDate currentDate) {
        for (LibraryItem item : items) {
            System.out.println(item.getTitle() + ": " + item.calculateDueDate(currentDate));
        }
    }

    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.of(2023, 10, 26);
        LibraryItem[] items = {
            new BookItem("1984"),
            new DVDItem("The Matrix"),
            new MagazineItem("Forbes Issue 500")
        };
        printDueDates(items, currentDate);
    }
}