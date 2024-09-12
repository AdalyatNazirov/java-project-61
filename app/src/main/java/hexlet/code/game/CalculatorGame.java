package hexlet.code.game;

import java.util.Random;

public class CalculatorGame implements Game {

    private static final String[] operations = new String[]{"+", "-", "*"};

    private final Random randomizer;
    private String correctAnswer;

    CalculatorGame(Random randomizer) {
        this.randomizer = randomizer;
    }

    /**
     * starts the game.
     */
    @Override
    public String rules() {
        return "What is the result of the expression?";
    }

    /**
     * run next round.
     */
    @Override
    public String nextQuestion() {
        String op = operations[randomizer.nextInt(operations.length)];
        int op1 = randomizer.nextInt(Engine.MAX_NUMBER);
        int op2 = randomizer.nextInt(Engine.MAX_NUMBER);

        correctAnswer = String.valueOf(correctAnswer(op1, op2, op));

        return op1 + " " + op + " " + op2;
    }

    /**
     * checks if the game finished.
     *
     * @return correct answer for previous expression
     */
    @Override
    public String getCorrectAnswer() {
        return correctAnswer;
    }

    private static int correctAnswer(int op1, int op2, String op) {
        return switch (op) {
            case "+" -> op1 + op2;
            case "-" -> op1 - op2;
            case "*" -> op1 * op2;
            default -> throw new IllegalArgumentException("Unknown operator: " + op);
        };
    }
}
