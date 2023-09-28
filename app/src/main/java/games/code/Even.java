package games.code;

import hexlet.code.Cli;
import java.util.Scanner;

public class Even {
    public static void playEven() {
        Cli.acquaintance();
        System.out.println("Answer 'yes' if the number is even, otherwise anser 'no'.\nYou need to give three correct answers to win");

        var counterOfCorrectAnswer = 0;
        Scanner evenAnswer = new Scanner(System.in);

        while (counterOfCorrectAnswer < 3) {
            var randomNum = (int) (Math.random() * 100);
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
                        System.out.println("Oops, try better next times!");
                        counterOfCorrectAnswer += 10;
                    }
                    break;
                case "no":
                    if (!isRandomNumEven) {
                        System.out.println("Correct!");
                        counterOfCorrectAnswer++;
                    } else {
                        System.out.println("Oops, try better next times!");
                        counterOfCorrectAnswer += 10;
                    }
                    break;
            }
        }
        if (counterOfCorrectAnswer < 4) {
            System.out.println("Congratulations, " + Cli.userName + "!");
        }
    }
}
