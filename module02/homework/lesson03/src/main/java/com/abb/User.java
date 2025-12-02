package com.abb;

import java.util.List;

@SuppressWarnings("ClassCanBeRecord")
public class User {
    
    private final String name;
    private final List<Record> borrowHistory;
    
    public User (
            String name,
            List<Record> borrowHistory
    ) {
        this.name = name;
        this.borrowHistory = borrowHistory;
    }
    
    public String getName () {
        return name;
    }
    
    public List<Record> getBorrowHistory () {
        return borrowHistory;
    }
}