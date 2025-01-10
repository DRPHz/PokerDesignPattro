import java.util.List;
import java.util.Random;

public class DefensiveStrategy implements AIStrategy {
    private List<Card> privateCards;
    private int currentRound;
    private Random random;

    public DefensiveStrategy(List<Card> privateCards, int currentRound) {
        this.privateCards = privateCards;
        this.currentRound = currentRound;
        this.random = new Random(); // Initialize the random number generator
    }

    @Override
    public String decideAction() {
        // Evaluate the bot's hand strength
        String handRank = HandEvaluator.evaluateHand(privateCards);

        // Adjust the bot's behavior based on the round and hand strength
        if (currentRound == 1) {
            // Early game: less likely to fold unless the hand is really weak
            if (isWeakHand(handRank)) {
                return "call"; // Take a chance with weak hands early
            }
        } else {
            // Mid to late game: cautious behavior with weak hands
            if (isWeakHand(handRank)) {
                // 20% chance to fold
                if (random.nextInt(100) < 20) {
                    return "fold";
                }
                return "call";
            }
        }
        return "call";
    }

    private boolean isWeakHand(String handRank) {
        // Define weak hands: High Card is generally considered weak
        return handRank.equals("High Card");
    }
}
