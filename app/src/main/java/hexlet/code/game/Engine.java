package hexlet.code.game;

import hexlet.code.Cli;
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
        var name = Cli.fetchUserName();
        System.out.println("Hello, " + name + "!");
        System.out.println(game.rules());
        var score = 0;

        if (!game.canPlay()) {
            return;
        }

        while (true) {
            System.out.println("Question: " + game.nextQuestion());

            System.out.print("Your answer: ");
            var answer = SCANNER.nextLine().trim();
            var correctAnswer = game.getCorrectAnswer();
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

        if (score == MAX_SCORE) {
            System.out.println("Congratulations, " + name + "!");
        } else {
            System.out.println("Let's try again, " + name + "!");
        }
    }
}
