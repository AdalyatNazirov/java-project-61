package hexlet.code.game;

public class EvenGame implements Game {

    private int number;

    @Override
    public String rules() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }

    @Override
    public String nextQuestion() {
        number = Engine.RANDOM.nextInt(Engine.MAX_NUMBER);

        return String.valueOf(number);
    }

    @Override
    public String getCorrectAnswer() {
        return number % 2 == 0 ? "yes" : "no";
    }

    @Override
    public boolean canPlay() {
        return true;
    }
}
