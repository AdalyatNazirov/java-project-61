package hexlet.code.game;

public interface Game {

    /**
     * Provides the rules and instructions for the game.
     *
     * @return A string containing the game rules.
     */
    String rules();

    /**
     * Generates the next question in the game.
     *
     * @return A string representing the next question.
     */
    String nextQuestion();

    /**
     * Returns the correct answer to the last question.
     *
     * @return A string representing the correct answer.
     */
    String getCorrectAnswer();

    /**
     * Checks if the user is eligible to play this game.
     *
     * @return true if the user can play this game; otherwise, false.
     */
    boolean canPlay();
}
