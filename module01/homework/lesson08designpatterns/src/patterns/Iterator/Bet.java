package patterns.Iterator;

public class Bet {
    
    private final String betId;
    private final String game;
    private final double amount;
    private final String result;
    
    public Bet (String betId, String game, double amount, String result) {
        this.betId = betId;
        this.game = game;
        this.amount = amount;
        this.result = result;
    }
    
    @Override
    public String toString () {
        return "Bet " + betId + ": " + game + " - $" + amount + " - " + result;
    }
}