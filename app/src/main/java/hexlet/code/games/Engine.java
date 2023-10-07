package hexlet.code.games;

import java.util.Scanner;

public class Engine {
    private static String gameRules;
    private static String[] questions;
    private static String[] questionsAnswers;
    public static void setGameRules(String thisRules) {
        gameRules = thisRules;
    }
    public static void setQuestions(String[] gameQuestions) {
        questions = gameQuestions;
    }
    public static void setQuestionsAnswers(String[] gameQuestionsAnswers) {
        questionsAnswers = gameQuestionsAnswers;
    }
    public static void playGame() {
        Scanner answer = new Scanner(System.in);
        Scanner newUser = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name? ");
        String userName = newUser.next();
        System.out.println("Hello, " + userName + "!");

        System.out.println(gameRules);

        for (var i = 0; i < questions.length; i++) {
            System.out.println("Question: " + questions[i]);
            System.out.println("Your answer: ");
            var itAnswer = answer.next();

            if (itAnswer.equalsIgnoreCase(questionsAnswers[i])) {
                System.out.println("Correct!");
            } else {
                System.out.println("Ouch, " + itAnswer + " is wrong answer.\n"
                        + questionsAnswers[i] + " is correct\n"
                        + "Let's try again, " + userName + "!");
                return;
            }
        }
        System.out.println("Congratulations, " + userName + "!");
    }
}
