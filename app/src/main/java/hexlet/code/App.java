package hexlet.code;
import games.code.Even;

import java.util.Scanner;

import static hexlet.code.Cli.acquaintance;
public class App {
    public static void main(String[] args) {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("Please enter the game number and press Enter");
        System.out.println("1 - Greet\n2 - Even\n0 - Exit");
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
        }
    }
}
