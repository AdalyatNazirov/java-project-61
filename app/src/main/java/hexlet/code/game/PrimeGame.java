package hexlet.code.game;

import java.util.Random;

public class PrimeGame implements Game {
    private final Random randomizer;

    private int number;

    PrimeGame(Random randomizer) {
        this.randomizer = randomizer;
    }


    /**
     * starts the game.
     */
    @Override
    public String rules() {
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
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
        return isPrime(number) ? "yes" : "no";
    }

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i <= number / 2; i++) {
            if ((number % i) == 0) {
                return false;
            }
        }
        return true;
    }
}
