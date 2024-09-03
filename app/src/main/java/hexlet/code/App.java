package hexlet.code;

public class App {
    public static void main(String[] args) {
        System.out.println("Welcome to the Brain Games!");

        var name = Cli.fetchUserName();
        System.out.println("Hello, " + name + "!");
    }
}
