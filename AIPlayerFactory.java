public class AIPlayerFactory extends PlayerFactory {
    private AIStrategy strategy;

    public AIPlayerFactory(AIStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public Player createPlayer(String name) {
        return new AIPlayer(name, strategy);
    }
}
