package method;

import java.util.*;

public class AStar {
    public ArrayList<Object> find(String firstword, String lastword, List<String> words){
        WordUtil util = new WordUtil();
        List<String> wordsCopy = new ArrayList<>(words);
        PriorityQueue<Node> queue = new PriorityQueue<Node>();
        Node node = new Node(firstword, 0, 1, null);

        queue.add(node);

        Node result = new Node("", 0, 0, null);

        int nodeCount = 0;
        // Algoritma A*
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
            ArrayList<Node> nextWords = util.findWordsAStar(wordsCopy, current.getWord(), val, current, lastword);
            queue.addAll(nextWords);
        }

        Long end = System.currentTimeMillis();
        Long time = end - start;

        System.out.println("Waktu eksekusi: " + time + " ms");
        float seconds = (time / 1000F);
        System.out.println("Waktu eksekusi : " + seconds + " s");
        System.out.println("Jumlah node yang dikunjungi: " + nodeCount);

        // print hasil
        ArrayList<String> resultWords = new ArrayList<>();
        Node temp = result;
        while (temp != null) {
            resultWords.add(temp.getWord());
            temp = temp.getParent();
        }
        if (resultWords.isEmpty()){
            System.out.println("Tidak ditemukan jalan");
            return null;
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
        return resultList;
    }
}
