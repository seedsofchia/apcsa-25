package piglatin;

import java.io.*;
import java.net.*;
import java.util.*;

public class Book {
    private String title;
    private ArrayList<String> text = new ArrayList<String>();

    // Default constructor
    Book() { }

    // Prints a range of lines (used in App.java)
    public void printlines(int start, int length) {
        System.out.println("\nLines " + start + " to " + (start + length - 1) + " of book: " + title);
        for (int i = start; i < start + length; i++) {
            if (i < text.size()) {
                System.out.println(i + ": " + text.get(i));
            } else {
                System.out.println(i + ": line not in book.");
            }
        }
    }

    // Basic getters and setters
    String getTitle() { return title; }
    void setTitle(String title) { this.title = title; }
    String getLine(int lineNumber) { return text.get(lineNumber); }
    int getLineCount() { return text.size(); }
    void appendLine(String line) { text.add(line); }

    // Reads book content from a raw string
    public void readFromString(String title, String string) {
        this.title = title;
        text.clear();
        Scanner scanner = new Scanner(string);
        while (scanner.hasNextLine()) {
            text.add(scanner.nextLine());
        }
        scanner.close();
        System.out.println("Loaded " + text.size() + " lines from string \"" + title + "\".");
    }

    // Reads a book from a URL (ex: Gutenberg)
    public void readFromUrl(String title, String url) {
        this.title = title;
        text.clear();
        System.out.println("\n Downloading book from URL: " + url);

        try {
            URL bookUrl = new URL(url);
            BufferedReader reader = new BufferedReader(new InputStreamReader(bookUrl.openStream(), "UTF-8"));

            String line;
            int count = 0;
            while ((line = reader.readLine()) != null) {
                text.add(line);
                count++;
                // Print the first 2 lines as a preview
                if (count <= 2) {
                    System.out.println("→ line " + count + ": " + line);
                }
            }
            reader.close();
            System.out.println("Successfully loaded " + text.size() + " lines from \"" + title + "\".");
        } catch (IOException e) {
            System.out.println("Error loading from URL: " + e.getMessage());
        }
    }

    // Writes book content to a .txt file
    void writeToFile(String filename) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(filename));
            for (String line : text) {
                writer.println(line);
            }
            writer.close();
            System.out.println(" Saved book \"" + title + "\" to file: " + filename);
            System.out.println(" Path: " + new File(filename).getAbsolutePath());
        } catch (IOException e) {
            System.out.println(" Error writing file: " + e.getMessage());
        }
    }
}
