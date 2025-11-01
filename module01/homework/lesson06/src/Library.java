import java.util.ArrayList;
import java.util.List;

public class Library <T extends Library.Section> {
    
    private final List<T> sections = new ArrayList<>();
    
    public static class Section {
        private final String name;
        private final List<Library<?>.Book> books = new ArrayList<>();
        
        public Section (String name) {
            this.name = name;
        }
        
        public String getName () {
            return name;
        }
        
        public List<Library<?>.Book> getBooks () {
            return books;
        }
        
        public void addBook (Library<?>.Book book) {
            books.add(book);
        }
        
        public void displayBooks () {
            for (Library<?>.Book book : books) {
                System.out.println(book);
            }
        }
    }
    
    @SuppressWarnings("InnerClassMayBeStatic")
    public class Book {
        private final String title;
        private final String author;
        private final int year;
        
        public Book (String title, String author, int year) {
            this.title = title;
            this.author = author;
            this.year = year;
        }
        
        public int getYear () {
            return year;
        }
        
        @Override
        public String toString () {
            return "Book => Title: " + title + ", Author: " + author + ", Year: " + year;
        }
    }
    
    public void addSection (T section) {
        sections.add(section);
    }
    
    public void displayAllSections () {
       
        for (T section : sections) {
            System.out.println("Section: " + section.getName());
            section.displayBooks();
            System.out.println();
        }
    }
    
    public void filterBooks (BookFilter filter) {
        
        System.out.println("Filtered books: ");
       
        for (T section : sections) {
       
            for (Library<?>.Book book : section.getBooks()) {
       
                if (filter.filter(book)) {
                    System.out.println(book);
                }
            }
        }
    }
}
