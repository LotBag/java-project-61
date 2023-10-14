package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class GCD {
    private static final int SCORE_TO_WIN = 3;
    private static final int MAX_RANDOM_NUM = 100;
    private static final int MIN_RANDOM_NUM = 1;

    public static int findGCD(int firstNum, int secondNum) {
        int largerNum;
        int smallerNum;

        if (firstNum < secondNum) {
            largerNum = secondNum;
            smallerNum = firstNum;
        } else {
            largerNum = firstNum;
            smallerNum = secondNum;
        }
        while (smallerNum != 0) {
            int tmp = largerNum % smallerNum;
            largerNum = smallerNum;
            smallerNum = tmp;
        }
        return largerNum;
    }

    public static void playGCD() {

        String gameRules = "Find the greatest common divisor of given numbers.";

        String[] gameQuestions = new String[SCORE_TO_WIN];
        String[] gameQuestionsAnswers = new String[SCORE_TO_WIN];

        for (var i = 0; i < SCORE_TO_WIN; i++) {
            var randomFirstNum = Utils.createRandomNum(MAX_RANDOM_NUM, MIN_RANDOM_NUM);
            var randomSecondNum = Utils.createRandomNum(MAX_RANDOM_NUM, MIN_RANDOM_NUM);

            gameQuestions[i] = randomFirstNum + " " + randomSecondNum;

            String gcdByEuclidString = "";

            gcdByEuclidString += findGCD(randomFirstNum, randomSecondNum);

            gameQuestionsAnswers[i] = gcdByEuclidString;
        }

        Engine.playGame(gameRules, gameQuestions, gameQuestionsAnswers);
    }
}
