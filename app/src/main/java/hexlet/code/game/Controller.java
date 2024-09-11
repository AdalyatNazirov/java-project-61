package hexlet.code.game;

import java.util.Random;

public class Controller {
    private static final int GREET_INDEX = 1;
    private static final int EVEN_INDEX = 2;
    private static final int CALC_INDEX = 3;
    private static final int GCD_INDEX = 4;
    private static final int PROGRESSION_INDEX = 5;
    private static final int PRIME_INDEX = 6;

    private static final Random ran = new Random();

    public static int[] listGames() {
        return new int[]{
                GREET_INDEX,
                EVEN_INDEX,
                CALC_INDEX,
                GCD_INDEX,
                PROGRESSION_INDEX,
                PRIME_INDEX};
    }

    public static String getGameName(int gameNumber) {

        return switch (gameNumber) {
            case GREET_INDEX -> "Greet";
            case EVEN_INDEX -> "Even";
            case CALC_INDEX -> "Calc";
            case GCD_INDEX -> "GCD";
            case PROGRESSION_INDEX -> "Progression";
            case PRIME_INDEX -> "Prime";
            default -> throw new IllegalArgumentException("Invalid game number: " + gameNumber);
        };
    }

    public static void launch(int gameNumber) {
        Game game = chooseGame(gameNumber);

        Engine.start(game);
    }

    private static Game chooseGame(int gameNumber) {

        return switch (gameNumber) {
            case GREET_INDEX -> new EmptyGame();
            case EVEN_INDEX -> new EvenGame();
            case CALC_INDEX -> new CalculatorGame(ran);
            case GCD_INDEX -> new GcdGame();
            case PROGRESSION_INDEX -> new ProgressionGame();
            case PRIME_INDEX -> new PrimeGame();
            default -> throw new IllegalArgumentException("Invalid game number: " + gameNumber);
        };
    }
}
