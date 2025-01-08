public class DefensiveStrategy implements AIStrategy {
    @Override
    public String decideAction() {
        return Math.random() > 0.5 ? "call" : "fold"; // Randomize decision
    }
}