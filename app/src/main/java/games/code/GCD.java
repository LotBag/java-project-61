package games.code;

import hexlet.code.Cli;

import java.util.Scanner;

import static hexlet.code.Cli.userName;

public class GCD {
    public static void playGCD() {
        Cli.acquaintance();
        System.out.println("Find the greatest common divisor of given numbers.\n"
                + "You need to give three correct answers to win.");

        var counterOfCorrectAnswer = 0;
        Scanner gcdAnswer = new Scanner(System.in);

        while (counterOfCorrectAnswer < 3) {
            var randomFirstNum = (int) (Math.random() * 100);
            var randomSecondNum = (int) (Math.random() * 100);

            if (randomFirstNum == 0) {
                randomFirstNum++;
            }

            if (randomSecondNum == 0) {
                randomSecondNum++;
            }

            int largerNum;
            int smallerNum;

            if (randomFirstNum < randomSecondNum) {
                largerNum = randomSecondNum;
                smallerNum = randomFirstNum;
            } else {
                largerNum = randomFirstNum;
                smallerNum = randomSecondNum;
            }

            System.out.println("Question: " + largerNum+ " " + smallerNum);
            System.out.println("You answer: ");

            int gcdByEuclidInt;
            String gcdByEuclidString = "";

            while (smallerNum != 0) {
                int tmp = largerNum % smallerNum;
                largerNum = smallerNum;
                smallerNum = tmp;
            }

            gcdByEuclidInt = largerNum;
            gcdByEuclidString += largerNum;

            String itGCDAnswer = gcdAnswer.next();

            if (itGCDAnswer.equals(gcdByEuclidString)) {
                System.out.println("Correct!");
                counterOfCorrectAnswer++;
            } else {
                System.out.println("Ouch, " + itGCDAnswer + " is wrong answer.\n"
                        + gcdByEuclidInt + " is correct\n"
                        + "Let's try again, " + userName + "!");
                counterOfCorrectAnswer += 10;
            }
        }

        if (counterOfCorrectAnswer < 4) {
            System.out.println("Congratulations, " + Cli.userName + "!");
        }
    }
}
