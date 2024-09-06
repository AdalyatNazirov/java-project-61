package hexlet.code.game;

import org.apache.commons.lang3.StringUtils;

import java.util.Random;
import java.util.Scanner;

public class GcdGame implements Game {
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

        System.out.println("Find the greatest common divisor of given numbers.");
    }

    /**
     * run next round.
     */
    @Override
    public void nextRound() {
        int op1 = ran.nextInt(Controller.MAX_NUMBER);
        int op2 = ran.nextInt(Controller.MAX_NUMBER);

        System.out.println("Question: " + op1 + " " + op2);

        System.out.print("Your answer: ");
        var answer = scanner.nextLine().trim();
        String correctAnswer = String.valueOf(correctAnswer(op1, op2));
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

    private static int correctAnswer(int op1, int op2) {
        return op1 % op2 == 0 ? op2 : correctAnswer(op2, op1 % op2);
    }
}
