package quotes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class App {
    public static void main(String[] args) {
        fetchAndUpdateQuotes();
    }

    public static void fetchAndUpdateQuotes() {
        try {
            List<String> quoteList = fetchQuotesFromAPI();

            if (!quoteList.isEmpty()) {
                String randomQuote = getRandomQuote(quoteList);
                Quote quote = new Quote("Ron Swanson", randomQuote);
                updateQuotesFile(quote);
            }
        } catch (IOException e) {
            System.out.println("Error fetching from API: " + e.getMessage());
            displayRandomLocalQuote();
        }
    }

    public static List<String> fetchQuotesFromAPI() throws IOException {
        URL url = new URL("https://ron-swanson-quotes.herokuapp.com/v2/quotes");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        InputStreamReader reader = new InputStreamReader(connection.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(reader);
        String jsonData = bufferedReader.readLine();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return Arrays.asList(gson.fromJson(jsonData, String[].class));
    }

    public static String getRandomQuote(List<String> quoteList) {
        int randomIndex = new Random().nextInt(quoteList.size());
        return quoteList.get(randomIndex);
    }

    public static void updateQuotesFile(Quote newQuote) {
        Quote[] existingQuotes = readQuotesFromFile();
        List<Quote> updatedQuotes = new ArrayList<>(Arrays.asList(existingQuotes));
        updatedQuotes.add(newQuote);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writeToFile = new FileWriter("src/main/resources/recentquotes.json")) {
            gson.toJson(updatedQuotes, writeToFile);
        } catch (IOException e) {
            System.out.println("Error updating quotes file: " + e.getMessage());
        }
    }

    public static Quote[] readQuotesFromFile() {
        Gson gson = new Gson();
        Quote[] quotes = null;
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/recentquotes.json"))) {
            quotes = gson.fromJson(reader, Quote[].class);
        } catch (IOException e) {
            System.out.println("Error reading quotes file: " + e.getMessage());
        }
        return quotes != null ? quotes : new Quote[0];
    }

    public static void displayRandomLocalQuote() {
        Quote[] localQuotes = readQuotesFromFile();
        if (localQuotes.length > 0) {
            int randomIndex = new Random().nextInt(localQuotes.length);
            Quote randomQuote = localQuotes[randomIndex];
            System.out.println("Quote: " + randomQuote.getText());
            System.out.println("Author: " + randomQuote.getAuthor());
        } else {
            System.out.println("There are no quotes.");
        }
    }
}
