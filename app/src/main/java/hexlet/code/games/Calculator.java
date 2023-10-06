package hexlet.code.games;

public class Calculator {
    public static void playCalculator() {
        final int scoreToWin = 3;
        Engine.gameRules = "What is the result of the expression?\n"
                + "You need to give " + scoreToWin + " correct answers to win.";

        final int maxRandomNum = 100;
        final int operatorCount = 3;
        Engine.questions = new String[scoreToWin];
        Engine.questionsAnswers = new String[scoreToWin];

        for (var i = 0; i < scoreToWin; i++) {
            var randomFirstNum = (int) (Math.random() * maxRandomNum);
            var randomSecondNum = (int) (Math.random() * maxRandomNum);
            var randomOperator = (int) (Math.random() * operatorCount);
            int gameAnswerInt;

            switch (randomOperator) {
                case 1:
                    gameAnswerInt = randomFirstNum + randomSecondNum;
                    Engine.questionsAnswers[i] = String.valueOf(gameAnswerInt);
                    Engine.questions[i] = "Question: " + randomFirstNum + " + " + randomSecondNum;
                    break;
                case 2:
                    gameAnswerInt = randomFirstNum - randomSecondNum;
                    Engine.questionsAnswers[i] = String.valueOf(gameAnswerInt);
                    Engine.questions[i] = "Question: " + randomFirstNum + " - " + randomSecondNum;
                    break;
                default:
                    gameAnswerInt = randomFirstNum * randomSecondNum;
                    Engine.questionsAnswers[i] = String.valueOf(gameAnswerInt);
                    Engine.questions[i] = "Question: " + randomFirstNum + " * " + randomSecondNum;
                    break;
            }
        }

        Engine.playGame();
    }
}
