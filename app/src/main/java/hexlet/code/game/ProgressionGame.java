package hexlet.code.game;

import org.apache.commons.lang3.StringUtils;

import java.util.Random;
import java.util.Scanner;

public class ProgressionGame implements Game {
    static Scanner scanner = new Scanner(System.in);
    static Random ran = new Random();

    private int score;
    private boolean gameOver;

    @Override
    public void start() {
        this.score = 0;
        this.gameOver = false;

        System.out.println("What number is missing in the progression?");
    }

    @Override
    public void nextRound() {
        int start = ran.nextInt(Controller.MAX_NUMBER);
        int step = ran.nextInt(Controller.MAX_NUMBER);
        int amount = 5 + ran.nextInt(5);
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

    @Override
    public boolean isGameOver() {
        return this.gameOver;
    }

    @Override
    public int getScore() {
        return score;
    }
}
