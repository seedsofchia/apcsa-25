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
     
    
    if(word.contains("-")){
        Scanner hyphenScan = new Scanner(word);
        hyphenScan.useDelimiter("-");
        String translated = "";
        while (hyphenScan.hasNext()){
            String part = hyphenScan.next();
            if(!translated.isEmpty()) translated += "-";
            translated += translateWord(part);
        }
        hyphenScan.close();
        result = translated + punctuation;
        return result;
}
    if (word.isEmpty()) return punctuations;
    

    String lowerCase = word.toLowerCase();
    String translated;
if (startsWithVowel(lowerCase)){
    translated = lowerCase + "ay";
} else {
    int vowelIndex = firstVowelIndex(lowerCase);
    if (vowelIndex == -1){
        translated = lowerCase + "ay";
    } else {
        String start = lowerCase.substring(0, vowelIndex);
        String end = lowerCase.substring(vowelIndex);
        translated = end + start + "ay";

    }
}
    boolean isCapitalized = Character.isUpperCase(word.charAt(0));  
    if (isCapitalized && translated.length() > 0){
        translated = translated.substring(0,1).toUpperCase() + translated.substring(1);
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
    



