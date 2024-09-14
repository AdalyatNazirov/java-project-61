package hexlet.code.game;

public class GcdGame implements Game {

    private int op1;
    private int op2;

    /**
     * Provides the rules and instructions for the game.
     *
     * @return A string containing the game rules.
     */
    @Override
    public String rules() {
        return "Find the greatest common divisor of given numbers.";
    }

    /**
     * Generates the next question in the game.
     *
     * @return A string representing the next question.
     */
    @Override
    public String nextQuestion() {
        op1 = Engine.RANDOM.nextInt(Engine.MAX_NUMBER);
        op2 = Engine.RANDOM.nextInt(Engine.MAX_NUMBER);

        return op1 + " " + op2;
    }

    /**
     * Returns the correct answer to the last question.
     *
     * @return A string representing the correct answer.
     */
    @Override
    public String getCorrectAnswer() {
        return String.valueOf(correctAnswer(op1, op2));
    }

    /**
     * Checks if the user is eligible to play this game.
     *
     * @return true if the user can play this game; otherwise, false.
     */
    @Override
    public boolean canPlay() {
        return true;
    }

    private static int correctAnswer(int op1, int op2) {
        return op1 % op2 == 0 ? op2 : correctAnswer(op2, op1 % op2);
    }
}
