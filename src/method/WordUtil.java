package method;

import java.util.ArrayList;
import java.util.List;

public class WordUtil {
     public ArrayList<Node> FindWords(List<String> words, String word, int value,ArrayList<String> parent){
        // Asumsi Setiap kata panjangnya sama
        // Mencari kata yang memiliki perbedaan 1 huruf di words
        ArrayList<Node> result = new ArrayList<>();
        for (String str : words) {
            int count = 0;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) != str.charAt(i)) {
                    count++;
                }
            }
            if (count == 1 && !parent.contains(str)) {
                Node node = new Node(str, value);
                result.add(node);
                node.setParent(parent);
            }
        }
        return result;
    }

    public boolean isWordExist(List<String> words, String word) {
        return words.contains(word);
    }
}
