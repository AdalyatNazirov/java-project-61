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

        printWelcomeMessage();
        String name = askUserName();
        printGreeting(name);

        var score = playGame(game);
        printResultMessage(score, name);
    }

    private static void printWelcomeMessage() {
        System.out.println("Welcome to the Brain Games!");
    }

    private static void printGreeting(String name) {
        System.out.println("Hello, " + name + "!");
    }

    private static String askUserName() {
        System.out.print("May I have your name? ");

        do {
            var userName = SCANNER.nextLine();
            if (!StringUtils.isBlank(userName)) {
                return userName.trim();
            }
            System.out.print("Please enter your name: ");
        } while (true);
    }

    private static int playGame(Game game) {
        System.out.println(game.getRules());

        var score = 0;
        while (true) {
            var round = game.moveNextRound();
            System.out.println("Question: " + round[0]);

            System.out.print("Your answer: ");
            var answer = SCANNER.nextLine().trim();
            var correctAnswer = round[1];
            if (StringUtils.equals(answer, correctAnswer)) {
                score++;
                System.out.println("Correct!");
            } else {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");
                break;
            }
            if (score >= MAX_SCORE) {
                break;
            }
        }

        return score;
    }

    private static void printResultMessage(double score, String name) {
        if (score == MAX_SCORE) {
            System.out.println("Congratulations, " + name + "!");
        } else {
            System.out.println("Let's try again, " + name + "!");
        }
    }
}
