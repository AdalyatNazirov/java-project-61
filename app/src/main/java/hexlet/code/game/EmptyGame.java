package hexlet.code.game;

public class EmptyGame implements Game {

    /**
     * returns score of current launch.
     *
     * @return
     */
    @Override
    public int getScore() {
        return Integer.MAX_VALUE;
    }

    /**
     * starts the game.
     */
    @Override
    public void start() {
    }

    /**
     * run next round.
     */
    @Override
    public void nextRound() {
    }

    /**
     * checks if the game finished.
     *
     * @return true if game is finished, otherwise false
     */
    @Override
    public boolean isGameOver() {
        return false;
    }
}
