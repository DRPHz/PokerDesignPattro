public class LoggingPlayerDecorator extends PlayerDecorator {

    public LoggingPlayerDecorator(Player decoratedPlayer) {
        super(decoratedPlayer);
    }

    @Override
    public void playTurn() {
        System.out.println("Logging: " + decoratedPlayer.getName() + " is taking a turn.");
        super.playTurn();
    }

    @Override
    public void notifyEvent(String event) {
        System.out.println("Logging: " + decoratedPlayer.getName() + " received event: " + event);
        super.notifyEvent(event);
    }
}
