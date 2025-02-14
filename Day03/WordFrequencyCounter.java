//10. Count Words in a File

import java.io.*;
import java.util.*;

public class WordFrequencyCounter {
    
    public static void main(String[] args) {
        String fileName = "input1.txt"; // Specify the file name
        
        // Read the file and count word occurrences
        Map<String, Integer> wordCountMap = countWordsInFile(fileName);
        
        // Sort words by frequency in descending order
        List<Map.Entry<String, Integer>> sortedWordList = sortByFrequency(wordCountMap);
        
        // Display the top 5 most frequent words
        displayTopWords(sortedWordList, 5);
    }
    
    // Method to count words in the file
    private static Map<String, Integer> countWordsInFile(String fileName) {
        Map<String, Integer> wordCountMap = new HashMap<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\W+"); // Split by non-word characters
                
                for (String word : words) {
                    if (!word.isEmpty()) {
                        word = word.toLowerCase(); // Normalize to lowercase
                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return wordCountMap;
    }

    // Method to sort the word count map by frequency
    private static List<Map.Entry<String, Integer>> sortByFrequency(Map<String, Integer> wordCountMap) {
        List<Map.Entry<String, Integer>> wordList = new ArrayList<>(wordCountMap.entrySet());
        
        // Sort by value in descending order
        wordList.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));
        
        return wordList;
    }
    
    // Method to display the top N words
    private static void displayTopWords(List<Map.Entry<String, Integer>> sortedWordList, int topN) {
        System.out.println("Top " + topN + " most frequent words:");
        int count = 0;
        
        for (Map.Entry<String, Integer> entry : sortedWordList) {
            if (count >= topN) break;
            System.out.println(entry.getKey() + ": " + entry.getValue());
            count++;
        }
    }
}
