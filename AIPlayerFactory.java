import java.util.Random;

public class AIPlayerFactory extends PlayerFactory {
    private Random random;

    public AIPlayerFactory() {
        this.random = new Random();
    }

    @Override
    public Player createPlayer(String name) {
        return new AIPlayer(name); // Strategy is set later in the game.
    }
}