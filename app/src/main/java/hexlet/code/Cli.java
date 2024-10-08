package hexlet.code;

import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

public class Cli {
    public static void greet() {
        System.out.println("Welcome to the Brain Games!");

        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        System.out.println("May I have your name? ");

        String userName = null;
        do {
            userName = scanner.nextLine();
            if (!StringUtils.isBlank(userName)) {
                break;
            }
            System.out.println("Please enter your name: ");
        } while (true);
        System.out.println("Hello, " + userName + "!");
    }
}
