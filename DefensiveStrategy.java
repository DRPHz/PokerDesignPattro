import java.util.List;  // Added import for List

public class DefensiveStrategy implements AIStrategy {
    private List<Card> privateCards;
    private int currentTurn;

    public DefensiveStrategy(List<Card> privateCards, int currentTurn) {
        this.privateCards = privateCards;
        this.currentTurn = currentTurn;
    }

    @Override
    public String decideAction() {
        // Check hand based on the current turn and hand strength
        if (currentTurn > 0) {  // After the first round (including the Flop)
            if (hasOnlyHighCard()) {
                return Math.random() > 0.5 ? "fold" : "call"; // 50% chance to fold
            }
        }
        if (currentTurn > 1) {  // After the second round (including the Turn)
            if (hasSinglePair()) {
                return Math.random() > 0.5 ? "fold" : "call"; // 50% chance to fold
            }
        }
        return "call"; // Default to calling if none of the conditions are met
    }

    private boolean hasOnlyHighCard() {
        // Implement logic to determine if the bot has only a high card
        // We'll use HandEvaluator here to determine if the hand is only a high card
        return HandEvaluator.evaluateHand(privateCards).equals("High Card");
    }

    private boolean hasSinglePair() {
        // Implement logic to determine if the bot has only a single pair
        // We'll use HandEvaluator here to determine if the hand is a single pair
        return HandEvaluator.evaluateHand(privateCards).equals("One Pair");
    }
}
