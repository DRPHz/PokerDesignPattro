public class StatisticsPlayerDecorator extends PlayerDecorator {
    private int turnsPlayed = 0;

    public StatisticsPlayerDecorator(Player decoratedPlayer) {
        super(decoratedPlayer);
    }

    @Override
    public void playTurn() {
        turnsPlayed++;
        System.out.println(decoratedPlayer.getName() + " is playing its " + turnsPlayed + " turns.");
        super.playTurn();
    }

    public int getTurnsPlayed() {
        return turnsPlayed;
    }
}
