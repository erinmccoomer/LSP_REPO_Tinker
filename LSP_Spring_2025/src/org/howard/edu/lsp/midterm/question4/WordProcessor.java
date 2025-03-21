package org.howard.edu.lsp.midterm.question4;

import java.util.ArrayList;
import java.util.List;

public class WordProcessor {
    private String sentence; // Stores the sentence to be processed

    /**
     * Constructor to initialize the sentence.
     *
     * @param sentence The sentence to be processed.
     */
    public WordProcessor(String sentence) {
        this.sentence = sentence;
    }

    /**
     * Method to find all longest words in the sentence.
     *
     * @return A list of the longest words in the sentence, in the order they appear.
     *         If the sentence is empty or contains no words, returns an empty list.
     */
    public List<String> findLongestWords() {
        // Trim any leading/trailing whitespace and split by spaces
        String[] words = sentence.trim().split("\\s+");
        List<String> longestWords = new ArrayList<>();
        int maxLength = 0;

        // Iterate through the words to find the longest ones
        for (String word : words) {
            if (word.length() > maxLength) {
                // Found a new longest word, update maxLength and reset list
                maxLength = word.length();
                longestWords.clear();
                longestWords.add(word);
            } else if (word.length() == maxLength) {
                // Found another word with the same max length, add it to the list
                longestWords.add(word);
            }
        }

        return longestWords; // Return the list of longest words
    }
}
