package hexlet.code.games;

import java.util.Arrays;

public class Progression {
    public static void playProgression() {
        final int scoreToWin = 3;
        Engine.setGameRules("What number is missing in the progression?\n"
                + "You need to give " + scoreToWin + " correct answers to win.");

        final int minProgressionLength = 5;
        final int additionalProgressionLength = 5;
        final int maxStartProgression = 100;
        final int maxStepProgression = 50;
        var missingPart = -1;
        String[] gameQuestions = new String[scoreToWin];
        String[] gameQuestionsAnswers = new String[scoreToWin];

        for (var i = 0; i < scoreToWin; i++) {
            int progressionLength = (int) (minProgressionLength + (Math.random() * additionalProgressionLength));
            int progressionStart = (int) (Math.random() * maxStartProgression);
            int progressionStep = (int) (Math.random() * maxStepProgression);
            int missingElement = (int) (progressionLength - Math.random() * progressionLength - 1);
            int[] progressionElements = new int[progressionLength];

            progressionElements[0] = progressionStart;

            for (var i2 = 1; i2 < progressionElements.length; i2++) {
                progressionElements[i2] = progressionElements[i2 - 1] + progressionStep;
            }

            var answerInt = progressionElements[missingElement];
            var answerString = "" + answerInt;
            progressionElements[missingElement] = missingPart;
            var progressionToString = Arrays.toString(progressionElements);

            var replaceMissingElements = progressionToString.replace("-1", "..");
            var replaceComma = replaceMissingElements.replace(",", "");
            var replaceQuotationMarks = replaceComma.substring(1, replaceComma.length() - 1);

            gameQuestions[i] = replaceQuotationMarks;
            gameQuestionsAnswers[i] = answerString;

        }
        Engine.setQuestions(gameQuestions);
        Engine.setQuestionsAnswers(gameQuestionsAnswers);

        Engine.playGame();
    }
}
