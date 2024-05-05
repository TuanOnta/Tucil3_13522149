package method;

import java.util.ArrayList;

public class Node implements Comparable<Node> { 
    private String word;
    private int len;
    private int value;
    private ArrayList<String> parent;

    // Constructor
    public Node(String word, int value) {
        this.word = word;
        this.len = word.length();
        this.parent = new ArrayList<String>();
        this.value = value;
    }

    // Getter
    public String getWord() {
        return word;
    }
    public int getLen() {
        return len;
    }
    public int getValue() {
        return value;
    }
    public ArrayList<String> getParent() {
        return parent;
    }

    // Setter
    public void setWord(String word) {
        this.word = word;
        this.len = word.length();
    }
    public void setParent(ArrayList<String> parent) {
        this.parent = new ArrayList<>(parent);
    }
    public void setValue(int value) {
        this.value = value;
    }

    // Menambahkan value    
    public void addValue() {
        this.value ++;
    }
    
    // Menambahkan parent
    public void addParent(String parent) {
        this.parent.add(parent);
    }

    // Menghapus parent
    public void removeParent(String parent) {
        this.parent.remove(parent);
    }

    // Apakah parent kosong
    public void isParentEmpty() {
        if (this.parent.isEmpty()) {
            System.out.println("Parent kosong");
        } else {
            System.out.println("Parent tidak kosong");
        }
    }

    // Apakah parent mengandung kata tertentu
    public boolean isParentContains(String parent) {
        return this.parent.contains(parent);
    }

    @Override
    public int compareTo(Node node) {
       if (this.value < node.value) {
           return -1;
       } else if (this.value > node.value) {
           return 1;
       } else {
           return 0;
       }
    }

}
