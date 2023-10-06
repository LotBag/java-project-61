package hexlet.code.games;

public class Even {
    public static void playEven() {
        final int scoreToWin = 3;
        Engine.gameRules = "Answer 'yes' if the number is even, otherwise answer 'no'.\n"
                + "You need to give " + scoreToWin + " correct answers to win.";

        final int maxRandomNum = 100;
        Engine.questions = new String[scoreToWin];
        Engine.questionsAnswers = new String[scoreToWin];

        for (var i = 0; i < scoreToWin; i++) {
            var randomNum = (int) (Math.random() * maxRandomNum);

            if (randomNum == 0) {
                randomNum++;
            }

            var isRandomNumEven = (randomNum % 2 == 0);

            if (isRandomNumEven) {
                Engine.questionsAnswers[i] = "yes";
            } else {
                Engine.questionsAnswers[i] = "no";
            }

            Engine.questions[i] = String.valueOf(randomNum);
        }

        Engine.playGame();
    }
}
