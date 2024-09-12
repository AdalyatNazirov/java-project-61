package hexlet.code.game;

import java.util.Random;

public class GcdGame implements Game {

    private final Random randomizer;

    private int op1;
    private int op2;

    GcdGame(Random randomizer) {
        this.randomizer = randomizer;
    }

    /**
     * starts the game.
     */
    @Override
    public String rules() {
        return "Find the greatest common divisor of given numbers.";
    }

    /**
     * run next round.
     */
    @Override
    public String nextQuestion() {
        op1 = randomizer.nextInt(Engine.MAX_NUMBER);
        op2 = randomizer.nextInt(Engine.MAX_NUMBER);

        return op1 + " " + op2;
    }

    @Override
    public String getCorrectAnswer() {
        return String.valueOf(correctAnswer(op1, op2));
    }

    private static int correctAnswer(int op1, int op2) {
        return op1 % op2 == 0 ? op2 : correctAnswer(op2, op1 % op2);
    }
}
