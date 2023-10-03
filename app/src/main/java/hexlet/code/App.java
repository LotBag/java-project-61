package hexlet.code;

import java.util.Scanner;

import static games.code.Calculator.playCalculator;
import static games.code.Even.playEven;
import static games.code.GCD.playGCD;
import static games.code.Prime.playPrime;
import static games.code.Progression.playProgression;
import static hexlet.code.Cli.acquaintance;
public class App {
    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter");
        System.out.println("1 - Greet\n2 - Even\n3 - Calculator\n4 - GCD\n5 - Progression\n6 - Prime\n0 - Exit");
        System.out.println("Your choice:");
        Scanner choiceGame = new Scanner(System.in);
        var choice = choiceGame.next();
        switch (choice) {
            case "1":
                acquaintance();
                break;
            case "2":
                playEven();
                break;
            case "3":
                playCalculator();
                break;
            case "4":
                playGCD();
                break;
            case "5":
                playProgression();
                break;
            case "6":
                playPrime();
                break;
            case "0":
                break;
            default:
                System.out.println("Did you miss?");
                break;
        }
    }
}
