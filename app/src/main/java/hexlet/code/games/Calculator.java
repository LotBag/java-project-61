package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class Calculator {
    private static final int SCORE_TO_WIN = 3;
    private static final int MAX_RANDOM_NUM = 100;
    private static final int MIN_RANDOM_NUM = 1;
    private static final int OPERATOR_COUNT = 3;
    private static final int CHOICE_PLUS = 1;
    private static final int CHOICE_MINUS = 2;
    private static final int CHOICE_MULTIPLY = 3;
    public static int calculate(int randomFirstNum, int randomSecondNum, int randomOperator) {
        return switch (randomOperator) {
            case CHOICE_PLUS -> randomFirstNum + randomSecondNum;
            case CHOICE_MINUS -> randomFirstNum - randomSecondNum;
            case CHOICE_MULTIPLY -> randomFirstNum * randomSecondNum;
            default -> 0;
        };
    }
    public static void playCalculator() {

        String gameRules = "What is the result of the expression?\n"
                + "You need to give " + SCORE_TO_WIN + " correct answers to win.";

        String[] gameQuestions = new String[SCORE_TO_WIN];
        String[] gameQuestionsAnswers = new String[SCORE_TO_WIN];
        Random random = new Random();

        for (var i = 0; i < SCORE_TO_WIN; i++) {
            var randomFirstNum = random.nextInt(MAX_RANDOM_NUM) + MIN_RANDOM_NUM;
            var randomSecondNum = random.nextInt(MAX_RANDOM_NUM) + MIN_RANDOM_NUM;
            var randomOperator = random.nextInt(OPERATOR_COUNT) + MIN_RANDOM_NUM;
            int gameAnswerInt;

            switch (randomOperator) {
                case CHOICE_PLUS:
                    gameAnswerInt = calculate(randomFirstNum, randomSecondNum, randomOperator);
                    gameQuestionsAnswers[i] = String.valueOf(gameAnswerInt);
                    gameQuestions[i] = randomFirstNum + " + " + randomSecondNum;
                    break;
                case CHOICE_MINUS:
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
