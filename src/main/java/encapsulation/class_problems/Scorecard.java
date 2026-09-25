package encapsulation.class_problems;

public class Scorecard {
    private final int totalQuestions;
    private final boolean[] answers;
    private int count;

    public Scorecard(int totalQuestions) {
        this.totalQuestions = totalQuestions;
        this.answers = new boolean[totalQuestions];
        this.count = 0;
    }

    public void recordAnswer(boolean isCorrect) {
        if (count < totalQuestions) {
            answers[count++] = isCorrect;
        }
    }

    public int getScore() {
        int score = 0;
        for (int i = 0; i < count; i++) {
            if (answers[i]) {
                score++;
            }
        }
        return score;
    }

    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);
        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);
        System.out.println("sc.getScore() -> " + sc.getScore());
    }
}