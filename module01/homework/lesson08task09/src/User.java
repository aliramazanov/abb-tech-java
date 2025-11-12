import java.util.List;

public class User {
    
    private String name;
    private int age;
    private List<Record> borrowHistory;
    
    public User (
            String name,
            int age,
            List<Record> borrowHistory
    ) {
        this.name = name;
        this.age = age;
        this.borrowHistory = borrowHistory;
    }
    
    public String getName () {
        return name;
    }
    
    public List<Record> getBorrowHistory () {
        return borrowHistory;
    }
}
