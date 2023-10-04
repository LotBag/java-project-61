package games.code;

import hexlet.code.Cli;

import java.math.BigInteger;
import java.util.Scanner;

import static hexlet.code.Cli.getUserName;

public class Prime {
    public static void playPrime() {
        var scoreToWin = 3;
        Cli.acquaintance();
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.\n"
                + "You need to give " + scoreToWin + " correct answers to win.");

        var counterOfCorrectAnswer = 0;
        var loserPoint = scoreToWin + scoreToWin;
        var maxRandomNum = 1000;
        Scanner primeAnswer = new Scanner(System.in);

        while (counterOfCorrectAnswer < scoreToWin) {
            var randomNum = (int) (Math.random() * maxRandomNum);

            BigInteger bigInteger = BigInteger.valueOf(randomNum);
            boolean probablePrime = bigInteger.isProbablePrime((int) Math.log(randomNum));

            System.out.println("Question: " + randomNum);
            System.out.println("You answer: ");

            String itPrimeAnswer = primeAnswer.next();

            switch (itPrimeAnswer) {
                case "yes":
                    if (probablePrime) {
                        System.out.println("Correct!");
                        counterOfCorrectAnswer++;
                    } else {
                        System.out.println("Oops, '" + itPrimeAnswer + "' is wrong answer.Correct answer 'no'.\n"
                                + "Let's try again, " + getUserName() + "!");
                        counterOfCorrectAnswer += loserPoint;
                    }
                    break;
                case "no":
                    if (!probablePrime) {
                        System.out.println("Correct!");
                        counterOfCorrectAnswer++;
                    } else {
                        System.out.println("Oops, '" + itPrimeAnswer + "' is wrong answer.Correct answer 'yes'.\n"
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
