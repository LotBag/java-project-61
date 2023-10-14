package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Even {
    private static final int SCORE_TO_WIN = 3;
    private static final int MAX_RANDOM_NUM = 100;
    private static final int MIN_RANDOM_NUM = 1;

    public static boolean isEven(int num) {
        return num % 2 == 0;
    }

    public static void playEven() {

        String gameRules = "Answer 'yes' if the number is even, otherwise answer 'no'.";

        String[] gameQuestions = new String[SCORE_TO_WIN];
        String[] gameQuestionsAnswers = new String[SCORE_TO_WIN];

        for (var i = 0; i < SCORE_TO_WIN; i++) {
            var randomNum = Utils.createRandomNum(MAX_RANDOM_NUM, MIN_RANDOM_NUM);

            if (isEven(randomNum)) {
                gameQuestionsAnswers[i] = "yes";
            } else {
                gameQuestionsAnswers[i] = "no";
            }

            gameQuestions[i] = String.valueOf(randomNum);
        }

        Engine.playGame(gameRules, gameQuestions, gameQuestionsAnswers);
    }
}
