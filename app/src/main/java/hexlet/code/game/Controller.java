package hexlet.code.game;

public class Controller {
    private static final int EVEN_INDEX = 2;
    private static final int CALC_INDEX = 3;
    private static final int GCD_INDEX = 4;
    private static final int PROGRESSION_INDEX = 5;
    private static final int PRIME_INDEX = 6;

    public static String[] listOptions() {
        var options = new String[listGames().length];

        int i = 0;
        for (int index : listGames()) {
            options[i] = index + " - " + getGameName(index);
            i++;
        }

        return options;
    }

    private static int[] listGames() {

        return new int[]{
                EVEN_INDEX,
                CALC_INDEX,
                GCD_INDEX,
                PROGRESSION_INDEX,
                PRIME_INDEX};
    }

    private static String getGameName(int gameNumber) {

        return switch (gameNumber) {
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
            case EVEN_INDEX -> new EvenGame();
            case CALC_INDEX -> new CalculatorGame();
            case GCD_INDEX -> new GcdGame();
            case PROGRESSION_INDEX -> new ProgressionGame();
            case PRIME_INDEX -> new PrimeGame();
            default -> throw new IllegalArgumentException("Invalid game number: " + gameNumber);
        };
    }
}
