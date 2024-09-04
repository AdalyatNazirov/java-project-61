package hexlet.code.game;

public class EmptyGame implements Game {

    @Override
    public void start(String playerName) {
    }

    @Override
    public void nextRound() {
    }

    @Override
    public boolean isGameOver() {
        return true;
    }
}
