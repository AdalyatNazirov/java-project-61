package hexlet.code.game;

public interface Game {

    /**
     * returns score of current launch.
     *
     * @return number of rounds finished successfully
     */
    int getScore();

    /**
     * starts the game.
     */
    void start();

    /**
     * run next round.
     */
    void nextRound();

    /**
     * checks if the game finished.
     *
     * @return true if game is finished, otherwise false
     */
    boolean isGameOver();
}
