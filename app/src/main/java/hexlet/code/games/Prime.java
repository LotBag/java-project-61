package hexlet.code.games;

import hexlet.code.Engine;

import java.math.BigInteger;
import java.util.Random;

public class Prime {
    private static final int SCORE_TO_WIN = 3;
    private static final int MAX_RANDOM_NUM = 1000;
    private static final int MIN_RANDOM_NUM = 1;
    public static boolean isPrime(int randomNum) {
        BigInteger bigInteger = BigInteger.valueOf(randomNum);
        return bigInteger.isProbablePrime((int) Math.log(randomNum));
    }
    public static void playPrime() {

        String gameRules = "Answer 'yes' if given number is prime. Otherwise answer 'no'.\n"
                + "You need to give " + SCORE_TO_WIN + " correct answers to win.";

        String[] gameQuestions = new String[SCORE_TO_WIN];
        String[] gameQuestionsAnswers = new String[SCORE_TO_WIN];
        Random random = new Random();

        for (var i = 0; i < SCORE_TO_WIN; i++) {
            var randomNum = random.nextInt(MAX_RANDOM_NUM) + MIN_RANDOM_NUM;

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
