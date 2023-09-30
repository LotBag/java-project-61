package hexlet.code;
import games.code.Calculator;
import games.code.Even;
import games.code.GCD;
import games.code.Progression;

import java.util.Scanner;

import static hexlet.code.Cli.acquaintance;
public class App {
    public static void main(String[] args) {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("Please enter the game number and press Enter");
        System.out.println("1 - Greet\n2 - Even\n3 - Calculator\n4 - GCD\n5 - Progression\n0 - Exit");
        System.out.println("Your choice:");
        Scanner choiceGame = new Scanner(System.in);
        var choice = choiceGame.next();
        switch (choice) {
            case "1":
                acquaintance();
                break;
            case "2":
                Even.playEven();
                break;
            case "3":
                Calculator.playCalculator();
                break;
            case "4":
                GCD.playGCD();
                break;
            case "5":
                Progression.playProgression();
                break;
            case "0":
                break;
            default:
                System.out.println("Did you miss?");
                break;
        }
    }
}
