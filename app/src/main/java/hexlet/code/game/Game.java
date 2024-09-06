package hexlet.code.game;

public interface Game {

    /**
     * returns score of current launch
     * @return
     */
    int getScore();

    /**
     * starts the game
     */
    void start();

    /**
     * move to next round
     */
    void nextRound();

    /**
     * checks if the game finished
     * @return
     */
    boolean isGameOver();
}
