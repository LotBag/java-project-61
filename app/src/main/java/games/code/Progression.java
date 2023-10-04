package games.code;

import hexlet.code.Cli;

import java.util.Arrays;
import java.util.Scanner;

import static hexlet.code.Cli.getUserName;

public class Progression {
    public static void playProgression() {
        int scoreToWin = 3;
        Cli.acquaintance();
        System.out.println("What number is missing in the progression?\n"
                + "You need to give " + scoreToWin + " correct answers to win.");

        int counterOfCorrectAnswer = 0;
        int loserPoint = scoreToWin + scoreToWin;
        int minProgressionLength = 5;
        int additionalProgressionLength = 5;
        int maxStartProgression = 100;
        int maxStepProgression = 50;
        Scanner progressionAnswer = new Scanner(System.in);
        var missingPart = -1;

        while (counterOfCorrectAnswer < scoreToWin) {
            int progressionLength = (int) (minProgressionLength + (Math.random() * additionalProgressionLength));
            int progressionStart = (int) (Math.random() * maxStartProgression);
            int progressionStep = (int) (Math.random() * maxStepProgression);
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
                counterOfCorrectAnswer += loserPoint;
            }

        }
        if (counterOfCorrectAnswer == scoreToWin) {
            System.out.println("Congratulations, " + getUserName() + "!");
        }
    }
}
