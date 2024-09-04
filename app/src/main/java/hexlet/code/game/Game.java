package hexlet.code.game;

public interface Game {

    void start(String playerName);

    void nextRound();

    boolean isGameOver();
}
