package hexlet.code.game;

public class EvenGame implements Game {
    /**
     * starts the game.
     */
    @Override
    public String rules() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }

    /**
     * run next round.
     */
    @Override
    public void nextRound() {
        int number = ran.nextInt(Controller.MAX_NUMBER);
        System.out.println("Question: " + number);

        var answer = scanner.nextLine();
        System.out.println("Your answer: " + answer);

        if (answer.equals(correctAnswer(number))) {
            this.score++;
            System.out.println("Correct!");
        } else {
            System.out.println("'" + answer
                    + "' is wrong answer ;(. Correct answer was '"
                    + correctAnswer(number)
                    + "'.");
            this.gameOver = true;
        }
    }

    private static String correctAnswer(int number) {
        return number % 2 == 0 ? "yes" : "no";
    }
}
