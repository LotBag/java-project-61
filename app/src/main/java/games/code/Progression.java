package games.code;

import hexlet.code.Cli;

import java.util.Arrays;
import java.util.Scanner;

import static hexlet.code.Cli.getUserName;

public class Progression {
    public static void playProgression() {
        Cli.acquaintance();
        System.out.println("What number is missing in the progression?\n"
                + "You need to give three correct answers to win.");

        var counterOfCorrectAnswer = 0;
        Scanner progressionAnswer = new Scanner(System.in);
        var missingPart = -1;

        while (counterOfCorrectAnswer < 3) {
            int progressionLength = (int) (5 + (Math.random() * 5));
            int progressionStart = (int) (Math.random() * 100);
            int progressionStep = (int) (Math.random() * 50);
            int missingElement = (int) (progressionLength - Math.random() * progressionLength - 1);
            int[] progressionElements = new int[progressionLength];

            progressionElements[0] = progressionStart;

            for (var i = 1; i < progressionElements.length; i++) {
                progressionElements[i] = progressionElements[i - 1] + progressionStep;
            }

            var answerInt = progressionElements[missingElement];
            var answerString = "" + answerInt;
            progressionElements[missingElement] = missingPart;
            var progressionToString = Arrays.toString(progressionElements);

            var replaceMissingElements = progressionToString.replace("-1", "..");
            var replaceComma = replaceMissingElements.replace(",", "");
            var replaceQuotationMarks = replaceComma.substring(1, replaceComma.length() - 1);


            System.out.println("Question: " + replaceQuotationMarks);

            var itProgressionAnswer = progressionAnswer.next();

            if (itProgressionAnswer.equals(answerString)) {
                System.out.println("Correct!");
                counterOfCorrectAnswer++;
            } else {
                System.out.println("Ouch, " + itProgressionAnswer + " is wrong answer.\n"
                        + answerString + " is correct"
                        + "Let's try again, " + getUserName() + "!");
                counterOfCorrectAnswer += 10;
            }

        }
        if (counterOfCorrectAnswer < 4) {
            System.out.println("Congratulations, " + getUserName() + "!");
        }
    }
}
