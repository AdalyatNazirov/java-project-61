package hexlet.code.game;

import org.apache.commons.lang3.StringUtils;

import java.util.Random;
import java.util.Scanner;

public class Engine {
    private static final Scanner SCANNER = new Scanner(System.in);
    public static final Random RANDOM = new Random();
    public static final int MAX_NUMBER = 1000;
    public static final int MAX_SCORE = 3;


    public static void start(Game game) {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");

        String userName;
        do {
            userName = SCANNER.nextLine();
            if (!StringUtils.isBlank(userName)) {
                break;
            }
            System.out.print("Please enter your name: ");
        } while (true);
        System.out.println("Hello, " + userName + "!");

        System.out.println(game.getRules());

        var score = 0;
        while (true) {
            var round = game.moveToNextRound();
            System.out.println("Question: " + round[0]);

            System.out.print("Your answer: ");
            var answer = SCANNER.nextLine().trim();
            var correctAnswer = round[1];
            if (StringUtils.equals(answer, correctAnswer)) {
                score++;
                System.out.println("Correct!");
            } else {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");

                System.out.println("Let's try again, " + userName + "!");
                return;
            }
            if (score >= MAX_SCORE) {
                System.out.println("Congratulations, " + userName + "!");
                return;
            }
        }
    }
}
