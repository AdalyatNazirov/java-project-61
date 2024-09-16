package hexlet.code;

import hexlet.code.game.Controller;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        for (String option : Controller.listOptions()) {
            System.out.println(option);
        }
        System.out.println("0 - Exit");

        int gameIndex = 0;
        do {
            try {
                gameIndex = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException ignored) {
            }
            System.out.println("Please choose the option from the list above.");
        } while (true);
        System.out.println("Your choice: " + gameIndex);
        System.out.println();

        switch (gameIndex) {
            case 0:
                return;
            case 1:
                Cli.greet();
                return;
            default:
                Controller.launch(gameIndex);
        }
    }
}
