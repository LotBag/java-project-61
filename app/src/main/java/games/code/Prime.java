package games.code;

import hexlet.code.Cli;

import java.math.BigInteger;
import java.util.Scanner;

public class Prime {
    public static void playPrime() {
        Cli.acquaintance();
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.\n"
                + "You need to give three correct answers to win.");

        var counterOfCorrectAnswer = 0;
        Scanner primeAnswer = new Scanner(System.in);

        while (counterOfCorrectAnswer < 3) {
            var randomNum = (int) (Math.random() * 1000);

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
                                + "Try better next times!");
                        counterOfCorrectAnswer += 10;
                    }
                    break;
                case "no":
                    if (!probablePrime) {
                        System.out.println("Correct!");
                        counterOfCorrectAnswer++;
                    } else {
                        System.out.println("Oops, '" + itPrimeAnswer + "' is wrong answer.Correct answer 'yes'.\n"
                                + "Try better next times!");
                        counterOfCorrectAnswer += 10;
                    }
                    break;
                default:
                    System.out.println("Write only 'yes' or 'no' next time!");
                    counterOfCorrectAnswer += 10;
            }
        }

        if (counterOfCorrectAnswer < 4) {
            System.out.println("Congratulations, " + Cli.userName + "!");
        }
    }
}
