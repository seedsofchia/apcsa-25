package piglatin;
import java.util.Scanner;

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
    private static String translateWord(String word) {
        if (word.isEmpty()) return " ";
        String result = "";
         // TODO: Replace this code to correctly translate a single word.
        // Start here first!
        // This is the first place to work.
        String punctuation = "";
        String punctuations = ".!,?;:'\"()[]{}";

        char lastChar = word.charAt(word.length()-1);
        if (punctuations.indexOf(lastChar) !=-1){
            punctuation = String.valueOf(lastChar);
            word = word.substring(0, word.length()-1);
        }
     
    


    if (word.isEmpty()) return punctuation;

    boolean isCapitalized = Character.isUpperCase(word.charAt(0));
    String lowerCase = word.toLowerCase();
    String translated;
    

    int vowelIndex = firstVowelIndex(lowerCase);
    if (vowelIndex == 0){
        translated = lowerCase + "ay";
    } else if (vowelIndex > 0){
        translated = lowerCase.substring(vowelIndex) + lowerCase.substring(0, vowelIndex) + "ay";
    } else {
        translated = lowerCase + "ay";

    }

    if(isCapitalized && translated.length() > 0){
        translated = translated.substring(0,1).toUpperCase()+translated.substring(1);
        }
        for (int i = 1; i < word.length(); i++){
    char origChar = word.charAt(i);
    if(Character.isUpperCase(origChar)){
        // Find where this character from position i ended up
        char lowerOrigChar = Character.toLowerCase(origChar);
        
        // Calculate where character at position i moved to
        int newPosition;
        if (vowelIndex == 0) {
            // Vowel at start: positions stay the same, just add "ay" at end
            newPosition = i;
        } else if (vowelIndex > 0) {
            // Characters before vowelIndex moved to the end (before "ay")
            if (i < vowelIndex) {
                newPosition = translated.length() - 2 - vowelIndex + i;
            } else {
                newPosition = i - vowelIndex;
            }
        } else {
            // No vowel: positions stay the same
            newPosition = i;
        }
        
        if (newPosition >= 0 && newPosition < translated.length()) {
            translated = translated.substring(0, newPosition) 
                       + Character.toUpperCase(translated.charAt(newPosition))
                       + translated.substring(newPosition + 1);
            }
        }
    }
      
        result = translated + punctuation;
        return result;
}
        
        // TODO: translate a string input, store in result.
        // The input to this function could be any English string.
        // It may be made up of many words.
        // This method must call translateWord once for each word in the string.
       
    
    private static boolean startsWithVowel(String word) {
        return word.matches ("^[aeiouAEIOU].*");
    }
    private static int firstVowelIndex(String word){
        for (int i = 0; i < word.length(); i++){
            if ("aeiouAEIOU".indexOf(word.charAt(i))!=-1){
                return i;
            }
        }
        return -1;
    }
}

    



