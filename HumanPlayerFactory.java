public class HumanPlayerFactory extends PlayerFactory {
    @Override
    public Player createPlayer(String name) {
        return new HumanPlayer(name);
    }
}