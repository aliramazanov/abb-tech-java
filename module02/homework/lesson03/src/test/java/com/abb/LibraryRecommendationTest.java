package com.abb;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LibraryRecommendationTest {
    
    static Stream<Arguments> provideSourceForScenarios () {
        
        Book orwell1 = new Book("1984", "Orwell", 1949, 4.9, true);
        Book orwell2 = new Book("Animal Farm", "Orwell", 1945, 4.8, true);
        Book martin = new Book("Clean Code", "Martin", 2008, 4.7, true);
        Book unavailable = new Book("Unavailable", "Author", 2020, 5.0, false);
        
        return Stream.of(
                Arguments.of(
                        List.of(orwell1, orwell2, martin),
                        new User("Ali", List.of(
                                new Record(orwell1, LocalDate.now(), LocalDate.now()),
                                new Record(orwell1, LocalDate.now(), LocalDate.now()),
                                new Record(martin, LocalDate.now(), null)
                        )),
                        true,
                        "Orwell"
                ),
                Arguments.of(
                        List.of(unavailable),
                        new User("User", List.of(
                                new Record(unavailable, LocalDate.now(), LocalDate.now())
                        )),
                        false,
                        null
                ),
                Arguments.of(
                        List.of(martin, orwell1),
                        new User("Balanced", List.of(
                                new Record(martin, LocalDate.now(), LocalDate.now()),
                                new Record(orwell1, LocalDate.now(), LocalDate.now())
                        )),
                        true,
                        null
                )
        );
    }
    
    @Test
    void testEmptyBorrowHistory () {
        
        Book expectedBook = new Book("Book1", "Author", 2020, 4.5, true);
        List<Book> books = List.of(expectedBook);
        
        User user = new User("User", List.of());
        List<User> users = List.of(user);
        
        Library library = new Library(books, users);
        
        Optional<Book> actualRecommendation = library.findRecommendedBookForUser(user);
        
        assertFalse(actualRecommendation.isPresent());
    }
    
    @ParameterizedTest
    @MethodSource("provideSourceForScenarios")
    void testRecommendationScenarios (
            List<Book> books,
            User user,
            boolean shouldHaveRecommendation,
            String expectedAuthor
    ) {
       
        Library library = new Library(books, List.of(user));
        
        Optional<Book> actualRecommendation = library.findRecommendedBookForUser(user);
        
        assertEquals(shouldHaveRecommendation, actualRecommendation.isPresent());
        
        if (shouldHaveRecommendation && expectedAuthor != null) {
            String actualAuthor = actualRecommendation.get().getAuthor();
            assertEquals(expectedAuthor, actualAuthor);
        }
    }
}