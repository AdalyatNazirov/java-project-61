package hexlet.code.game;

public interface Game {

    int getScore();

    void start();

    void nextRound();

    boolean isGameOver();
}
