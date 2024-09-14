package hexlet.code.game;

public class CalculatorGame implements Game {

    private static final String[] OPERATIONS = new String[]{"+", "-", "*"};

    private String correctAnswer;

    /**
     * Provides the rules and instructions for the game.
     *
     * @return A string containing the game rules.
     */
    @Override
    public String rules() {
        return "What is the result of the expression?";
    }

    /**
     * Generates the next question in the game.
     *
     * @return A string representing the next question.
     */
    @Override
    public String nextQuestion() {
        String op = OPERATIONS[Engine.RANDOM.nextInt(OPERATIONS.length)];
        int op1 = Engine.RANDOM.nextInt(Engine.MAX_NUMBER);
        int op2 = Engine.RANDOM.nextInt(Engine.MAX_NUMBER);

        correctAnswer = String.valueOf(correctAnswer(op1, op2, op));

        return op1 + " " + op + " " + op2;
    }

    /**
     * Returns the correct answer to the last question.
     *
     * @return A string representing the correct answer.
     */
    @Override
    public String getCorrectAnswer() {
        return correctAnswer;
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

    private static int correctAnswer(int op1, int op2, String op) {
        return switch (op) {
            case "+" -> op1 + op2;
            case "-" -> op1 - op2;
            case "*" -> op1 * op2;
            default -> throw new IllegalArgumentException("Unknown operator: " + op);
        };
    }
}
