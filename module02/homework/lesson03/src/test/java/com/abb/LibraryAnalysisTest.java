package com.abb;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class LibraryAnalysisTest {
    
    @Test
    void testAverageRating () {
        
        List<Book> books = Arrays.asList(
                new Book("Book1", "Author", 2020, 4.5, true),
                new Book("Book2", "Author", 2020, 5.0, true)
        );
        
        double avg = books
                .stream()
                .mapToDouble(Book::getRating)
                .average()
                .orElse(0.0);
        
        assertEquals(4.75, avg, 0.001);
    }
    
    @Test
    void testAvailableBooksAfter2000 () {
        
        List<Book> books = Arrays.asList(
                new Book("Old", "Author", 1999, 4.5, true),
                new Book("New", "Author", 2020, 4.5, true),
                new Book("Unavailable", "Author", 2021, 4.5, false)
        );
        
        List<Book> result = books
                .stream()
                .filter(b -> b.getYear() > 2000 && b.isAvailable())
                .toList();
        
        assertEquals(1, result.size());
        assertEquals("New", result.get(0).getTitle());
    }
    
    @Test
    void testCurrentlyReadingBooks () {
        
        Book b1 = new Book("Book1", "Author", 2020, 4.5, true);
        Book b2 = new Book("Book2", "Author", 2020, 4.5, true);
        
        User user = new User("Ali", Arrays.asList(
                new Record(b1, LocalDate.now(), LocalDate.now()),
                new Record(b2, LocalDate.now(), null)
        ));
        
        List<Book> currentlyReading = user.getBorrowHistory()
                .stream()
                .filter(r -> r.getReturnedDate() == null)
                .map(Record::getBook)
                .toList();
        
        assertEquals(1, currentlyReading.size());
        assertEquals("Book2", currentlyReading.get(0).getTitle());
    }
    
    @Test
    void testUniqueAuthorsRead () {
        
        Book b1 = new Book("Book1", "Orwell", 2020, 4.5, true);
        Book b2 = new Book("Book2", "Martin", 2020, 4.5, true);
        Book b3 = new Book("Book3", "Orwell", 2020, 4.5, true);
        
        User user = new User("Ali", Arrays.asList(
                new Record(b1, LocalDate.now(), null),
                new Record(b2, LocalDate.now(), null),
                new Record(b3, LocalDate.now(), null)
        ));
        
        Set<String> authors = user.getBorrowHistory()
                .stream()
                .map(r -> r.getBook().getAuthor())
                .collect(Collectors.toSet());
        
        assertEquals(2, authors.size());
        assertTrue(authors.contains("Orwell"));
        assertTrue(authors.contains("Martin"));
    }
}