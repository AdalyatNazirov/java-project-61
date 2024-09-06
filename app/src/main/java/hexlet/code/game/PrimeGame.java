package hexlet.code.game;

import org.apache.commons.lang3.StringUtils;

import java.util.Random;
import java.util.Scanner;

public class PrimeGame implements Game {
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

        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
    }

    /**
     * run next round.
     */
    @Override
    public void nextRound() {
        int number = ran.nextInt(Controller.MAX_NUMBER);

        System.out.println("Question: " + number);

        System.out.print("Your answer: ");
        var answer = scanner.nextLine().trim();
        String correctAnswer = correctAnswer(isPrime(number));
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
    }

    /**
     * checks if the game finished.
     *
     * @return true if game is finished, otherwise false
     */
    @Override
    public boolean isGameOver() {
        return this.gameOver;
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

    private static String correctAnswer(boolean value) {
        return value ? "yes" : "no";
    }

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i <= number / 2; i++) {
            if ((number % i) == 0) {
                return false;
            }
        }
        return true;
    }
}
