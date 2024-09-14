package hexlet.code.game;

public class ProgressionGame implements Game {

    private static final int MIN_PROGRESSION_LENGTH = 5;
    private static final int MAX_PROGRESSION_LENGTH = 10;

    private int correctAnswer;

    /**
     * Provides the rules and instructions for the game.
     *
     * @return A string containing the game rules.
     */
    @Override
    public String rules() {
        return "What number is missing in the progression?";
    }

    /**
     * Generates the next question in the game.
     *
     * @return A string representing the next question.
     */
    @Override
    public String nextQuestion() {
        int start = Engine.RANDOM.nextInt(Engine.MAX_NUMBER);
        int step = Engine.RANDOM.nextInt(Engine.MAX_NUMBER);
        int amount = MIN_PROGRESSION_LENGTH + Engine.RANDOM.nextInt(MAX_PROGRESSION_LENGTH - MIN_PROGRESSION_LENGTH);
        int hiddenItemIndex = Engine.RANDOM.nextInt(amount);
        int[] progression = new int[amount];
        for (int i = 0; i < amount; i++) {
            progression[i] = start + i * step;
        }

        correctAnswer = progression[hiddenItemIndex];


        return displayHiddenProgression(progression, hiddenItemIndex);
    }

    /**
     * Returns the correct answer to the last question.
     *
     * @return A string representing the correct answer.
     */
    @Override
    public String getCorrectAnswer() {
        return String.valueOf(correctAnswer);
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

    private String displayHiddenProgression(int[] progression, int hiddenItemIndex) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < progression.length; i++) {
            if (i != hiddenItemIndex) {
                sb.append(progression[i]);
            } else {
                sb.append("..");
            }
            sb.append(" ");
        }
        return sb.delete(sb.length() - 1, sb.length()).toString();
    }
}
