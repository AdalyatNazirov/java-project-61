package hexlet.code.game;

public class CalculatorGame implements Game {

    private static final String[] OPERATIONS = new String[]{"+", "-", "*"};

    private String correctAnswer;

    @Override
    public String rules() {
        return "What is the result of the expression?";
    }

    @Override
    public String nextQuestion() {
        String op = OPERATIONS[Engine.RANDOM.nextInt(OPERATIONS.length)];
        int op1 = Engine.RANDOM.nextInt(Engine.MAX_NUMBER);
        int op2 = Engine.RANDOM.nextInt(Engine.MAX_NUMBER);

        correctAnswer = String.valueOf(correctAnswer(op1, op2, op));

        return op1 + " " + op + " " + op2;
    }

    @Override
    public String getCorrectAnswer() {
        return correctAnswer;
    }

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
