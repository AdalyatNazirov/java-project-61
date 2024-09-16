package hexlet.code.game;

public class EvenGame implements Game {

    /**
     * Provides the rules and instructions for the game.
     *
     * @return A string containing the game rules.
     */
    @Override
    public String getRules() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }

    /**
     * Generates the next question in the game.
     *
     * @return A string representing the next question.
     */
    @Override
    public String[] moveNextRound() {
        var number = Engine.RANDOM.nextInt(Engine.MAX_NUMBER);
        var correctAnswer = number % 2 == 0 ? "yes" : "no";
        return new String[]{String.valueOf(number), correctAnswer};
    }
}
