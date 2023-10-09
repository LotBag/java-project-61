package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static void playGame(String gameRules, String[] questions, String[] questionsAnswers) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name? ");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");

        System.out.println(gameRules);

        for (var i = 0; i < questions.length; i++) {
            System.out.println("Question: " + questions[i]);
            System.out.println("Your answer: ");
            var itAnswer = scanner.next();

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
        scanner.close();
    }
}
