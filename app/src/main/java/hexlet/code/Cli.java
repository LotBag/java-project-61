package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static void acquaintance() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello, what is you name? ");
        String userName = scanner.next();
        System.out.println("Hello " + userName + "!");
    }
}
