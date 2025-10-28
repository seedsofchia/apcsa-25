package piglatin;

public class PigLatinTranslator {
    public static Book translate(Book input) {
        Book translatedBook = new Book();

        // TODO: Add code here to populate translatedBook with a translation of the
        // input book.
        // Curent do-nothing code will return an empty book.
        // Your code will need to call translate(String input) many times.

        return translatedBook;
    }

    public static String translate(String input) {
        System.out.println("  -> translate('" + input + "')");
        if (input == null || input.trim().isEmpty()) {
            return "";
        }
       Scanner scan = new Scanner(input);
       String result = "";
         while (scan.hasNext()) {
            String word = scan.next();
            if(!result.isEmpty()){
                result += " ";
            }
            result += translateWord(word);
        }
        scan.close();
        return result;
    }
    private static String transaltedWord(String word) {
        if (word.isEmpty()) return " ";
        String punctations = ".,!?";
        char lastChar = word.charAt(word.length()-1);
        if (punctations.indexOf(lastChar)!=-1);
        word = word.substring(0,word.length()-1);
    }
}
        
        // TODO: translate a string input, store in result.
        // The input to this function could be any English string.
        // It may be made up of many words.
        // This method must call translateWord once for each word in the string.
       
    }

    private static String translateWord(String input) {
        System.out.println("  -> translateWord('" + input + "')");

        String result = "";

        // TODO: Replace this code to correctly translate a single word.
        // Start here first!
        // This is the first place to work.
        result = input; // delete this line

        return result;
    }

    // Add additonal private methods here.
    // For example, I had one like this:
    // private static String capitalizeFirstLetter(String input)

}
