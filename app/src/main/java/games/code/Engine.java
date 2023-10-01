package games.code;

import hexlet.code.Cli;

import java.util.Scanner;

public class Engine {
    public static void gamesName() {
        Cli.acquaintance();
        System.out.println("Question\n"
                + "You need to give three correct answers to win.");

        var counterOfCorrectAnswer = 0;
        Scanner gameAnswer = new Scanner(System.in);

        while (counterOfCorrectAnswer < 3) {

            //game logic

            System.out.println("Question: " + "some question text");

            var itGameAnswer = gameAnswer.next();

            //check user answer
        }
        if (counterOfCorrectAnswer < 4) {
            System.out.println("Congratulations, " + Cli.userName + "!");
        }
    }
}
