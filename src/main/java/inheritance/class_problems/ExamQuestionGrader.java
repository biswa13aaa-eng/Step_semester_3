package inheritance.class_problems;

import java.util.Locale;

abstract class Question {
    protected String type;
    protected String questionText;
    protected String correctAnswer;
    protected int points;

    public Question(String type, String questionText, String correctAnswer, int points) {
        this.type = type;
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.points = points;
    }

    public String getType() {
        return type;
    }

    public abstract double grade(String studentAnswer);
}

class MCQQuestion extends Question {
    public MCQQuestion(String questionText, String correctAnswer, int points) {
        super("MCQ", questionText, correctAnswer, points);
    }

    @Override
    public double grade(String studentAnswer) {
        return correctAnswer.equals(studentAnswer) ? points : 0.0;
    }
}

class TFQuestion extends Question {
    public TFQuestion(String questionText, String correctAnswer, int points) {
        super("TF", questionText, correctAnswer, points);
    }

    @Override
    public double grade(String studentAnswer) {
        return correctAnswer.equalsIgnoreCase(studentAnswer) ? points : 0.0;
    }
}

class EssayQuestion extends Question {
    public EssayQuestion(String questionText, String correctAnswer, int points) {
        super("ESSAY", questionText, correctAnswer, points);
    }

    @Override
    public double grade(String studentAnswer) {
        if (studentAnswer == null) {
            return 0.0;
        }
        String[] keywords = correctAnswer.split(",");
        int matchCount = 0;
        String lowerAnswer = studentAnswer.toLowerCase();
        for (String kw : keywords) {
            String trimmed = kw.trim().toLowerCase();
            if (!trimmed.isEmpty() && lowerAnswer.contains(trimmed)) {
                matchCount++;
            }
        }
        if (matchCount >= 2) {
            return points * 0.75;
        } else if (matchCount == 1) {
            return points * 0.50;
        } else {
            return 0.0;
        }
    }
}

public class ExamQuestionGrader {

    public static void gradeQuestions(Question[] questions, String[] studentAnswers) {
        double total = 0.0;
        for (int i = 0; i < questions.length; i++) {
            double score = questions[i].grade(studentAnswers[i]);
            System.out.printf(Locale.US, "%s: %.2f%n", questions[i].getType(), score);
            total += score;
        }
        System.out.printf(Locale.US, "Total Score: %.2f%n", total);
    }

    public static void main(String[] args) {
        Question[] questions = {
            new MCQQuestion("What is the capital of France?", "Paris", 10),
            new TFQuestion("The Earth is flat?", "False", 5),
            new EssayQuestion("Name two primary OOP principles.", "Inheritance, Polymorphism, Encapsulation", 20),
            new EssayQuestion("Describe abstraction and composition.", "Abstraction, Composition", 15)
        };
        String[] answers = {
            "Paris",
            "True",
            "Polymorphism is one.",
            "I talked about abstraction."
        };
        gradeQuestions(questions, answers);
    }
}