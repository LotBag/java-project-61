package games.code;

import hexlet.code.Cli;

import java.util.Scanner;

import static hexlet.code.Cli.getUserName;

public class Calculator {
    public static void playCalculator() {
        final int scoreToWin = 3;
        Cli.acquaintance();
        System.out.println("What is the result of the expression?\n"
                + "You need to give " + scoreToWin + " correct answers to win.");

        int counterOfCorrectAnswer = 0;
        final int loserPoint = scoreToWin + scoreToWin;
        final int maxRandomNum = 100;
        final int operatorCount = 3;
        Scanner calculatorAnswer = new Scanner(System.in);

        while (counterOfCorrectAnswer < scoreToWin) {
            var randomFirstNum = (int) (Math.random() * maxRandomNum);
            var randomSecondNum = (int) (Math.random() * maxRandomNum);
            var randomOperator = (int) (Math.random() * operatorCount);
            int resultInt;
            String resultString = "";


            switch (randomOperator) {
                case 1:
                    resultInt = randomFirstNum + randomSecondNum;
                    resultString += resultInt;
                    System.out.println("Question: " + randomFirstNum + " + " + randomSecondNum);
                    break;
                case 2:
                    resultInt = randomFirstNum - randomSecondNum;
                    resultString += resultInt;
                    System.out.println("Question: " + randomFirstNum + " - " + randomSecondNum);
                    break;
                default:
                    resultInt = randomFirstNum * randomSecondNum;
                    resultString += resultInt;
                    System.out.println("Question: " + randomFirstNum + " * " + randomSecondNum);
                    break;
            }
            System.out.println("Your answer: ");

            var itCalculatorAnswer = calculatorAnswer.next();

            if (itCalculatorAnswer.equals(resultString)) {
                System.out.println("Correct!");
                counterOfCorrectAnswer++;
            } else {
                System.out.println("Ouch, " + itCalculatorAnswer + " is wrong answer.\n"
                        + resultInt + " is correct\n"
                        + "Let's try again, " + getUserName() + "!");
                counterOfCorrectAnswer += loserPoint;
            }
        }

        if (counterOfCorrectAnswer == scoreToWin) {
            System.out.println("Congratulations, " + getUserName() + "!");
        }

    }
}
