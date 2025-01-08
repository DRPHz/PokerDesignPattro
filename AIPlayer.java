public class AIPlayer extends Player {
    private AIStrategy strategy;
    private int currentTurn;

    public AIPlayer(String name, AIStrategy strategy) {
        super(name);
        this.strategy = strategy;
        this.currentTurn = 0; // Track the current turn number
    }

    @Override
    public void playTurn() {
        String action = strategy.decideAction();
        System.out.println(name + " chooses to " + action + ".");
    }

    @Override
    public void notifyEvent(String event) {
        // Example of event handling: increment turn on each round
        if (event.equals("newTurn")) {
            currentTurn++;
        }
        System.out.println(name + " received event: " + event);
    }

    // New setter for the strategy
    public void setStrategy(AIStrategy strategy) {
        this.strategy = strategy;
    }

    // Getter for strategy (if needed)
    public AIStrategy getStrategy() {
        return this.strategy;
    }
}
