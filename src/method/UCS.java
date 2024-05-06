package method;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class UCS {

    public ArrayList<Object> find(String firstword, String lastword, List<String> words) {
        WordUtil util = new WordUtil();
        List<String> wordsCopy = new ArrayList<>(words);
        PriorityQueue<Node> queue = new PriorityQueue<Node>();
        Node node = new Node(firstword, 0,1, null);

        queue.add(node);

        Node result = new Node("", 0, 0, null);

        int nodeCount = 0;
        // Algoritma UCS
        Long start = System.currentTimeMillis();
        while (!queue.isEmpty()) {
            Node current = queue.remove();
            wordsCopy.remove(current.getWord());
            nodeCount++;
            if (current.getWord().equals(lastword)) {
                result = current;
                break;
            }
            int val = current.getValue() + 1;
            ArrayList<Node> nextWords = util.findWordsUCS(wordsCopy, current.getWord(), val, current);
            queue.addAll(nextWords);
        }
        if (queue.isEmpty()){
            System.out.println("Tidak ditemukan jalan");
            return null;
        }


        Long end = System.currentTimeMillis();
        Long time = end - start;

        // Menghitung besar memori
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        long memory = runtime.totalMemory() - runtime.freeMemory();
        
        System.out.println("Waktu eksekusi: " + time + " ms");
        float seconds = (time / 1000F);
        System.out.println("Waktu eksekusi : " + seconds + " s");
        System.out.println("Jumlah node yang dikunjungi: " + nodeCount);
        System.out.println("Memori yang digunakan: " + memory + " bytes");

        // print hasil
        ArrayList<String> resultWords = new ArrayList<>();
        Node temp = result;
        while (temp != null) {
            resultWords.add(temp.getWord());
            temp = temp.getParent();
        }

        for (int i = resultWords.size() - 1; i >= 0; i--) {
            if (i == 0) {
                System.out.print(resultWords.get(i));
            } else {
                System.out.print(resultWords.get(i) + " -> ");
            }
        }

        ArrayList<Object> resultList = new ArrayList<>();
        resultList.add(result);
        resultList.add(time);
        resultList.add(nodeCount);
        resultList.add(memory);
        return resultList;


    }
}
