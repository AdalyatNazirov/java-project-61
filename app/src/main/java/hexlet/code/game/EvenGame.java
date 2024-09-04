package hexlet.code.game;

import java.util.Random;
import java.util.Scanner;

public class EvenGame implements Game {
    static Scanner scanner = new Scanner(System.in);
    static Random ran = new Random();
    static final int MAX_NUMBER = 1000;
    static final int WIN_RATE = 3;

    private int score;
    private boolean gameOver;
    private String playerName;

    @Override
    public void start(String name) {
        this.score = 0;
        this.gameOver = false;
        this.playerName = name;
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
    }

    @Override
    public void nextRound() {
        int number = ran.nextInt(MAX_NUMBER);
        System.out.println("Question: " + number);

        var answer = scanner.nextLine();
        System.out.println("Your answer: " + answer);

        if (answer.equals(correctAnswer(number))) {
            this.score++;
            System.out.println("Correct!");
            if (this.score == WIN_RATE) {
                System.out.println("Congratulations, " + this.playerName + "!");
            }
        } else {
            System.out.println("'" + answer
                    + "' is wrong answer ;(. Correct answer was '"
                    + correctAnswer(number)
                    + "'.");
            System.out.println("Let's try again, " + this.playerName + "!");
            this.gameOver = true;
        }
    }

    @Override
    public boolean isGameOver() {
        return gameOver || this.score >= WIN_RATE;
    }

    private static String correctAnswer(int number) {
        return number % 2 == 0 ? "yes" : "no";
    }
}
