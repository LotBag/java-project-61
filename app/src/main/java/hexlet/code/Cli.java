package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static String userName;
    public static void acquaintance() {
        Scanner newUser = new Scanner(System.in);

        System.out.println("Hello, what is you name? ");
        userName = newUser.next();
        System.out.println("Hello " + userName + "!");
   }
}
