package hexlet.code.game;

import org.apache.commons.lang3.StringUtils;

import java.util.Random;
import java.util.Scanner;

public class ProgressionGame implements Game {
    private static Scanner scanner = new Scanner(System.in);
    private static Random ran = new Random();
    private static final int MIN_PROGRESSION_LENGTH = 5;
    private static final int MAX_PROGRESSION_LENGTH = 10;


    private int score;
    private boolean gameOver;

    /**
     * starts the game.
     */
    @Override
    public void start() {
        this.score = 0;
        this.gameOver = false;

        System.out.println("What number is missing in the progression?");
    }

    /**
     * run next round.
     */
    @Override
    public void nextRound() {
        int start = ran.nextInt(Controller.MAX_NUMBER);
        int step = ran.nextInt(Controller.MAX_NUMBER);
        int amount = MIN_PROGRESSION_LENGTH + ran.nextInt(MAX_PROGRESSION_LENGTH - MIN_PROGRESSION_LENGTH);
        int hiddenItemIndex = ran.nextInt(amount);
        int[] progression = new int[amount];
        for (int i = 0; i < amount; i++) {
            progression[i] = start + i * step;
        }

        System.out.println("Question: " + displayHiddenProgression(progression, hiddenItemIndex));

        System.out.print("Your answer: ");
        var answer = scanner.nextLine().trim();
        String correctAnswer = String.valueOf(progression[hiddenItemIndex]);
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

    private String displayHiddenProgression(int[] progression, int hiddenItemIndex) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < progression.length; i++) {
            if (i != hiddenItemIndex) {
                sb.append(progression[i]);
            } else {
                sb.append("..");
            }
            sb.append(" ");
        }
        return sb.delete(sb.length() - 1, sb.length()).toString();
    }

    /**
     * checks if the game finished.
     * @return
     */
    @Override
    public boolean isGameOver() {
        return this.gameOver;
    }

    /**
     * returns score of current launch.
     * @return
     */
    @Override
    public int getScore() {
        return score;
    }
}
