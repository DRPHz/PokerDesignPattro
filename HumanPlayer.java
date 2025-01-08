import java.util.Scanner;

public class HumanPlayer extends Player {
    private Scanner scanner;

    public HumanPlayer(String name) {
        super(name);
        scanner = new Scanner(System.in);
    }

    @Override
    public void playTurn() {
        System.out.println(name + ", it's your turn! Type 'fold' or 'call': ");
        String input = scanner.nextLine().toLowerCase();
        while (!input.equals("fold") && !input.equals("call")) {
            System.out.println("Invalid input. Please type 'fold' or 'call': ");
            input = scanner.nextLine().toLowerCase();
        }

        if (input.equals("fold")) {
            System.out.println(name + " folded!");
            System.out.println("You lost, the bot wins");
            System.exit(0); // End the game if the player folds
        }
    }

    @Override
    public void notifyEvent(String event) {
        System.out.println(name + " received event: " + event);
    }
}
