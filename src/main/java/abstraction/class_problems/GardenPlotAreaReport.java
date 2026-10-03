package abstraction.class_problems;

import java.util.Locale;

abstract class Plot {
    protected String shape;
    protected String owner;

    public Plot(String shape, String owner) {
        this.shape = shape;
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    public String getShape() {
        return shape;
    }

    public abstract double getArea();
}

class CirclePlot extends Plot {
    private double radius;

    public CirclePlot(String owner, double radius) {
        super("CIRCLE", owner);
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}

class RectanglePlot extends Plot {
    private double length;
    private double width;

    public RectanglePlot(String owner, double length, double width) {
        super("RECTANGLE", owner);
        this.length = length;
        this.width = width;
    }

    @Override
    public double getArea() {
        return length * width;
    }
}

class TrianglePlot extends Plot {
    private double base;
    private double height;

    public TrianglePlot(String owner, double base, double height) {
        super("TRIANGLE", owner);
        this.base = base;
        this.height = height;
    }

    @Override
    public double getArea() {
        return 0.5 * base * height;
    }
}

public class GardenPlotAreaReport {

    public static void generateReport(Plot[] plots) {
        double totalArea = 0.0;
        for (Plot p : plots) {
            double area = p.getArea();
            System.out.printf(Locale.US, "%s (%s): %.2f%n", p.getOwner(), p.getShape(), area);
            totalArea += area;
        }
        System.out.printf(Locale.US, "Total Area: %.2f%n", totalArea);
    }

    public static void main(String[] args) {
        Plot[] plots = {
            new CirclePlot("Asha", 5),
            new RectanglePlot("Ravi", 4, 6),
            new TrianglePlot("Neha", 10, 3)
        };
        generateReport(plots);
    }
}