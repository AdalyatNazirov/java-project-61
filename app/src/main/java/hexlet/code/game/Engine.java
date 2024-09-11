package hexlet.code.game;

import hexlet.code.Cli;
import org.apache.commons.lang3.StringUtils;

import java.util.Random;
import java.util.Scanner;

public class Engine {
    public static final int MAX_NUMBER = 1000;
    public static final int MAX_SCORE = 3;

    private static Scanner scanner = new Scanner(System.in);

    public static void start(Game game) {
        game.start();

        System.out.println("Welcome to the Brain Games!");
        var name = Cli.fetchUserName();
        System.out.println("Hello, " + name + "!");


        System.out.println("Question: " + op1 + " " + op + " " + op2);

        System.out.print("Your answer: ");
        var answer = scanner.nextLine().trim();
        String correctAnswer = String.valueOf(correctAnswer(op1, op2, op));
        if (StringUtils.equals(answer, correctAnswer)) {
            this.score++;
            System.out.println("Correct!");
        } else {
            System.out.println("'" + answer
                    + "' is wrong answer ;(. Correct answer was '"
                    + correctAnswer
                    + "'.");
            this.gameOver = true;
        }

        while (!game.isGameOver()) {
            game.nextRound();
            if (game.getScore() >= MAX_SCORE) {
                break;
            }
        }

        if (game.getScore() >= MAX_SCORE) {
            System.out.println("Congratulations, " + name + "!");
        } else {
            System.out.println("Let's try again, " + name + "!");
        }
    }
}
