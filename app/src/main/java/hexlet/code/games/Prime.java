package hexlet.code.games;

import java.math.BigInteger;

public class Prime {
    public static void playPrime() {
        final int scoreToWin = 3;
        Engine.gameRules = "Answer 'yes' if given number is prime. Otherwise answer 'no'.\n"
                + "You need to give " + scoreToWin + " correct answers to win.";

        final int maxRandomNum = 1000;
        Engine.questions = new String[scoreToWin];
        Engine.questionsAnswers = new String[scoreToWin];

        for (var i = 0; i < scoreToWin; i++) {
            var randomNum = (int) (Math.random() * maxRandomNum);

            BigInteger bigInteger = BigInteger.valueOf(randomNum);
            boolean probablePrime = bigInteger.isProbablePrime((int) Math.log(randomNum));

            Engine.questions[i] = "Question: " + randomNum;

            if (probablePrime) {
                Engine.questionsAnswers[i] = "yes";
            } else {
                Engine.questionsAnswers[i] = "no";
            }
        }

        Engine.playGame();
    }
}
