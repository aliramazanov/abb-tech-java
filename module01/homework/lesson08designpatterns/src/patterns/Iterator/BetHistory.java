package patterns.Iterator;

import java.util.ArrayList;
import java.util.List;

public class BetHistory implements BetCollection {
    private final List<Bet> bets;
    
    public BetHistory () {
        this.bets = new ArrayList<>();
    }
    
    public void addBet (Bet bet) {
        bets.add(bet);
    }
    
    @Override
    public BetIterator createIterator () {
        return new BetHistoryIterator(bets);
    }
}