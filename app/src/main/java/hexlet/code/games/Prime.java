package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Prime {
    private static final int SCORE_TO_WIN = 3;
    private static final int MAX_RANDOM_NUM = 1000;
    private static final int MIN_RANDOM_NUM = 1;

    public static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        } else {
            int temp;
            for (int i = 2; i <= num / 2; i++) {
                temp = num % i;
                if (temp == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void playPrime() {

        String gameRules = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

        String[] gameQuestions = new String[SCORE_TO_WIN];
        String[] gameQuestionsAnswers = new String[SCORE_TO_WIN];

        for (var i = 0; i < SCORE_TO_WIN; i++) {
            var randomNum = Utils.createRandomNum(MAX_RANDOM_NUM, MIN_RANDOM_NUM);

            gameQuestions[i] = String.valueOf(randomNum);

            if (isPrime(randomNum)) {
                gameQuestionsAnswers[i] = "yes";
            } else {
                gameQuestionsAnswers[i] = "no";
            }
        }

        Engine.playGame(gameRules, gameQuestions, gameQuestionsAnswers);
    }
}
