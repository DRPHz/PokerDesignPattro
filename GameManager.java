import java.util.*;

public class GameManager {
    private List<Player> players = new ArrayList<>();
    private List<Card> communityCards = new ArrayList<>();
    private int cardsRevealed = 0;

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void notifyPlayers(String event) {
        for (Player player : players) {
            player.notifyEvent(event);
        }
    }

    public void startGame() {
        Deck deck = Deck.getInstance();

        // Deal private cards to players
        for (Player player : players) {
            player.receiveCard(deck.drawCard());
            player.receiveCard(deck.drawCard());
        }

        // Show human player's cards
        Player humanPlayer = players.get(0);
        System.out.println(humanPlayer);

        // Initialize community cards
        for (int i = 0; i < 5; i++) {
            communityCards.add(deck.drawCard());
        }

        System.out.println("The game has started!");

        // Reveal the first three community cards
        cardsRevealed = 3; // Start with 3 revealed cards
        displayCommunityCards();

        for (int round = 1; round <= 4; round++) {
            playRound();
            if (cardsRevealed < 5) {
                revealNextCommunityCard();
            } else {
                break;
            }
        }

        determineWinner();
        System.out.println("The game has ended!");
    }


    private void revealNextCommunityCard() {
        if (cardsRevealed < communityCards.size()) {
            System.out.println("Revealing the next community card...");
            cardsRevealed++;
            displayCommunityCards();
        }
    }

    private void displayCommunityCards() {
        System.out.print("Community Cards: [");
        for (int i = 0; i < cardsRevealed; i++) {
            System.out.print(communityCards.get(i));
            if (i < cardsRevealed - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }




    private void playRound() {
        for (Player player : players) {
            player.playTurn();
            if (player instanceof HumanPlayer) {
                System.out.println("Bot is deciding..");
            }
        }
    }

    public void determineWinner() {
        // Combine private cards and community cards for the player and bot
        List<Card> playerHand = new ArrayList<>();
        playerHand.addAll(players.get(0).getPrivateCards()); // Player's private cards
        playerHand.addAll(communityCards); // Community cards

        List<Card> botHand = new ArrayList<>();
        botHand.addAll(players.get(1).getPrivateCards()); // Bot's private cards
        botHand.addAll(communityCards); // Community cards

        // Now evaluate both hands
        String playerHandRank = HandEvaluator.evaluateHand(playerHand);
        String botHandRank = HandEvaluator.evaluateHand(botHand);

        System.out.println("Player's Hand: " + playerHandRank);
        System.out.println("Bot's Hand: " + botHandRank);

        // Compare the hands
        if (playerHandRank.equals(botHandRank)) {
            System.out.println("It's a tie!");
        } else if (compareHands(playerHandRank, botHandRank)) {
            System.out.println("The winner is Player!");
        } else {
            System.out.println("The winner is Bot!");
        }
    }

    // Compare hands based on their rank
    private boolean compareHands(String playerHandRank, String botHandRank) {
        // Define the ranking of poker hands
        // The order is from weakest to strongest
        List<String> handRankOrder = Arrays.asList(
                "High Card", "One Pair", "Two Pair", "Three of a Kind",
                "Straight", "Flush", "Full House", "Four of a Kind",
                "Straight Flush", "Royal Flush"
        );

        // Compare hand ranks based on their position in the handRankOrder list
        return handRankOrder.indexOf(playerHandRank) > handRankOrder.indexOf(botHandRank);
    }
}
