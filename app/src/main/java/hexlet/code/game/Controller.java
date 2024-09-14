package hexlet.code.game;

public class Controller {
    private static final int EXIT = 0;
    private static final int GREET_INDEX = 1;
    private static final int EVEN_INDEX = 2;
    private static final int CALC_INDEX = 3;
    private static final int GCD_INDEX = 4;
    private static final int PROGRESSION_INDEX = 5;
    private static final int PRIME_INDEX = 6;

    public static String[] listOptions() {
        var options = new String[listGames().length + 1];

        int i = 0;
        for (i = 0; i < listGames().length; i++) {
            options[i + 1] = i + " - " + Controller.getGameName(i);
        }

        options[options.length - 1] = "0 - Exit";
        return options;
    }

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
        if (gameNumber == EXIT) {
            System.out.println("Sorry to see you go and hope that we will meet again..;(");

            return;
        }

        Game game = chooseGame(gameNumber);

        Engine.start(game);
    }

    private static Game chooseGame(int gameNumber) {

        return switch (gameNumber) {
            case GREET_INDEX -> new EmptyGame();
            case EVEN_INDEX -> new EvenGame();
            case CALC_INDEX -> new CalculatorGame();
            case GCD_INDEX -> new GcdGame();
            case PROGRESSION_INDEX -> new ProgressionGame();
            case PRIME_INDEX -> new PrimeGame();
            default -> throw new IllegalArgumentException("Invalid game number: " + gameNumber);
        };
    }
}
