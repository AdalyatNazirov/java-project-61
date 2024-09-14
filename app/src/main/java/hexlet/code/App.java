package hexlet.code;

import hexlet.code.game.Controller;

import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the game number and press Enter.");
        for (String option : Controller.listOptions()) {
            System.out.println(option);
        }

        int gameIndex = 0;
        do {
            try {
                gameIndex = Integer.parseInt(scanner.nextLine());
                if (gameIndex == 0
                        || Arrays.binarySearch(Controller.listGames(), gameIndex) >= 0) {
                    break;
                }
            } catch (NumberFormatException ignored) {
            }
            System.out.println("Please choose the option from the list above.");
        } while (true);
        System.out.println("Your choice: " + gameIndex);
        System.out.println();

        Controller.launch(gameIndex);
    }
}
