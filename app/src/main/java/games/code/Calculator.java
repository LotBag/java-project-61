package games.code;

import hexlet.code.Cli;

import java.util.Scanner;

import static hexlet.code.Cli.userName;

public class Calculator {
    public static void playCalculator() {
        Cli.acquaintance();
        System.out.println("Calculate the result and write it down.\n"
                + "You need to give three correct answers to win.");

        var counterOfCorrectAnswer = 0;
        Scanner calculatorAnswer = new Scanner(System.in);

        while (counterOfCorrectAnswer < 3) {
            var randomFirstNum = (int) (Math.random() * 100);
            var randomSecondNum = (int) (Math.random() * 100);
            var randomOperator = (int) (Math.random() * 3);
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
                case 3:
                    resultInt = randomFirstNum * randomSecondNum;
                    resultString += resultInt;
                    System.out.println("Question: " + randomFirstNum + " * " + randomSecondNum);
                    break;
                default:
                    resultInt = randomFirstNum * randomSecondNum;
                    resultString += resultInt;
                    System.out.println("Rare question: " + randomFirstNum + " * " + randomSecondNum);
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
                        + "Let's try again, " + userName + "!");
                counterOfCorrectAnswer += 10;
            }
        }

        if (counterOfCorrectAnswer < 4) {
            System.out.println("Congratulations, " + Cli.userName + "!");
        }

    }
}
