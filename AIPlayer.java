public class AIPlayer extends Player {
    private AIStrategy strategy;

    public AIPlayer(String name) {
        super(name);
    }

    public void setStrategy(AIStrategy strategy) {
        this.strategy = strategy;
    }

    public AIStrategy getStrategy() {
        return strategy;
    }

    @Override
    public void playTurn() {
        if (strategy != null) {
            String action = strategy.decideAction();
            System.out.println(name + " decided to " + action + "!");
        } else {
            System.out.println(name + " has no strategy set!");
        }
    }

    @Override
    public void notifyEvent(String event) {
        System.out.println(name + " received event: " + event);
    }
}