package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Arrays;

public class Progression {
    private static final int SCORE_TO_WIN = 3;
    private static final int MIN_PROGRESSION_LENGTH = 5;
    private static final int ADDITIONAL_PROGRESSION_LENGTH = 5;
    private static final int MAX_START_PROGRESSION = 100;
    private static final int MIN_START_PROGRESSION = 1;
    private static final int MAX_STEP_PROGRESSION = 50;
    private static final int MIN_STEP_PROGRESSION = 1;

    public static int[] createProgression(int progressionStart, int progressionLength, int progressionStep) {
        int[] progressionElements = new int[progressionLength];

        progressionElements[0] = progressionStart;

        for (var i = 1; i < progressionElements.length; i++) {
            progressionElements[i] = progressionElements[i - 1] + progressionStep;
        }
        return progressionElements;
    }

    public static void playProgression() {

        String gameRules = "What number is missing in the progression?";

        var missingPart = -1;
        String[] gameQuestions = new String[SCORE_TO_WIN];
        String[] gameQuestionsAnswers = new String[SCORE_TO_WIN];

        for (var i = 0; i < SCORE_TO_WIN; i++) {
            int progressionLength = Utils.createRandomNum(ADDITIONAL_PROGRESSION_LENGTH, MIN_PROGRESSION_LENGTH);
            int progressionStart = Utils.createRandomNum(MAX_START_PROGRESSION, MIN_START_PROGRESSION);
            int progressionStep = Utils.createRandomNum(MAX_STEP_PROGRESSION, MIN_STEP_PROGRESSION);
            int missingElement = (int) (progressionLength - Math.random() * progressionLength - 1);

            int[] progression = createProgression(progressionStart, progressionLength, progressionStep);

            var answerInt = progression[missingElement];
            var answerString = "" + answerInt;
            progression[missingElement] = missingPart;
            var progressionToString = Arrays.toString(progression);

            var replaceMissingElements = progressionToString.replace("-1", "..");
            var replaceComma = replaceMissingElements.replace(",", "");
            var replaceQuotationMarks = replaceComma.substring(1, replaceComma.length() - 1);

            gameQuestions[i] = replaceQuotationMarks;
            gameQuestionsAnswers[i] = answerString;

        }

        Engine.playGame(gameRules, gameQuestions, gameQuestionsAnswers);
    }
}
