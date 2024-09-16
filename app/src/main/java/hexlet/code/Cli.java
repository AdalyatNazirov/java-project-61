package hexlet.code;

import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

public class Cli {
    public static void greet() {
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        System.out.print("May I have your name? ");

        String userName = null;
        do {
            userName = scanner.nextLine();
            if (!StringUtils.isBlank(userName)) {
                break;
            }
            System.out.print("Please enter your name: ");
        } while (true);
        System.out.println("Hello, " + userName);
    }
}
