package hexlet.code.games;

public class GCD {
    public static void playGCD() {
        final int scoreToWin = 3;
        Engine.setGameRules("Find the greatest common divisor of given numbers.\n"
                + "You need to give " + scoreToWin + " correct answers to win.");

        final int maxRandomNum = 100;
        String[] gameQuestions = new String[scoreToWin];
        String[] gameQuestionsAnswers = new String[scoreToWin];

        for (var i = 0; i < scoreToWin; i++) {
            var randomFirstNum = (int) (Math.random() * maxRandomNum);
            var randomSecondNum = (int) (Math.random() * maxRandomNum);

            if (randomFirstNum == 0) {
                randomFirstNum++;
            }

            if (randomSecondNum == 0) {
                randomSecondNum++;
            }

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
        Engine.setQuestions(gameQuestions);
        Engine.setQuestionsAnswers(gameQuestionsAnswers);

        Engine.playGame();
    }
}
