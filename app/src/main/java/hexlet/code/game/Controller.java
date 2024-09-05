package hexlet.code.game;

public class Controller {
    static final int MAX_NUMBER = 1000;
    static final int MAX_SCORE = 3;

    public static int[] listGames() {
        return new int[]{1, 2, 3, 4};
    }

    public static String getGameName(int gameNumber) {

        switch (gameNumber) {
            case 1:
                return "Greet";
            case 2:
                return "Even";
            case 3:
                return "Calc";
            case 4:
                return "GCD";
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
            case 1 -> new EmptyGame();
            case 2 -> new EvenGame();
            case 3 -> new CalculatorGame();
            case 4 -> new GcdGame();
            default -> throw new IllegalArgumentException("Invalid game number: " + gameNumber);
        };
    }
}
