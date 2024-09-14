package hexlet.code.game;

public class PrimeGame implements Game {

    private int number;

    /**
     * Provides the rules and instructions for the game.
     *
     * @return A string containing the game rules.
     */
    @Override
    public String rules() {
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    }

    /**
     * Generates the next question in the game.
     *
     * @return A string representing the next question.
     */
    @Override
    public String nextQuestion() {
        number = Engine.RANDOM.nextInt(Engine.MAX_NUMBER);

        return String.valueOf(number);
    }

    /**
     * Returns the correct answer to the last question.
     *
     * @return A string representing the correct answer.
     */
    @Override
    public String getCorrectAnswer() {
        return isPrime(number) ? "yes" : "no";
    }

    /**
     * Checks if the user is eligible to play this game.
     *
     * @return true if the user can play this game; otherwise, false.
     */
    @Override
    public boolean canPlay() {
        return true;
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
