package patterns.Iterator;

import java.util.List;

public class BetHistoryIterator implements BetIterator {
    private final List<Bet> bets;
    private int position;
    
    public BetHistoryIterator (List<Bet> bets) {
        this.bets = bets;
    }
    
    @Override
    public boolean hasNext () {
        return position < bets.size();
    }
    
    @Override
    public Bet next () {
        return bets.get(position++);
    }
}