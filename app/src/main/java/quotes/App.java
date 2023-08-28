package quotes;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class App {
    public static void main(String[] args) {
        printRandomQuote();
    }

    public static  Quote [] printRandomQuote() {
        Gson gson = new Gson();
        Quote[] quotes=null;
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/recentquotes.json"))) {
            quotes = gson.fromJson(reader, Quote[].class);
            if (quotes != null && quotes.length > 0) {
                int randomIndex = new Random().nextInt(quotes.length);
                Quote randomQuote = quotes[randomIndex];
                System.out.println("Quote: " + randomQuote.getText());
                System.out.println("Author: " + randomQuote.getAuthor());
            } else {
                System.out.println("There are no quotes.");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return quotes;
    }
}
