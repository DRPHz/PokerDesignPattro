import java.util.List;

public abstract class PlayerDecorator extends Player {
    protected Player decoratedPlayer;

    public PlayerDecorator(Player decoratedPlayer) {
        super(decoratedPlayer.getName());
        this.decoratedPlayer = decoratedPlayer;
    }

    @Override
    public void playTurn() {
        decoratedPlayer.playTurn();
    }

    @Override
    public void notifyEvent(String event) {
        decoratedPlayer.notifyEvent(event);
    }

    @Override
    public List<Card> getPrivateCards() {
        return decoratedPlayer.getPrivateCards();
    }
}
