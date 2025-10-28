package piglatin;
import java.util.Scanner;

public class PigLatinTranslator {

    public static Book translate(Book input) {
        Book translatedBook = new Book();
        translatedBook.setTitle(input.getTitle() + " (Pig Latin)");

        // 🔹 Loop through every line in the book and translate it
        for (int i = 0; i < input.getLineCount(); i++) {
            String line = input.getLine(i);
            String translatedLine = translate(line);
            translatedBook.appendLine(translatedLine);
        }

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
            if (!result.isEmpty()) {
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
        String punctuation = "";
        String punctuations = ".!,?;:'\"()[]{}";

        char lastChar = word.charAt(word.length() - 1);
        if (punctuations.indexOf(lastChar) != -1) {
            punctuation = String.valueOf(lastChar);
            word = word.substring(0, word.length() - 1);
        }

        if (word.isEmpty()) return punctuation;

        boolean isCapitalized = Character.isUpperCase(word.charAt(0));
        String lowerCase = word.toLowerCase();
        String translated;

        int vowelIndex = firstVowelIndex(lowerCase);
        if (vowelIndex == 0) {
            translated = lowerCase + "ay";
        } else if (vowelIndex > 0) {
            translated = lowerCase.substring(vowelIndex) + lowerCase.substring(0, vowelIndex) + "ay";
        } else {
            translated = lowerCase + "ay";
        }

        if (isCapitalized && translated.length() > 0) {
            translated = translated.substring(0, 1).toUpperCase() + translated.substring(1);
        }

        for (int i = 1; i < word.length(); i++) {
            char origChar = word.charAt(i);
            if (Character.isUpperCase(origChar)) {
                char lowerOrigChar = Character.toLowerCase(origChar);
                int newPosition;
                if (vowelIndex == 0) {
                    newPosition = i;
                } else if (vowelIndex > 0) {
                    if (i < vowelIndex) {
                        newPosition = translated.length() - 2 - vowelIndex + i;
                    } else {
                        newPosition = i - vowelIndex;
                    }
                } else {
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

    private static boolean startsWithVowel(String word) {
        return word.matches("^[aeiouAEIOU].*");
    }

    private static int firstVowelIndex(String word) {
        for (int i = 0; i < word.length(); i++) {
            if ("aeiouAEIOU".indexOf(word.charAt(i)) != -1) {
                return i;
            }
        }
        return -1;
    }
}
