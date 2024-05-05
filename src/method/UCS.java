package method;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class UCS {

    public ArrayList<String> UCS(String firstword, String lastword) {
        WordUtil util = new WordUtil();
        int len = firstword.length();
        List<String> words = new ArrayList<>();
        String fileName = "src/Data/words" + len + ".txt";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Hapus spasi ekstra jika ada
                String temp = line.trim();
                words.add(temp);
            }
        } catch (IOException e) {
            System.err.println("Gagal membaca file: " + e.getMessage());
        }

        PriorityQueue<Node> queue = new PriorityQueue<Node>();
        Node node = new Node(firstword, 0);

        queue.add(node);

        ArrayList<String> result = new ArrayList<>();

        // Algoritma UCS
        while (!queue.isEmpty()) {
            Node current = queue.remove();
            // System.out.println("Current: " + current.getWord());
            if (current.getWord().equals(lastword)) {
                break;
            }
            int val = current.getValue() + 1;
            ArrayList<String> parent = current.getParent();
            parent.add(current.getWord());
            ArrayList<Node> nextWords = util.FindWords(words, current.getWord(), val,parent);
            queue.addAll(nextWords);
        }

        result.addAll(queue.peek().getParent());
        result.add(lastword);
        return result;
    }
}
