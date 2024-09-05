package hexlet.code.game;

public class EmptyGame implements Game {

    @Override
    public int getScore() {
        return Integer.MAX_VALUE;
    }

    @Override
    public void start() {
    }

    @Override
    public void nextRound() {
    }

    @Override
    public boolean isGameOver() {
        return false;
    }
}
