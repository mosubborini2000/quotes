# quotes
Lab 8:
I Created a new repository for this  lab; called it quotes. In that repo,
I created a class Qoute have some data fields and twoString methods.
then I installed a Gson librarie then I added to dependencies:
implementation group: 'com.google.code.gson', name: 'gson', version: '2.7'
eplaination about program:
App Class (App.java):
This class contains the main logic of the application. It reads a JSON file containing an array of quotes, selects a random quote from that array, and then prints the selected quote's text and author to the console.

public static void main(String[] args): The entry point of the application. When executed, it calls the printRandomQuote() method.

public static Quote[] printRandomQuote(): This method reads a JSON file named recentquotes.json from the src/main/resources directory. It uses the Gson library to parse the JSON data into an array of Quote objects. Then, a random quote is selected from the array and its text and author information are printed to the console.

Quote Class (Quote.java):
This class defines the structure of a quote. It has fields to store information about the quote's tags, author, likes, and text.

AppTest Class (AppTest.java):
This class contains a JUnit test case for the printRandomQuote() method. The test ensures that the method successfully retrieves and prints at least one quote.

Functionality:

The program reads a JSON file (recentquotes.json) that contains an array of quotes.
It uses the Gson library to parse the JSON data into an array of Quote objects.
A random quote is selected from the array, and its text and author information are printed to the console.
The printRandomQuote() method returns the array of quotes.


## Lab 09
fetchAndUpdateQuotes(): This method is the main entry point of your application. It fetches quotes from an external API using an HTTP connection. If successful, it selects a random quote and updates a local JSON file with the new quote.
fetchQuotesFromAPI(): This method sends an HTTP GET request to the specified API endpoint using the HttpURLConnection class. It receives JSON data, converts it into a list of strings (quotes), and returns the list.
getRandomQuote(List<String> quoteList): Given a list of quotes, this method selects a random quote from the list and returns it.
updateQuotesFile(Quote newQuote): This method reads the existing quotes from a JSON file, appends a new quote, and writes the updated list back to the file.
readQuotesFromFile(): Reads and deserializes quotes from the JSON file back into an array of Quote objects.
displayRandomLocalQuote(): Reads local quotes from the JSON file and displays a random quote along with its author.