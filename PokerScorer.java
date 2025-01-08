import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PokerScorer {
    public static String evaluateHand(List<Card> hand) {
        // Sort cards by rank for easier evaluation
        hand.sort((c1, c2) -> rankValue(c2.getRank()) - rankValue(c1.getRank()));

        if (isRoyalFlush(hand)) return "Royal Flush";
        if (isStraightFlush(hand)) return "Straight Flush";
        if (isFourOfAKind(hand)) return "Four of a Kind";
        if (isFullHouse(hand)) return "Full House";
        if (isFlush(hand)) return "Flush";
        if (isStraight(hand)) return "Straight";
        if (isThreeOfAKind(hand)) return "Three of a Kind";
        if (isTwoPair(hand)) return "Two Pair";
        if (isPair(hand)) return "One Pair";
        return "High Card: " + hand.get(0).getRank();
    }

    private static boolean isRoyalFlush(List<Card> hand) {
        return isStraightFlush(hand) && hand.get(0).getRank().equals("Ace");
    }

    private static boolean isStraightFlush(List<Card> hand) {
        return isFlush(hand) && isStraight(hand);
    }

    private static boolean isFourOfAKind(List<Card> hand) {
        return hasNOfAKind(hand, 4);
    }

    private static boolean isFullHouse(List<Card> hand) {
        return hasNOfAKind(hand, 3) && hasNOfAKind(hand, 2);
    }

    private static boolean isFlush(List<Card> hand) {
        return hand.stream().map(Card::getSuit).distinct().count() == 1;
    }

    private static boolean isStraight(List<Card> hand) {
        List<Integer> ranks = hand.stream().map(c -> rankValue(c.getRank())).sorted().toList();
        for (int i = 0; i < ranks.size() - 1; i++) {
            if (ranks.get(i) + 1 != ranks.get(i + 1)) return false;
        }
        return true;
    }

    private static boolean isThreeOfAKind(List<Card> hand) {
        return hasNOfAKind(hand, 3);
    }

    private static boolean isTwoPair(List<Card> hand) {
        return hand.stream()
                .collect(Collectors.groupingBy(Card::getRank, Collectors.counting()))
                .values()
                .stream()
                .filter(count -> count == 2)
                .count() == 2;
    }

    private static boolean isPair(List<Card> hand) {
        return hasNOfAKind(hand, 2);
    }

    private static boolean hasNOfAKind(List<Card> hand, int n) {
        return hand.stream()
                .collect(Collectors.groupingBy(Card::getRank, Collectors.counting()))
                .values()
                .contains((long) n);
    }

    private static int rankValue(String rank) {
        switch (rank) {
            case "2": return 2;
            case "3": return 3;
            case "4": return 4;
            case "5": return 5;
            case "6": return 6;
            case "7": return 7;
            case "8": return 8;
            case "9": return 9;
            case "10": return 10;
            case "Jack": return 11;
            case "Queen": return 12;
            case "King": return 13;
            case "Ace": return 14;
            default: throw new IllegalArgumentException("Invalid rank: " + rank);
        }
    }
}
