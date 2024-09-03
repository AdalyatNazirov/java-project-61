package hexlet.code;

import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

public class Cli {
    public static String fetchUserName() {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.print("May I have your name? ");

        do {
            var userName = myObj.nextLine();
            if (!StringUtils.isBlank(userName)) {
                return userName.trim();
            }
            System.out.print("Please enter your name: ");
        } while (true);
    }
}
