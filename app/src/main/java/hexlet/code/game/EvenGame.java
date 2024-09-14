package hexlet.code.game;

public class EvenGame implements Game {

    private int number;

    /**
     * Provides the rules and instructions for the game.
     *
     * @return A string containing the game rules.
     */
    @Override
    public String rules() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }

    /**
     * Generates the next question in the game.
     *
     * @return A string representing the next question.
     */
    @Override
    public String nextQuestion() {
        number = Engine.RANDOM.nextInt(Engine.MAX_NUMBER);

        return String.valueOf(number);
    }

    /**
     * Returns the correct answer to the last question.
     *
     * @return A string representing the correct answer.
     */
    @Override
    public String getCorrectAnswer() {
        return number % 2 == 0 ? "yes" : "no";
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
}
