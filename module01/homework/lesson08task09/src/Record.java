import java.time.LocalDate;

public class Record {
    
    private Book book;
    private LocalDate borrowedDate;
    private LocalDate returnedDate;
    
    public Record (Book book, LocalDate borrowedDate, LocalDate returnedDate) {
        this.book = book;
        this.borrowedDate = borrowedDate;
        this.returnedDate = returnedDate;
    }
    
    public Book getBook () {
        return book;
    }
    
    public LocalDate getBorrowedDate () {
        return borrowedDate;
    }

    public LocalDate getReturnedDate () {
        return returnedDate;
    }
    
    public boolean isReturned() {
        return returnedDate != null;
    }
}
