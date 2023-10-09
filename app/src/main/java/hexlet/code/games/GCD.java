package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class GCD {
    private static final int SCORE_TO_WIN = 3;
    private static final int MAX_RANDOM_NUM = 100;
    private static final int MIN_RANDOM_NUM = 1;
    public static void playGCD() {

        String gameRules = "Find the greatest common divisor of given numbers.\n"
                + "You need to give " + SCORE_TO_WIN + " correct answers to win.";

        String[] gameQuestions = new String[SCORE_TO_WIN];
        String[] gameQuestionsAnswers = new String[SCORE_TO_WIN];
        Random random = new Random();

        for (var i = 0; i < SCORE_TO_WIN; i++) {
            var randomFirstNum = random.nextInt(MAX_RANDOM_NUM) + MIN_RANDOM_NUM;
            var randomSecondNum = random.nextInt(MAX_RANDOM_NUM) + MIN_RANDOM_NUM;

            int largerNum;
            int smallerNum;

            if (randomFirstNum < randomSecondNum) {
                largerNum = randomSecondNum;
                smallerNum = randomFirstNum;
            } else {
                largerNum = randomFirstNum;
                smallerNum = randomSecondNum;
            }

            gameQuestions[i] = largerNum + " " + smallerNum;

            String gcdByEuclidString = "";

            while (smallerNum != 0) {
                int tmp = largerNum % smallerNum;
                largerNum = smallerNum;
                smallerNum = tmp;
            }

            gcdByEuclidString += largerNum;

            gameQuestionsAnswers[i] = gcdByEuclidString;
        }

        Engine.playGame(gameRules, gameQuestions, gameQuestionsAnswers);
    }
}
