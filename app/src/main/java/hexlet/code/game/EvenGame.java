package hexlet.code.game;

import java.util.Random;

public class EvenGame implements Game {

    private final Random randomizer;
    private int number;

    public EvenGame(Random randomizer) {
        this.randomizer = randomizer;
    }

    /**
     * starts the game.
     */
    @Override
    public String rules() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }

    /**
     * run next round.
     */
    @Override
    public String nextQuestion() {
        number = randomizer.nextInt(Engine.MAX_NUMBER);

        return String.valueOf(number);
    }

    @Override
    public String getCorrectAnswer() {
        return number % 2 == 0 ? "yes" : "no";
    }
}
