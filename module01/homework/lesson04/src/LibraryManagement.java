public class LibraryManagement {
    
    static void main () {
        Book.libraryRules();
        
        Book b1 = new Book("Clean Code", "Robert C. Martin", "1234567890");
        System.out.println(b1.availableCopies);
        b1.printInfo();
        
        b1.borrowBook(1);
        b1.returnBook(1);
        Book.libraryRules();
        b1.bookType();
        
        b1.setAuthor("Robert Martin");
        String newAuthorName = b1.getAuthor();
        System.out.println(newAuthorName);
        
        Book b2 = new Book("Designing Data-Intensive Applications", "Martin", "9781449373320");
        b2.printInfo();
        b2.borrowBook(1);
        b2.returnBook(2);
        
        b2.incrementTotalCopies(5);
        int currentlyAvailable = b2.getTotalCopies();
        System.out.println("Currently available copies of: " + b2.getTitle() + " -> " + currentlyAvailable);
        
        
        Book b3 = new Book("Code", "Charles", "9780137909100");
        b3.printInfo();
        b3.borrowBook(1);
        b3.returnBook(1);
        b3.incrementTotalCopies(3);
        System.out.println(b3.totalCopies);
        b3.bookType();
    }
}
