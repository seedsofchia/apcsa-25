package piglatin;

public class App {
    public static void main(String[] args) {

        /* 
        Project Overview:

        This project is setup with four main classes:
          1. App - the main application
          2. Book - a class that creates and manages book objects.
               - A Book represents a real book and stores its lines in memory.
               - Book has methods to read data in (from a string or URL)
                 and to write data out (to a file).
          3. PigLatinTranslator - a static class
               - Implements your translator logic.
               - Has two public methods:
                   - Book translate(Book input)
                   - String translate(String input)
          4. TestSuite - runs a series of automated tests on your code.
               - Helps verify correctness, like CodingBat.
        */

        // Run the test suite (optional)
        int score = TestSuite.run();

        // Only run the book translation once you’ve passed enough tests
        if (score > 4) {

            // Create a new empty book
            Book input = new Book();

            // Step 1: Start with a small test string


            // Step 2: Read a full book from a real online source (Romeo and Juliet)
            input.readFromUrl(
                "Romeo and Juliet",
                "https://www.gutenberg.org/cache/epub/2701/pg2701.txt"
            );

            // Step 3: Print the first two lines (to verify it loaded correctly)
            input.printlines(0, 2);

            // Step 4: Translate the book into Pig Latin
            Book output = PigLatinTranslator.translate(input);

            // Step 5: Print the first two translated lines as a preview
            output.printlines(0, 2);

            // Step 6: Save the translated version to a text file
            output.writeToFile("test.txt");

            System.out.println("\n Translation complete! Check your project folder for 'test.txt'.");
        } else {
            System.out.println("\n Tests not passed yet. Work on TestSuite until your score is > 4.");
        }
    }
}