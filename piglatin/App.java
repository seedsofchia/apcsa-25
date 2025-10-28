package piglatin;

public class App {
    public static void main(String[] args)
    {
        /*  Introduction and TODO List

        This project is setup with four main classes:
            1. App - the main application
            2. Book - a class that creates the basic book objects.
                - a Book contains a representation of a real book.
                - Book has methods to read data in from various sources
                - Book also has methods to read data out.
            3. PigLatinTranslator - a static class
                - Used to implement your translator.
                - Has two public methods to take input and return a translated copy.
                    - Book translate(Book input)
                    - String translate(String input)
            4. TestSuite - a simple class that helps you test your work.
                - Just like CodingBat this class tries your code against various cases.
                - It will tell you which cases return expected output or not
         */

        // Run tests, comment out once they pass.
        int score = TestSuite.run();

        // Focus on TestSuite until you get a score of 5 or higher.
        if (score > 4)
        {
            // Starter book
            Book input = new Book();

            // Start with a "test" book based on a string.
            input.readFromString("TestBook", "Dog\nCat\nMouse");

            // ✅ Example reading from a real URL (Romeo and Juliet)
            input.readFromUrl(
                "Romeo and Juliet",
                "https://www.gutenberg.org/cache/epub/1513/pg1513.txt"
            );

            // Show first few lines before and after translation
            input.printlines(0, 2);
            Book output = PigLatinTranslator.translate(input);
            output.printlines(0, 2);

            // Save translated text to file
            output.writeToFile("test.txt");
        }
    }
}
