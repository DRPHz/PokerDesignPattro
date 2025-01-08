public class AggressiveStrategy implements AIStrategy {
    @Override
    public String decideAction() {
        return "call"; // Always call in this strategy
    }
}