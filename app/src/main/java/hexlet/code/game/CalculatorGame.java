package hexlet.code.game;

import org.apache.commons.lang3.StringUtils;

import java.util.Random;
import java.util.Scanner;

public class CalculatorGame implements Game {
    private static Scanner scanner = new Scanner(System.in);
    private static Random ran = new Random();
    private static String[] operations = new String[]{"+", "-", "*"};

    private int score;
    private boolean gameOver;

    @Override
    public void start() {
        this.score = 0;
        this.gameOver = false;

        System.out.println("What is the result of the expression?");
    }

    @Override
    public void nextRound() {
        String op = operations[ran.nextInt(operations.length)];
        int op1 = ran.nextInt(Controller.MAX_NUMBER);
        int op2 = ran.nextInt(Controller.MAX_NUMBER);

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
    }

    @Override
    public boolean isGameOver() {
        return this.gameOver;
    }

    private static int correctAnswer(int op1, int op2, String op) {
        switch (op) {
            case "+":
                return op1 + op2;
            case "-":
                return op1 - op2;
            case "*":
                return op1 * op2;
            default:
                throw new IllegalArgumentException("Unknown operator: " + op);
        }
    }

    @Override
    public int getScore() {
        return score;
    }
}
