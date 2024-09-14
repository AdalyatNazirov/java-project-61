package hexlet.code.game;

public class EmptyGame implements Game {


    @Override
    public String rules() {
        return "";
    }

    @Override
    public String nextQuestion() {
        return "";
    }

    @Override
    public String getCorrectAnswer() {
        return "";
    }

    @Override
    public boolean canPlay() {
        return false;
    }
}
