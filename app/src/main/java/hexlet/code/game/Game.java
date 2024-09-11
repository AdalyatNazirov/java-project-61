package hexlet.code.game;

public interface Game {

    String rules();

    /**
     * Generate next question
     */
    String nextQuestion();

    /**
     * Returns correct answer on last question
     */
    String getCorrectAnswer();
}
