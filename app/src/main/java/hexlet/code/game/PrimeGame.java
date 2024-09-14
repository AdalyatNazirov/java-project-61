package hexlet.code.game;

public class PrimeGame implements Game {

    private int number;

    @Override
    public String rules() {
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    }

    @Override
    public String nextQuestion() {
        number = Engine.RANDOM.nextInt(Engine.MAX_NUMBER);

        return String.valueOf(number);
    }

    @Override
    public String getCorrectAnswer() {
        return isPrime(number) ? "yes" : "no";
    }

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
