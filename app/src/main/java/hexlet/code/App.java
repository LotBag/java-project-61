package hexlet.code;

import hexlet.code.games.Calculator;
import hexlet.code.games.Even;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;
import hexlet.code.games.GCD;

import java.util.Scanner;
public class App {
    private static final String CHOICE_GREETINGS = "1";
    private static final String CHOICE_EVEN = "2";
    private static final String CHOICE_CALCULATOR = "3";
    private static final String CHOICE_GCD = "4";
    private static final String CHOICE_PROGRESSION = "5";
    private static final String CHOICE_PRIME = "6";
    private static final String EXIT = "0";
    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter");
        System.out.println("1 - Greet\n2 - Even\n3 - Calculator\n4 - GCD\n5 - Progression\n6 - Prime\n0 - Exit");
        System.out.println("Your choice:");
        Scanner choiceGame = new Scanner(System.in);
        var choice = choiceGame.next();
        choiceGame.close();
        switch (choice) {
            case CHOICE_GREETINGS:
                Cli.greetings();
                break;
            case CHOICE_EVEN:
                Even.playEven();
                break;
            case CHOICE_CALCULATOR:
                Calculator.playCalculator();
                break;
            case CHOICE_GCD:
                GCD.playGCD();
                break;
            case CHOICE_PROGRESSION:
                Progression.playProgression();
                break;
            case CHOICE_PRIME:
                Prime.playPrime();
                break;
            case EXIT:
                break;
            default:
                System.out.println("Did you miss?");
                break;
        }
    }
}
