package hexlet.code;

import java.util.Scanner;

import static hexlet.code.games.Calculator.playCalculator;
import static hexlet.code.games.Even.playEven;
import static hexlet.code.games.GCD.playGCD;
import static hexlet.code.games.Prime.playPrime;
import static hexlet.code.games.Progression.playProgression;
import static hexlet.code.Cli.greetings;

public class App {
    public static void main(String[] args) {
        final String choiceGreetings = "1";
        final String choiceEven = "2";
        final String choiceCalculator = "3";
        final String choiceGCD = "4";
        final String choiceProgression = "5";
        final String choicePrime = "6";
        final String exit = "0";
        System.out.println("Please enter the game number and press Enter");
        System.out.println("1 - Greet\n2 - Even\n3 - Calculator\n4 - GCD\n5 - Progression\n6 - Prime\n0 - Exit");
        System.out.println("Your choice:");
        Scanner choiceGame = new Scanner(System.in);
        var choice = choiceGame.next();
        switch (choice) {
            case choiceGreetings:
                greetings();
                break;
            case choiceEven:
                playEven();
                break;
            case choiceCalculator:
                playCalculator();
                break;
            case choiceGCD:
                playGCD();
                break;
            case choiceProgression:
                playProgression();
                break;
            case choicePrime:
                playPrime();
                break;
            case exit:
                break;
            default:
                System.out.println("Did you miss?");
                break;
        }
    }
}
