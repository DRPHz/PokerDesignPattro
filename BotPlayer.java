public class BotPlayer extends AIPlayer {
    public BotPlayer(String name) {
        super(name);
    }

    @Override
    public void playTurn() {
        // Use getStrategy() to access the strategy
        String action = getStrategy().decideAction();
        System.out.println(getName() + " chooses to " + action + ".");

        if (action.equals("fold")) {
            System.out.println(getName() + " folded!");
            System.out.println("The bot has folded. You win!");
            System.exit(0); // End the game if the bot folds
        }
    }
}
