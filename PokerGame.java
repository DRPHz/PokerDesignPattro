public class PokerGame {
    public static void main(String[] args) {
        PlayerFactory humanFactory = new HumanPlayerFactory();
        PlayerFactory aiFactory = new AIPlayerFactory();

        Player humanPlayer = humanFactory.createPlayer("You");
        Player aiPlayer = aiFactory.createPlayer("Bot");


        humanPlayer = new LoggingPlayerDecorator(new StatisticsPlayerDecorator(humanPlayer));

        GameManager gameManager = new GameManager();
        gameManager.addPlayer(humanPlayer);
        gameManager.addPlayer(aiPlayer);

        gameManager.startGame();
    }
}