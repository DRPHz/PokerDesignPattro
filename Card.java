import java.util.List;
import java.util.Collections;

public class Card {
    private final String rank;
    private final String suit;
    private final int rankValue; // numerical value for comparison

    // Constructor to assign rank, suit, and calculate rankValue
    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
        this.rankValue = getRankValue(rank);
    }

    // Returns the rank (e.g., "Ace", "2", "King")
    public String getRank() {
        return rank;
    }

    // Returns the suit (e.g., "Clubs", "Spades")
    public String getSuit() {
        return suit;
    }

    // Returns the rank value (e.g., 14 for "Ace", 2 for "2", etc.)
    public int getRankValue() {
        return rankValue;
    }

    // Maps rank names to numerical values (Ace = 14, King = 13, etc.)
    private int getRankValue(String rank) {
        switch (rank) {
            case "Ace": return 14;
            case "King": return 13;
            case "Queen": return 12;
            case "Jack": return 11;
            case "10": return 10;
            case "9": return 9;
            case "8": return 8;
            case "7": return 7;
            case "6": return 6;
            case "5": return 5;
            case "4": return 4;
            case "3": return 3;
            case "2": return 2;
            default: return 0;
        }
    }

    @Override
    public String toString() {
        return formatCard();
    }

    private String formatCard() {
        String symbol = "";
        String colorCode = "";

        switch (suit) {
            case "Clubs":
                symbol = "♣";
                colorCode = "\u001B[30m"; // Black
                break;
            case "Diamonds":
                symbol = "♦";
                colorCode = "\u001B[31m"; // Red
                break;
            case "Hearts":
                symbol = "♥";
                colorCode = "\u001B[31m"; // Red
                break;
            case "Spades":
                symbol = "♠";
                colorCode = "\u001B[30m"; // Black
                break;
        }

        String resetColor = "\u001B[0m";
        return colorCode + rank + " of " + symbol + resetColor;
    }
}
