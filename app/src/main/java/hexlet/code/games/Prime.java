package hexlet.code.games;

import java.math.BigInteger;

public class Prime {
    public static void playPrime() {
        final int scoreToWin = 3;
        Engine.setGameRules("Answer 'yes' if given number is prime. Otherwise answer 'no'.\n"
                + "You need to give " + scoreToWin + " correct answers to win.");

        final int maxRandomNum = 1000;
        String[] gameQuestions = new String[scoreToWin];
        String[] gameQuestionsAnswers = new String[scoreToWin];

        for (var i = 0; i < scoreToWin; i++) {
            var randomNum = (int) (Math.random() * maxRandomNum);

            BigInteger bigInteger = BigInteger.valueOf(randomNum);
            boolean probablePrime = bigInteger.isProbablePrime((int) Math.log(randomNum));

            gameQuestions[i] = String.valueOf(randomNum);

            if (probablePrime) {
                gameQuestionsAnswers[i] = "yes";
            } else {
                gameQuestionsAnswers[i] = "no";
            }
        }
        Engine.setQuestionsAnswers(gameQuestionsAnswers);
        Engine.setQuestions(gameQuestions);

        Engine.playGame();
    }
}
