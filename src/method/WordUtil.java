package method;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class WordUtil {
    public ArrayList<Node> findWordsUCS(List<String> words, String word, int value, Node parent) {
        ArrayList<Node> result = new ArrayList<>();
        int len = word.length();
        HashSet<String> wordSet = new HashSet<>(words); // Membuat HashSet untuk pencarian yang lebih cepat
        int age = 0;
        for (int i = 0; i < len; i++) {
            char originalChar = word.charAt(i);
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == originalChar) {
                    continue;
                }
                StringBuilder sb = new StringBuilder(word);
                sb.setCharAt(i, c);
                String newWord = sb.toString();
                if (wordSet.contains(newWord)) {
                    age++;
                    Node node = new Node(newWord, value, age,parent);
                    result.add(node);
                }
            }
        }
        return result;
    }

    public ArrayList<Node> findWordsAStar(List<String> words, String word, int value, Node parent, String lastword) {
        ArrayList<Node> result = new ArrayList<>();
        int len = word.length();
        HashSet<String> wordSet = new HashSet<>(words); // Membuat HashSet untuk pencarian yang lebih cepat
        int age = 0;
        for (int i = 0; i < len; i++) {
            char originalChar = word.charAt(i);
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == originalChar) {
                    continue;
                }
                StringBuilder sb = new StringBuilder(word);
                sb.setCharAt(i, c);
                String newWord = sb.toString();
                if (wordSet.contains(newWord)) {
                    age++;
                    Node node = new Node(newWord, value, age, parent);
                    // find heuristic
                    int heuristic = lastword.length() - 1;
                    for (int j = 0; j < len; j++) {
                        if (newWord.charAt(j) == lastword.charAt(j)) {
                            heuristic--;
                        }
                    }
                    node.setValue(heuristic + value);
                    result.add(node);
                }
            }
        }
        return result;
    }

    public PriorityQueue<Node> findWordGreedyBFS(List<String> words, String word, Node parent, String lastword) {
        PriorityQueue<Node> resultQueue = new PriorityQueue<Node>();
        int len = word.length();
        ArrayList<String> wordSet = new ArrayList<String>(words); // Membuat HashSet untuk pencarian yang lebih cepat
        int age = 0;
        for (int i = 0; i < len; i++) {
            char originalChar = word.charAt(i);
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == originalChar) {
                    continue;
                }
                StringBuilder sb = new StringBuilder(word);
                sb.setCharAt(i, c);
                String newWord = sb.toString();
                if (wordSet.contains(newWord)) {
                    age++;
                    Node node = new Node(newWord, 0, age, parent);
                    // find heuristic
                    int heuristic = lastword.length() - 1;
                    for (int j = 0; j < len; j++) {
                        if (newWord.charAt(j) == lastword.charAt(j)) {
                            heuristic--;
                        }
                    }
                    node.setValue(heuristic);
                    resultQueue.add(node);
                }
            }
        }
        return resultQueue;
    }

    public boolean isValid(String word, List<String> words) {
        return words.contains(word);
    }
}
