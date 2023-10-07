package hexlet.code.games;

public class Even {
    public static void playEven() {
        final int scoreToWin = 3;
        Engine.setGameRules("Answer 'yes' if the number is even, otherwise answer 'no'.\n"
                + "You need to give " + scoreToWin + " correct answers to win.");

        final int maxRandomNum = 100;
        String[] gameQuestions = new String[scoreToWin];
        String[] gameQuestionsAnswers = new String[scoreToWin];

        for (var i = 0; i < scoreToWin; i++) {
            var randomNum = (int) (Math.random() * maxRandomNum);

            if (randomNum == 0) {
                randomNum++;
            }

            var isRandomNumEven = (randomNum % 2 == 0);

            if (isRandomNumEven) {
                gameQuestionsAnswers[i] = "yes";
            } else {
                gameQuestionsAnswers[i] = "no";
            }

            gameQuestions[i] = String.valueOf(randomNum);
        }
        Engine.setQuestionsAnswers(gameQuestionsAnswers);
        Engine.setQuestions(gameQuestions);

        Engine.playGame();
    }
}
