package array.class_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Candidate implements Comparable<Candidate> {

    String name;
    double cgpa;
    int codingScore;

    public Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    public double getCompositeScore() {
        return (this.cgpa * 10) + (this.codingScore * 0.5);
    }

    public static boolean isEligible(double cgpa) {
        return cgpa >= 7.5;
    }

    public static boolean isEligible(double cgpa, int codingScore) {
        return isEligible(cgpa) || (cgpa >= 6.5 && codingScore >= 60);
    }

    @Override
    public int compareTo(Candidate other) {
        return Double.compare(other.getCompositeScore(), this.getCompositeScore());
    }

    public static String shortlistAndRank(Candidate[] candidates) {
        if (candidates == null) {
            return "";
        }

        List<Candidate> eligibleList = new ArrayList<>();
        for (Candidate c : candidates) {
            if (isEligible(c.cgpa, c.codingScore)) {
                eligibleList.add(c);
            }
        }

        Candidate[] shortlisted = eligibleList.toArray(new Candidate[0]);
        Arrays.sort(shortlisted);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < shortlisted.length; i++) {
            Candidate c = shortlisted[i];
            sb.append(i + 1).append(". ").append(c.name)
              .append(" (").append(String.format(java.util.Locale.US, "%.1f", c.getCompositeScore())).append(")");
            if (i < shortlisted.length - 1) {
                sb.append(" | ");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Candidate[] candidates = {
            new Candidate("Aisha", 8.2, 40),
            new Candidate("Rohit", 6.8, 65),
            new Candidate("Meena", 6.0, 90),
            new Candidate("Karan", 7.5, 20)
        };

        String result = shortlistAndRank(candidates);
        System.out.println(result);
    }
}