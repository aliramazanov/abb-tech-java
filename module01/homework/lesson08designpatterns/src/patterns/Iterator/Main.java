package patterns.Iterator;

public class Main {
    
    static void main () {
        
        BetHistory history = new BetHistory();
        history.addBet(new Bet("B001", "Roulette", 100, "Win"));
        history.addBet(new Bet("B002", "Blackjack", 50, "Loss"));
        history.addBet(new Bet("B003", "Slots", 25, "Win"));
        history.addBet(new Bet("B004", "Poker", 200, "Win"));
        
        BetIterator iterator = history.createIterator();
        
        System.out.println("Player Bet History:");
        
        while (iterator.hasNext()) {
            Bet bet = iterator.next();
            System.out.println(bet);
        }
    }
}