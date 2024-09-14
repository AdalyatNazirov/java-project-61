package hexlet.code.game;

public class GcdGame implements Game {

    private int op1;
    private int op2;

    @Override
    public String rules() {
        return "Find the greatest common divisor of given numbers.";
    }

    @Override
    public String nextQuestion() {
        op1 = Engine.RANDOM.nextInt(Engine.MAX_NUMBER);
        op2 = Engine.RANDOM.nextInt(Engine.MAX_NUMBER);

        return op1 + " " + op2;
    }

    @Override
    public String getCorrectAnswer() {
        return String.valueOf(correctAnswer(op1, op2));
    }

    @Override
    public boolean canPlay() {
        return true;
    }

    private static int correctAnswer(int op1, int op2) {
        return op1 % op2 == 0 ? op2 : correctAnswer(op2, op1 % op2);
    }
}
