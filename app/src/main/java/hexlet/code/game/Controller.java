package hexlet.code.game;

public class Controller {
    public static final int MAX_NUMBER = 1000;
    public static final int MAX_SCORE = 3;

    private static final int GREET_INDEX = 1;
    private static final int EVEN_INDEX = 2;
    private static final int CALC_INDEX = 3;
    private static final int GCD_INDEX = 4;
    private static final int PROGRESSION_INDEX = 5;
    private static final int PRIME_INDEX = 6;

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

        switch (gameNumber) {
            case GREET_INDEX:
                return "Greet";
            case EVEN_INDEX:
                return "Even";
            case CALC_INDEX:
                return "Calc";
            case GCD_INDEX:
                return "GCD";
            case PROGRESSION_INDEX:
                return "Progression";
            case PRIME_INDEX:
                return "Prime";
            default:
                throw new IllegalArgumentException("Invalid game number: " + gameNumber);
        }
    }

    public static void launch(int gameNumber, String playerName) {
        Game game = chooseGame(gameNumber);

        game.start();

        while (!game.isGameOver()) {
            game.nextRound();
            if (game.getScore() >= MAX_SCORE) {
                break;
            }
        }

        if (game.getScore() >= MAX_SCORE) {
            System.out.println("Congratulations, " + playerName + "!");
        } else {
            System.out.println("Let's try again, " + playerName + "!");
        }
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
