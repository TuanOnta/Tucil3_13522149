package method;

public class Node implements Comparable<Node> { 
    private String word;
    private int len;
    private int value;
    private int age;
    private Node parent;

    // Constructor
    public Node(String word, int value, int age, Node parent) {
        this.word = word;
        this.len = word.length();
        this.parent = parent;
        this.value = value;
        this.age = age;
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

    public int getAge() {
        return age;
    }

    public Node getParent() {
        return parent;
    }

    // Setter
    public void setWord(String word) {
        this.word = word;
        this.len = word.length();
    }
    public void setParent(Node parent) {
        this.parent = parent;
    }
    public void setValue(int value) {
        this.value = value;
    }

    // Menambahkan value    
    public void addValue() {
        this.value ++;
    }

    // Menambah age
    public void addAge() {
        this.age ++;
    }
    

    // Apakah parent kosong
    public void isParentEmpty() {
        if (this.parent == null) {
            System.out.println("Parent kosong");
        } else {
            System.out.println("Parent tidak kosong");
        }
    }

    @Override
    public int compareTo(Node node) {
       if (this.value < node.value) {
           return -1;
        } else if (this.value > node.value) {
            return 1;
        } else if (this.age < node.age) {
            return -1;
        }else if(this.age > node.age){
            return 1;
        }else{
            return 0;
         }
    }

}
