public class AIPlayer extends Player {
    private AIStrategy strategy;

    public AIPlayer(String name, AIStrategy strategy) {
        super(name);
        this.strategy = strategy;
    }

    @Override
    public void playTurn() {
        String action = strategy.decideAction();
        System.out.println(name + " chooses to " + action + ".");
    }

    @Override
    public void notifyEvent(String event) {
        System.out.println(name + " received event: " + event);
    }
}