package games.code;

import hexlet.code.Cli;

import java.util.Scanner;

import static hexlet.code.Cli.getUserName;

public class GCD {
    public static void playGCD() {
        int scoreToWin = 3;
        Cli.acquaintance();
        System.out.println("Find the greatest common divisor of given numbers.\n"
                + "You need to give " + scoreToWin + " correct answers to win.");

        int counterOfCorrectAnswer = 0;
        Scanner gcdAnswer = new Scanner(System.in);
        int loserPoint = scoreToWin + scoreToWin;
        int maxRandomNum = 100;

        while (counterOfCorrectAnswer < scoreToWin) {
            var randomFirstNum = (int) (Math.random() * maxRandomNum);
            var randomSecondNum = (int) (Math.random() * maxRandomNum);

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

            System.out.println("Question: " + largerNum + " " + smallerNum);
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
                        + "Let's try again, " + getUserName() + "!");
                counterOfCorrectAnswer += loserPoint;
            }
        }

        if (counterOfCorrectAnswer == scoreToWin) {
            System.out.println("Congratulations, " + getUserName() + "!");
        }
    }
}
