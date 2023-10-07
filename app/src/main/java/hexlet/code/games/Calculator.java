package hexlet.code.games;

public class Calculator {
    public static void playCalculator() {
        final int scoreToWin = 3;
        Engine.setGameRules("What is the result of the expression?\n"
                + "You need to give " + scoreToWin + " correct answers to win.");

        final int maxRandomNum = 100;
        final int operatorCount = 3;
        String[] gameQuestions = new String[scoreToWin];
        String[] gameQuestionsAnswers = new String[scoreToWin];

        for (var i = 0; i < scoreToWin; i++) {
            var randomFirstNum = (int) (Math.random() * maxRandomNum);
            var randomSecondNum = (int) (Math.random() * maxRandomNum);
            var randomOperator = (int) (Math.random() * operatorCount);
            int gameAnswerInt;

            switch (randomOperator) {
                case 1:
                    gameAnswerInt = randomFirstNum + randomSecondNum;
                    gameQuestionsAnswers[i] = String.valueOf(gameAnswerInt);
                    gameQuestions[i] = randomFirstNum + " + " + randomSecondNum;
                    break;
                case 2:
                    gameAnswerInt = randomFirstNum - randomSecondNum;
                    gameQuestionsAnswers[i] = String.valueOf(gameAnswerInt);
                    gameQuestions[i] = randomFirstNum + " - " + randomSecondNum;
                    break;
                default:
                    gameAnswerInt = randomFirstNum * randomSecondNum;
                    gameQuestionsAnswers[i] = String.valueOf(gameAnswerInt);
                    gameQuestions[i] = randomFirstNum + " * " + randomSecondNum;
                    break;
            }
        }
        Engine.setQuestions(gameQuestions);
        Engine.setQuestionsAnswers(gameQuestionsAnswers);

        Engine.playGame();
    }
}
