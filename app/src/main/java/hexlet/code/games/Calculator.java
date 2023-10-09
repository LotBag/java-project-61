package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class Calculator {
    private static final int MAX_RANDOM_NUM = 100;
    private static final int MIN_RANDOM_NUM = 1;
    private static final int OPERATOR_COUNT = 3;
    public static int calculate(int randomFirstNum, int randomSecondNum, int randomOperator) {
        return switch (randomOperator) {
            case 1 -> randomFirstNum + randomSecondNum;
            case 2 -> randomFirstNum - randomSecondNum;
            case 3 -> randomFirstNum * randomSecondNum;
            default -> 0;
        };
    }
    public static void playCalculator() {
        final int scoreToWin = 3;
        String gameRules = "What is the result of the expression?\n"
                + "You need to give " + scoreToWin + " correct answers to win.";

        String[] gameQuestions = new String[scoreToWin];
        String[] gameQuestionsAnswers = new String[scoreToWin];
        Random random = new Random();

        for (var i = 0; i < scoreToWin; i++) {
            var randomFirstNum = random.nextInt(MAX_RANDOM_NUM) + MIN_RANDOM_NUM;
            var randomSecondNum = random.nextInt(MAX_RANDOM_NUM) + MIN_RANDOM_NUM;
            var randomOperator = random.nextInt(OPERATOR_COUNT) + MIN_RANDOM_NUM;
            int gameAnswerInt;

            switch (randomOperator) {
                case 1:
                    gameAnswerInt = calculate(randomFirstNum, randomSecondNum, randomOperator);
                    gameQuestionsAnswers[i] = String.valueOf(gameAnswerInt);
                    gameQuestions[i] = randomFirstNum + " + " + randomSecondNum;
                    break;
                case 2:
                    gameAnswerInt = calculate(randomFirstNum, randomSecondNum, randomOperator);
                    gameQuestionsAnswers[i] = String.valueOf(gameAnswerInt);
                    gameQuestions[i] = randomFirstNum + " - " + randomSecondNum;
                    break;
                default:
                    gameAnswerInt = calculate(randomFirstNum, randomSecondNum, randomOperator);
                    gameQuestionsAnswers[i] = String.valueOf(gameAnswerInt);
                    gameQuestions[i] = randomFirstNum + " * " + randomSecondNum;
                    break;
            }
        }

        Engine.playGame(gameRules, gameQuestions, gameQuestionsAnswers);
    }
}
