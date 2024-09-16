package hexlet.code.game;

public interface Game {

    /**
     * Provides the rules and instructions for the game.
     *
     * @return A string containing the game rules.
     */
    String getRules();

    /**
     * Generates the next question and answer in the game.
     *
     * @return An array representing the next question and answer.
     */
    String[] moveNextRound();
}
