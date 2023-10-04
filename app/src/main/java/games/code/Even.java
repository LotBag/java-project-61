package games.code;

import hexlet.code.Cli;
import java.util.Scanner;

import static hexlet.code.Cli.getUserName;

public class Even {
    public static void playEven() {
        final int scoreToWin = 3;
        Cli.acquaintance();
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.\n"
                + "You need to give " + scoreToWin + " correct answers to win.");

        int counterOfCorrectAnswer = 0;
        final int maxRandomNum = 100;
        final int loserPoint = scoreToWin + scoreToWin;
        Scanner evenAnswer = new Scanner(System.in);

        while (counterOfCorrectAnswer < scoreToWin) {
            var randomNum = (int) (Math.random() * maxRandomNum);

            if (randomNum == 0) {
                randomNum++;
            }

            var isRandomNumEven = (randomNum % 2 == 0);


            System.out.println("Question: " + randomNum);
            System.out.println("You answer: ");

            String itEvenAnswer = evenAnswer.next();

            switch (itEvenAnswer) {
                case "yes":
                    if (isRandomNumEven) {
                        System.out.println("Correct!");
                        counterOfCorrectAnswer++;
                    } else {
                        System.out.println("Oops, '" + itEvenAnswer + "' is wrong answer.Correct answer 'no'.\n"
                                + "Let's try again, " + getUserName() + "!");
                        counterOfCorrectAnswer += loserPoint;
                    }
                    break;
                case "no":
                    if (!isRandomNumEven) {
                        System.out.println("Correct!");
                        counterOfCorrectAnswer++;
                    } else {
                        System.out.println("Oops, '" + itEvenAnswer + "' is wrong answer.Correct answer 'yes'.\n"
                                + "Let's try again, " + getUserName() + "!");
                        counterOfCorrectAnswer += loserPoint;
                    }
                    break;
                default:
                    System.out.println("Write only 'yes' or 'no' next time!"
                            + "Let's try again, " + getUserName() + "!");
                    counterOfCorrectAnswer += loserPoint;
            }
        }

        if (counterOfCorrectAnswer == scoreToWin) {
            System.out.println("Congratulations, " + getUserName() + "!");
        }
    }
}
