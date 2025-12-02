package com.abb;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LibrarySortingTest {
    
    private List<Book> books;
    private Library library;
    
    @BeforeEach
    void setUp () {
        books = new ArrayList<>();
    }
    
    @Test
    void testBookSorting () {
        
        Book b1 = new Book("1984", "George Orwell", 1949, 4.9, true);
        Book b2 = new Book("Animal Farm", "George Orwell", 1945, 4.8, false);
        Book b3 = new Book("Clean Code", "Robert Martin", 2008, 4.7, true);
        Book b4 = new Book("Effective Java", "Joshua Bloch", 2018, 4.9, true);
        
        books.addAll(List.of(b1, b2, b3, b4));
        library = new Library(books, List.of());
        
        library.sortBooks();
        
        assertEquals("1984", books.get(0).getTitle());
        assertEquals("Effective Java", books.get(1).getTitle());
        assertEquals("Animal Farm", books.get(2).getTitle());
        assertEquals("Clean Code", books.get(3).getTitle());
    }
    
    @Test
    void testSortingWithEqualRatings () {
        
        Book a = new Book("A Book", "Author", 2010, 4.5, true);
        Book b = new Book("B Book", "Author", 2010, 4.5, true);
        Book c = new Book("C Book", "Author", 2005, 4.5, true);
        
        books.addAll(List.of(b, a, c));
        library = new Library(books, List.of());
        
        library.sortBooks();
        
        assertEquals("C Book", books.get(0).getTitle());
        assertEquals("A Book", books.get(1).getTitle());
        assertEquals("B Book", books.get(2).getTitle());
    }
    
    @Test
    void testSortingByRatingDescending () {
        
        Book low = new Book("Low", "Author", 2020, 3.0, true);
        Book medium = new Book("Medium", "Author", 2020, 4.0, true);
        Book high = new Book("High", "Author", 2020, 5.0, true);
        
        books.addAll(List.of(low, high, medium));
        library = new Library(books, List.of());
        
        library.sortBooks();
        
        assertEquals("High", books.get(0).getTitle());
        assertEquals("Medium", books.get(1).getTitle());
        assertEquals("Low", books.get(2).getTitle());
    }
    
    @Test
    void testSortingByYearAscending () {
        
        Book new1 = new Book("New", "Author", 2020, 4.5, true);
        Book old = new Book("Old", "Author", 2000, 4.5, true);
        Book middle = new Book("Middle", "Author", 2010, 4.5, true);
        
        books.addAll(List.of(new1, old, middle));
        library = new Library(books, List.of());
        
        library.sortBooks();
        
        assertEquals("Old", books.get(0).getTitle());
        assertEquals("Middle", books.get(1).getTitle());
        assertEquals("New", books.get(2).getTitle());
    }
    
    @Test
    void testSingleBook () {
        
        books.add(new Book("Solo", "Author", 2020, 4.5, true));
        library = new Library(books, List.of());
        
        library.sortBooks();
        
        assertEquals(1, books.size());
        assertEquals("Solo", books.getFirst().getTitle());
    }
}