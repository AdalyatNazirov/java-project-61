package hexlet.code.game;

public class Controller {

    public static int[] listGames() {
        return new int[]{1, 2};
    }

    public static String getGameName(int gameNumber) {

        switch (gameNumber) {
            case 1:
                return "Greet";
            case 2:
                return "Even";
            default:
                throw new IllegalArgumentException("Invalid game number: " + gameNumber);
        }
    }

    public static void launch(int gameNumber, String playerName) {
        Game game = chooseGame(gameNumber);

        game.start(playerName);
        while (!game.isGameOver()) {
            game.nextRound();
        }
    }

    private static Game chooseGame(int gameNumber) {

        switch (gameNumber) {
            case 1:
                return new EmptyGame();
            case 2:
                return new EvenGame();
            default:
                throw new IllegalArgumentException("Invalid game number: " + gameNumber);
        }
    }
}
