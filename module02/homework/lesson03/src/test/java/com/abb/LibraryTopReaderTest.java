package com.abb;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTopReaderTest {
    
    @Test
    void testTopReaderWithClearWinner() {
       
        Optional<User> actualTopReader = getUser();
        String expectedWinnerName = "Leyla";
        
        assertAll("Top reader",
                  () -> assertTrue(actualTopReader.isPresent(), "Top reader should exist"),
                  () -> assertNotNull(actualTopReader.get(), "Top reader should not be null"),
                  
                  () -> assertEquals(
                          expectedWinnerName,
                          actualTopReader.get().getName(),
                          "Winner should be Leyla"
                  ),
                  
                  () -> assertNotEquals(
                          "Ali",
                          actualTopReader.get().getName(),
                          "Winner should not be Ali"
                  )
        );
    }
    
    private static Optional<User> getUser () {
       
        Book b1 = new Book("Book1", "Author", 2020, 4.5, true);
        Book b2 = new Book("Book2", "Author", 2020, 4.5, true);
        Book b3 = new Book("Book3", "Author", 2020, 4.5, true);
        
        User user1 = new User("Ali", List.of(
                new Record(b1, LocalDate.of(2025, 10, 1), null)
        ));
        
        User user2 = new User("Leyla", List.of(
                new Record(b2, LocalDate.of(2025, 10, 5), null),
                new Record(b3, LocalDate.of(2025, 10, 10), null)
        ));
        
        Library library = new Library(List.of(b1, b2, b3), List.of(user1, user2));
        
        return library.findTopReaderOfMonth(10, 2025);
    }
    
    @Test
    void testTopReaderWithTie() {
        
        Optional<User> actualTopReader = getOptionalUser();
        String actualWinnerName = actualTopReader.get().getName();
        
        assertAll("Tie",
                  () -> assertNotNull(actualWinnerName),
                  () -> assertTrue(
                          actualWinnerName.equals("Ali") || actualWinnerName.equals("Murad"),
                          "Winner should be either Ali or Murad"
                  )
        );
    }
    
    private static Optional<User> getOptionalUser () {
       
        Book b1 = new Book("Book1", "Author", 2020, 4.5, true);
        Book b2 = new Book("Book2", "Author", 2020, 4.5, true);
        
        User user1 = new User("Ali", List.of(
                new Record(b1, LocalDate.of(2025, 9, 1), null)
        ));
        
        User user2 = new User("Murad", List.of(
                new Record(b2, LocalDate.of(2025, 9, 5), null)
        ));
        
        Library library = new Library(List.of(b1, b2), List.of(user1, user2));
        
        Optional<User> actualTopReader;
        actualTopReader = library.findTopReaderOfMonth(9, 2025);
        return actualTopReader;
    }
    
    @Test
    void testNoBorrowsInMonth() {
       
        Book book = new Book("Book", "Author", 2020, 4.5, true);
      
        User user = new User("Ali", List.of(
                new Record(book, LocalDate.of(2025, 10, 1), null)
        ));
        
        Library library = new Library(List.of(book), List.of(user));
        
        Optional<User> actualTopReader = library.findTopReaderOfMonth(12, 2025);
        
        assertAll("No borrows scenario",
                  () -> assertFalse(actualTopReader.isPresent(), "No top reader"),
                  () -> assertThrows(
                          Exception.class,
                          () -> actualTopReader.get(),
                          "Getting value from empty Optional throws"
                  )
        );
    }
    
    @Test
    void testOnlyCountsSpecifiedMonth() {
        
        Book b1 = new Book("Book1", "Author", 2020, 4.5, true);
        Book b2 = new Book("Book2", "Author", 2020, 4.5, true);
        
        User user = new User("Ali", List.of(
                new Record(b1, LocalDate.of(2024, 10, 1), null),
                new Record(b2, LocalDate.of(2025, 9, 1), null)
        ));
        
        Library library = new Library(List.of(b1, b2), List.of(user));
        
        Optional<User> actualSept2025 = library.findTopReaderOfMonth(9, 2025);
        Optional<User> actualOct2024 = library.findTopReaderOfMonth(10, 2024);
        Optional<User> actualOct2025 = library.findTopReaderOfMonth(10, 2025);
        
        assertAll("Multiple months checks",
                  () -> assertTrue(actualSept2025.isPresent(), "Sept 2025 should have reader"),
                  () -> assertTrue(actualOct2024.isPresent(), "Oct 2024 should have reader"),
                  () -> assertFalse(actualOct2025.isPresent(), "Oct 2025 should have no reader"),
               
                  () -> assertSame(
                          user,
                          actualSept2025.get(),
                          "Should be the same user instance"
                  ),
               
                  () -> assertNotSame(
                          actualSept2025,
                          actualOct2024,
                          "Should be different Optional instances"
                  )
        );
    }
    
    @Test
    void testLibraryThrowsExceptionForInvalidMonth() {
        
        Book book = new Book("Book", "Author", 2020, 4.5, true);
        User user = new User("Ali", List.of());
        Library library = new Library(List.of(book), List.of(user));
        
        assertDoesNotThrow(() -> library.findTopReaderOfMonth(10, 2025),
                           "Valid month should not throw");
    }
}