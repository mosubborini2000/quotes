package quotes;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void fetchQuotesFromAPI() {
        try {
            List<String> quotes = App.fetchQuotesFromAPI();
            assertNotNull(quotes);
            assertFalse(quotes.isEmpty());
        } catch (IOException e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void getRandomQuote() {
        List<String> quoteList = List.of("Quote 1", "Quote 2", "Quote 3");
        String randomQuote = App.getRandomQuote(quoteList);
        assertTrue(quoteList.contains(randomQuote));
    }

    @Test
    void readQuotesFromFile() {
        Quote[] quotes = App.readQuotesFromFile();
        assertNotNull(quotes);
    }

    @Test
    void fetchAndUpdateQuotes() {
        App.fetchAndUpdateQuotes();
        Quote[] updatedQuotes = App.readQuotesFromFile();
        assertTrue(updatedQuotes.length > 0);
    }

    @Test
    void displayRandomLocalQuote() {
        App.displayRandomLocalQuote();
    }
}
