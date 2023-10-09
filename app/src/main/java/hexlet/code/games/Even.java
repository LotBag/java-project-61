package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class Even {
    private static final int SCORE_TO_WIN = 3;
    private static final int MAX_RANDOM_NUM = 100;
    private static final int MIN_RANDOM_NUM = 1;
    public static boolean isEven(int randomNum) {
        return randomNum % 2 == 0;
    }
    public static void playEven() {

        String gameRules = "Answer 'yes' if the number is even, otherwise answer 'no'.\n"
                + "You need to give " + SCORE_TO_WIN + " correct answers to win.";

        String[] gameQuestions = new String[SCORE_TO_WIN];
        String[] gameQuestionsAnswers = new String[SCORE_TO_WIN];
        Random random = new Random();

        for (var i = 0; i < SCORE_TO_WIN; i++) {
            var randomNum = random.nextInt(MAX_RANDOM_NUM) + MIN_RANDOM_NUM;

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
