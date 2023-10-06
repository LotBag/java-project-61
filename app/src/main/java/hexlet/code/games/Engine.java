package hexlet.code.games;

import hexlet.code.Cli;

import java.util.Scanner;

import static hexlet.code.Cli.getUserName;

public class Engine {
    public static String gameRules;
    public static String[] questions;
    public static String[] questionsAnswers;
    public static void playGame() {
        Scanner answer = new Scanner(System.in);
        Cli.greetings();

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
                        + "Let's try again, " + getUserName() + "!");
                return;
            }
        }
        System.out.println("Congratulations, " + getUserName() + "!");
    }
}
