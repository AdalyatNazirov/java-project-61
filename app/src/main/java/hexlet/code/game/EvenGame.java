package hexlet.code.game;

import java.util.Random;
import java.util.Scanner;

public class EvenGame implements Game {
    static Scanner scanner = new Scanner(System.in);
    static Random ran = new Random();

    private int score;
    private boolean gameOver;

    @Override
    public void start() {
        this.score = 0;
        this.gameOver = false;
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
    }

    @Override
    public void nextRound() {
        int number = ran.nextInt(Controller.MAX_NUMBER);
        System.out.println("Question: " + number);

        var answer = scanner.nextLine();
        System.out.println("Your answer: " + answer);

        if (answer.equals(correctAnswer(number))) {
            this.score++;
            System.out.println("Correct!");
        } else {
            System.out.println("'" + answer
                    + "' is wrong answer ;(. Correct answer was '"
                    + correctAnswer(number)
                    + "'.");
            this.gameOver = true;
        }
    }

    @Override
    public boolean isGameOver() {
        return gameOver;
    }

    private static String correctAnswer(int number) {
        return number % 2 == 0 ? "yes" : "no";
    }

    @Override
    public int getScore() {
        return score;
    }
}
