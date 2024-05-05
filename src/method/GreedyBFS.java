package method;

import java.util.*;

public class GreedyBFS {
    public ArrayList<Object> find(String firstword, String lastword, List<String> words) {
        WordUtil util = new WordUtil();
        List<String> wordsCopy = new ArrayList<>(words);

        Node root = new Node(firstword, 0, 1, null); //value pada node pertama tidak digunakan
        

        // Algoritma Greedy BFS
        int nodeCount = 1;
        Long start = System.currentTimeMillis();
        PriorityQueue<Node> tempQueue = new PriorityQueue<Node>();
        tempQueue = util.findWordGreedyBFS(wordsCopy, firstword, root, lastword);
        Node current = tempQueue.poll();
        nodeCount += tempQueue.size();
        while (!tempQueue.isEmpty() && !current.getWord().equals(lastword)){
            // System.out.println(current.getWord());
            wordsCopy.remove(current.getWord());

            tempQueue = util.findWordGreedyBFS(wordsCopy, current.getWord(), current, lastword);
            current = tempQueue.poll();
            nodeCount += tempQueue.size();
        }
        if (tempQueue.isEmpty()){
            System.out.println("Tidak ditemukan jalan");
            return null;
        }

        Long end = System.currentTimeMillis();
        Long time = end - start;

        System.out.println("Waktu eksekusi: " + time + " ms");
        float seconds = (time / 1000F);
        System.out.println("Waktu eksekusi : " + seconds + " s");
        System.out.println("Jumlah node yang dikunjungi: " + nodeCount);

        // print hasil
        ArrayList<String> resultWords = new ArrayList<>();
        Node temp = current;
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
        resultList.add(current);
        resultList.add(time);
        resultList.add(nodeCount);
        return resultList;
        
    }
}
