package hexlet.code.games;

import hexlet.code.Engine;

public class Calculator {
    private static final int SCORE_TO_WIN = 3;
    private static final int MAX_RANDOM_NUM = 100;
    private static final int MIN_RANDOM_NUM = 1;
    private static final int CHOICE_PLUS = 0;
    private static final int CHOICE_MINUS = 1;
    private static final int CHOICE_MULTIPLY = 2;

    public static int calculate(int firstNum, int secondNum, int operator) {
        int gameAnswerInt;
        gameAnswerInt = switch (operator) {
            case CHOICE_PLUS -> firstNum + secondNum;
            case CHOICE_MINUS -> firstNum - secondNum;
            case CHOICE_MULTIPLY -> firstNum * secondNum;
            default -> throw new RuntimeException("Logic is not defined for the operator");
        };
        return gameAnswerInt;
    }

    public static void playCalculator() {

        String gameRules = "What is the result of the expression?";

        String[] gameQuestions = new String[SCORE_TO_WIN];
        String[] gameQuestionsAnswers = new String[SCORE_TO_WIN];
        String[] operators = {" + ", " - ", " * "};

        for (var i = 0; i < SCORE_TO_WIN; i++) {
            var randomFirstNum = Utils.createRandomNum(MAX_RANDOM_NUM, MIN_RANDOM_NUM);
            var randomSecondNum = Utils.createRandomNum(MAX_RANDOM_NUM, MIN_RANDOM_NUM);
            var randomOperator = Utils.createRandomNum(operators.length);
            int gameAnswerInt;


            gameAnswerInt = calculate(randomFirstNum, randomSecondNum, randomOperator);
            gameQuestionsAnswers[i] = String.valueOf(gameAnswerInt);
            gameQuestions[i] = randomFirstNum + operators[randomOperator] + randomSecondNum;
        }

        Engine.playGame(gameRules, gameQuestions, gameQuestionsAnswers);
    }
}
