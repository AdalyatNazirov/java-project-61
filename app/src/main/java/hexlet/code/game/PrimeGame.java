package hexlet.code.game;

public class PrimeGame implements Game {

    /**
     * Provides the rules and instructions for the game.
     *
     * @return A string containing the game rules.
     */
    @Override
    public String getRules() {
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    }

    /**
     * Generates the next question in the game.
     *
     * @return A string representing the next question.
     */
    @Override
    public String[] moveToNextRound() {
        var number = Engine.RANDOM.nextInt(Engine.MAX_NUMBER);
        var correctAnswer = isPrime(number) ? "yes" : "no";
        return new String[]{
                String.valueOf(number), correctAnswer
        };
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
