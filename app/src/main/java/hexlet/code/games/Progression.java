package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Arrays;
import java.util.Random;

public class Progression {
    private static final int SCORE_TO_WIN = 3;
    private static final int MIN_PROGRESSION_LENGTH = 5;
    private static final int ADDITIONAL_PROGRESSION_LENGTH = 5;
    private static final int MAX_START_PROGRESSION = 100;
    private static final int MIN_START_PROGRESSION = 1;
    private static final int MAX_STEP_PROGRESSION = 50;
    private static final int MIN_STEP_PROGRESSION = 1;
    public static void playProgression() {

        String gameRules = "What number is missing in the progression?\n"
                + "You need to give " + SCORE_TO_WIN + " correct answers to win.";

        var missingPart = -1;
        String[] gameQuestions = new String[SCORE_TO_WIN];
        String[] gameQuestionsAnswers = new String[SCORE_TO_WIN];
        Random random = new Random();

        for (var i = 0; i < SCORE_TO_WIN; i++) {
            int progressionLength = random.nextInt(ADDITIONAL_PROGRESSION_LENGTH) + MIN_PROGRESSION_LENGTH;
            int progressionStart = random.nextInt(MAX_START_PROGRESSION) + MIN_START_PROGRESSION;
            int progressionStep = random.nextInt(MAX_STEP_PROGRESSION) + MIN_STEP_PROGRESSION;
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

        Engine.playGame(gameRules, gameQuestions, gameQuestionsAnswers);
    }
}
