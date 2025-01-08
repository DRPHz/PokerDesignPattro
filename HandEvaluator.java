import java.util.*;

public class HandEvaluator {

    public static String evaluateHand(List<Card> hand) {
        // Sort the hand by rank (descending order)
        Collections.sort(hand, (card1, card2) -> Integer.compare(card2.getRankValue(), card1.getRankValue()));

        // Group cards by rank (suit doesn't matter for hand evaluation)
        Map<Integer, Integer> rankGroups = new HashMap<>();

        for (Card card : hand) {
            rankGroups.put(card.getRankValue(), rankGroups.getOrDefault(card.getRankValue(), 0) + 1);
        }

        // Check for flush (all cards of the same suit)
        Map<String, List<Card>> suitGroups = new HashMap<>();
        for (Card card : hand) {
            suitGroups.computeIfAbsent(card.getSuit(), k -> new ArrayList<>()).add(card);
        }
        boolean isFlush = suitGroups.values().stream().anyMatch(cards -> cards.size() >= 5);

        // Check for straight (5 consecutive ranks)
        Set<Integer> uniqueRanks = new HashSet<>();
        for (Card card : hand) {
            uniqueRanks.add(card.getRankValue());
        }

        boolean isStraight = false;
        if (uniqueRanks.contains(14)) { // Ace exists
            // Ace can form a low straight: Ace-2-3-4-5
            if (uniqueRanks.contains(2) && uniqueRanks.contains(3) && uniqueRanks.contains(4) && uniqueRanks.contains(5)) {
                isStraight = true;
            }
        }
        // Check for high straight (10-J-Q-K-A, or any other sequence)
        for (int i = 0; i < 14; i++) {
            if (uniqueRanks.contains(i) && uniqueRanks.contains(i + 1) && uniqueRanks.contains(i + 2) && uniqueRanks.contains(i + 3) && uniqueRanks.contains(i + 4)) {
                isStraight = true;
                break;
            }
        }

        // Evaluate pairs
        List<Integer> pairs = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : rankGroups.entrySet()) {
            if (entry.getValue() == 2) {
                pairs.add(entry.getKey());
            }
        }

        // Hand evaluation logic
        if (rankGroups.containsValue(4)) return "Four of a Kind";
        if (rankGroups.containsValue(3) && rankGroups.containsValue(2)) return "Full House";
        if (isFlush) return "Flush";
        if (isStraight) return "Straight";
        if (rankGroups.containsValue(3)) return "Three of a Kind";

        if (pairs.size() == 2) {
            return "Two Pair";
        }

        if (pairs.size() == 1) {
            return "One Pair";
        }

        return "High Card";
    }
}
