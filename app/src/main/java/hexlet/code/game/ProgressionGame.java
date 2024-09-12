package hexlet.code.game;

import java.util.Random;

public class ProgressionGame implements Game {
    private final Random randomizer;

    private static final int MIN_PROGRESSION_LENGTH = 5;
    private static final int MAX_PROGRESSION_LENGTH = 10;

    private int correctAnswer;

    ProgressionGame(Random randomizer) {
        this.randomizer = randomizer;
    }

    /**
     * starts the game.
     */
    @Override
    public String rules() {
        return "What number is missing in the progression?";
    }

    /**
     * run next round.
     */
    @Override
    public String nextQuestion() {
        int start = randomizer.nextInt(Engine.MAX_NUMBER);
        int step = randomizer.nextInt(Engine.MAX_NUMBER);
        int amount = MIN_PROGRESSION_LENGTH + randomizer.nextInt(MAX_PROGRESSION_LENGTH - MIN_PROGRESSION_LENGTH);
        int hiddenItemIndex = randomizer.nextInt(amount);
        int[] progression = new int[amount];
        for (int i = 0; i < amount; i++) {
            progression[i] = start + i * step;
        }

        correctAnswer = progression[hiddenItemIndex];


        return displayHiddenProgression(progression, hiddenItemIndex);
    }

    @Override
    public String getCorrectAnswer() {
        return String.valueOf(correctAnswer);
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
