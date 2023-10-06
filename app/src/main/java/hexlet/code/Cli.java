package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static String userName;
    public static void greetings() {
        Scanner newUser = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name? ");
        userName = newUser.next();
        System.out.println("Hello, " + userName + "!");
    }

    public static String getUserName() {
        return userName;
    }
}
