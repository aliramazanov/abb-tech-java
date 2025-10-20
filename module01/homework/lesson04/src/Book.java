public class Book {
    
    protected int totalCopies;
    protected int availableCopies;
    private String title;
    private String author;
    private String isbn;
    
    {
        System.out.println("New book is being created!");
    }
    
    Book (String title, String author, String isbn) {
        
        boolean doesTitleExist = !title.isBlank();
        boolean doesAuthorExist = !author.isBlank();
        boolean doesIsbnExist = !isbn.isBlank();
        
        if (doesTitleExist && doesAuthorExist && doesIsbnExist) {
            this.totalCopies = 1;
            this.availableCopies = 1;
            this.title = title;
            this.author = author;
            this.isbn = isbn;
        }
        else {
            System.out.println("Please add Title, Author and ISBN of the Book!");
        }
    }
    
    public static void libraryRules () {
        System.out.println("Max 3 books can be borrowed per person.");
    }
    
    public final void bookType () {
        System.out.println("This is a regular book.");
    }
    
    public String getTitle () {
        return title;
    }
    
    public String getAuthor () {
        return author;
    }
    
    public void setAuthor (String author) {
        this.author = author;
    }
    
    public int getTotalCopies () {
        return totalCopies;
    }
    
    public void incrementTotalCopies (int addedCopies) {
        this.totalCopies += addedCopies;
    }
    
    public void borrowBook (int borrowCount) {
        if (this.availableCopies > 0 && borrowCount <= this.availableCopies) {
            this.availableCopies -= borrowCount;
            System.out.println("Book borrowed successfully.");
        }
        else {
            System.out.println("Sorry, no copies available.");
        }
    }
    
    public void returnBook (int returnCount) {
        if (this.availableCopies + returnCount <= this.totalCopies) {
            availableCopies += returnCount;
            System.out.println("Book returned successfully.");
        }
        else {
            System.out.println("All copies are already in the library.");
        }
    }
    
    public void printInfo () {
        System.out.println("The name of the book: " + this.title);
        System.out.println("The author of the book: " + this.author);
        System.out.println("The ISBN of the book: " + this.isbn);
        System.out.println("Available copies: " + this.availableCopies);
        System.out.println("Total copies: " + this.totalCopies);
    }
}
