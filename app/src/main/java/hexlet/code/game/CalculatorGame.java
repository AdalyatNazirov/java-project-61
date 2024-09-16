package hexlet.code.game;

public class CalculatorGame implements Game {

    private static final String[] OPERATIONS = new String[]{"+", "-", "*"};

    /**
     * Provides the rules and instructions for the game.
     *
     * @return A string containing the game rules.
     */
    @Override
    public String getRules() {
        return "What is the result of the expression?";
    }

    /**
     * Generates the next question in the game.
     *
     * @return A string representing the next question.
     */
    @Override
    public String[] moveToNextRound() {
        var op = OPERATIONS[Engine.RANDOM.nextInt(OPERATIONS.length)];
        var op1 = Engine.RANDOM.nextInt(Engine.MAX_NUMBER);
        var op2 = Engine.RANDOM.nextInt(Engine.MAX_NUMBER);

        var correctAnswer = String.valueOf(correctAnswer(op1, op2, op));

        return new String[]{op1 + " " + op + " " + op2, correctAnswer};
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
