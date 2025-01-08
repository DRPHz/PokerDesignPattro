import java.util.ArrayList;
import java.util.List;

public abstract class Player {
    protected String name;
    protected List<Card> privateCards = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void receiveCard(Card card) {
        privateCards.add(card);
    }

    public List<Card> getPrivateCards() {
        return privateCards;
    }

    public abstract void playTurn();

    public void notifyEvent(String event) {
        // No action needed for events now
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" - Private Cards: [");
        for (int i = 0; i < privateCards.size(); i++) {
            sb.append(privateCards.get(i));
            if (i < privateCards.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

}
