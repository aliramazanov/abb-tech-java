void main () {
    Scanner scanner = new Scanner(System.in);
    
    Library<Library.Section> library = new Library<>();
    
    Library.Section fiction = new Library.Section("Fiction");
    Library.Section science = new Library.Section("Science");
    Library.Section biography = new Library.Section("Biography");
    Library.Section history = new Library.Section("History");
    
    Library<Library.Section>.Book b1 = library.new Book("The Martian", "Andy Weir", 2011);
    Library<Library.Section>.Book b2 = library.new Book("Dune", "Frank Herbert", 1965);
    Library<Library.Section>.Book b3 = library.new Book("Churchill: A Biography", "Roy Jenkins", 2001);
    Library<Library.Section>.Book b4 = library.new Book("The Silk Roads", "Peter Frankopan", 2015);
    
    fiction.addBook(b1);
    science.addBook(b2);
    biography.addBook(b3);
    history.addBook(b4);
    
    library.addSection(fiction);
    library.addSection(science);
    library.addSection(biography);
    library.addSection(history);
    
    library.displayAllSections();
    
    System.out.print("Enter year to filter books after: ");
    int filterYear = scanner.nextInt();
    
    library.filterBooks(new BookFilter() {
        @Override
        public boolean filter(Library<?>.Book book) {
            return book.getYear() > filterYear;
        }
    });
    
    scanner.close();
}