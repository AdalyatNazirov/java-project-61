package hexlet.code.game;

public class GcdGame implements Game {

    /**
     * Provides the rules and instructions for the game.
     *
     * @return A string containing the game rules.
     */
    @Override
    public String getRules() {
        return "Find the greatest common divisor of given numbers.";
    }

    /**
     * Generates the next question in the game.
     *
     * @return A string representing the next question.
     */
    @Override
    public String[] moveToNextRound() {
        var op1 = Engine.RANDOM.nextInt(Engine.MAX_NUMBER);
        var op2 = Engine.RANDOM.nextInt(Engine.MAX_NUMBER);
        var correctAnswer = String.valueOf(correctAnswer(op1, op2));
        return new String[]{op1 + " " + op2, correctAnswer};
    }

    private static int correctAnswer(int op1, int op2) {
        return op1 % op2 == 0 ? op2 : correctAnswer(op2, op1 % op2);
    }
}
