package hexlet.code.game;

import java.util.Random;
import java.util.Scanner;

public class EvenGame implements Game {
    private static Scanner scanner = new Scanner(System.in);
    private static Random ran = new Random();

    private int score;
    private boolean gameOver;

    /**
     * starts the game.
     */
    @Override
    public void start() {
        this.score = 0;
        this.gameOver = false;
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
    }

    /**
     * run next round.
     */
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

    /**
     * checks if the game finished.
     *
     * @return true if game is finished, otherwise false
     */
    @Override
    public boolean isGameOver() {
        return gameOver;
    }

    private static String correctAnswer(int number) {
        return number % 2 == 0 ? "yes" : "no";
    }

    /**
     * returns score of current launch.
     *
     * @return
     */
    @Override
    public int getScore() {
        return score;
    }
}
