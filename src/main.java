import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import scraping_dictionary.Scraping;
import method.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Selamat datang di program Word Ladder Solver!!");
        
        System.out.print("Apakah anda ingin mengambil data dari dictionary lain? (y/n) : ");

        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();

        boolean flag = true;
        while (flag){
            if (answer.equals("y")){
                System.out.print("Masukkan nama dictionary yang ingin diambil datanya: ");
                String dictionary_name = scanner.nextLine();
                Scraping.scraping(dictionary_name);
                flag = false;
            } else if (answer.equals("n")){
                System.out.println("Kita akan menggunakan data dari dictionary yang sudah ada");
                flag = false;
            } else {
                System.out.print("Input tidak valid, silahkan masukkan y atau n : ");
                answer = scanner.nextLine();
            }
        }

        String firstword = "";
        String lastword = "";
        
        // Membaca kata awal
        flag = true;
        while (flag) {
            System.out.print("Masukkan kata awal: ");
            firstword = scanner.nextLine();
            firstword = firstword.toLowerCase();
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
    
            if (!words.contains(firstword)){
                System.out.println("Kata awal tidak ada di dictionary");
            }else{
                flag = false;
            }
        }

        // Membaca file kata-kata
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


        // Membaca kata akhir
        flag = true;
        while(flag){
            System.out.print("Masukkan kata akhir: ");
            lastword = scanner.nextLine();
            lastword = lastword.toLowerCase();
            if(lastword.length() != firstword.length()){
                System.out.println("Kata awal dan kata akhir harus memiliki panjang yang sama");
            }else if(!words.contains(lastword)){
                System.out.println("Kata akhir tidak ada di dictionary");
            }else{
                flag = false;
            }
        }

        System.out.println("Kata awal: " + firstword);
        System.out.println("Kata akhir: " + lastword);

        // Algortima UCS
        UCS ucs = new UCS();
        System.out.println("\nAlgortima UCS");
        ArrayList<Object> ListUCS = ucs.find(firstword, lastword, words);
        if(ListUCS == null){
            ListUCS = new ArrayList<Object>();
            ListUCS.add("Tidak ditemukan jalan");
        }
        

        // Algortima GreedyBFS
        GreedyBFS greedyBFS = new GreedyBFS();
        System.out.println("\n\nAlgortima GreedyBFS");
        ArrayList<Object> ListGreedyBFS = greedyBFS.find(firstword, lastword, words);
        if(ListGreedyBFS == null){
            ListGreedyBFS = new ArrayList<Object>();
            ListGreedyBFS.add("Tidak ditemukan jalan");
        }

        // Algortima A*
        AStar AStar = new AStar();
        System.out.println("\n\nAlgortima A*");
        ArrayList<Object> ListAStar = AStar.find(firstword, lastword, words);
        if(ListAStar == null){
            ListAStar = new ArrayList<Object>();
            ListAStar.add("Tidak ditemukan jalan");
        }



        // Menyimpan solusis
        System.out.print("\nApakah anda ingin menyimpan solusi?(y/n) : ");
        answer = scanner.nextLine();
        flag = true;
        while (flag){
            if (answer.equals("y")){
                flag = false;
            } else if (answer.equals("n")){
                flag = false;
            } else {
                System.out.print("Input tidak valid, silahkan masukkan y atau n : ");
                answer = scanner.nextLine();
            }
        }

        // Menyimpan solusi
        if(answer.equals("y")){
            System.out.print("Masukkan nama file test (tanpa .txt): ");
            String filename = scanner.nextLine();
            System.out.println("Solusi akan disimpan di test/");
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("test/" + filename + ".txt"))) {

                writer.write("Kata awal: " + firstword);
                writer.newLine();
                writer.write("Kata akhir: " + lastword);
                writer.newLine();

                // Menyimpan solusi UCS
                writer.write("\nAlgortima UCS");
                writer.newLine();

                if (ListUCS.get(0) instanceof String) {
                    writer.write("Tidak ditemukan jalan");
                    writer.newLine();
                } else {
                    ArrayList<String> resultWords = new ArrayList<>();
                    Node temp = (Node) ListUCS.get(0);
                    while (temp != null) {
                        resultWords.add(temp.getWord());
                        temp = temp.getParent();
                    }

                    Long time = (Long) ListUCS.get(1);
                    writer.write("Waktu eksekusi: " + time + " ms");
                    writer.newLine();
                    float seconds = (time / 1000F);
                    writer.write("Waktu eksekusi : " + seconds + " s");
                    writer.newLine();

                    int nodeCount = (int) ListUCS.get(2);
                    writer.write("Jumlah node yang dikunjungi: " + nodeCount);
                    writer.newLine();

                    for (int i = resultWords.size() - 1; i >= 0; i--) {
                        if (i == 0) {
                            writer.write(resultWords.get(i));
                        } else {
                            writer.write(resultWords.get(i) + " -> ");
                        }
                    }
                }

                // Menyimpan solusi GreedyBFS
                writer.write("\n\nAlgortima GreedyBFS");
                writer.newLine();

                ArrayList<String> resultWords = new ArrayList<>();
                if (ListGreedyBFS.get(0) instanceof String) {
                    writer.write("Tidak ditemukan jalan");
                    writer.newLine();
                } else {
                    Node temp = (Node) ListGreedyBFS.get(0);
                    
                    while (temp != null) {
                        resultWords.add(temp.getWord());
                        temp = temp.getParent();
                    }

                    Long time = (Long) ListGreedyBFS.get(1);
                    writer.write("Waktu eksekusi: " + time + " ms");
                    writer.newLine();
                    Float seconds = (time / 1000F);
                    writer.write("Waktu eksekusi : " + seconds + " s");
                    writer.newLine();
                    
                    int nodeCount = (int) ListGreedyBFS.get(2);
                    writer.write("Jumlah node yang dikunjungi: " + nodeCount);
                    writer.newLine();
                    
                    for (int i = resultWords.size() - 1; i >= 0; i--) {
                        if (i == 0) {
                            writer.write(resultWords.get(i));
                        } else {
                            writer.write(resultWords.get(i) + " -> ");
                        }
                    }
                }
                
                // Menyimpan solusi AStar
                writer.write("\n\nAlgortima A*");
                writer.newLine();

                if (ListAStar.get(0) instanceof String) {
                    writer.write("Tidak ditemukan jalan");
                    writer.newLine();
                }else{
                    resultWords = new ArrayList<>();
                    Node temp = (Node) ListAStar.get(0);
                    while (temp != null) {
                        resultWords.add(temp.getWord());
                        temp = temp.getParent();
                    }
                    
                    Long time = (Long) ListAStar.get(1);
                    writer.write("Waktu eksekusi: " + time + " ms");
                    writer.newLine();
                    float seconds = (time / 1000F);
                    writer.write("Waktu eksekusi : " + seconds + " s");
                    writer.newLine();
                    
                    int nodeCount = (int) ListAStar.get(2);
                    writer.write("Jumlah node yang dikunjungi: " + nodeCount);
                    writer.newLine();
                    
                    for (int i = resultWords.size() - 1; i >= 0; i--) {
                        if (i == 0) {
                            writer.write(resultWords.get(i));
                        } else {
                            writer.write(resultWords.get(i) + " -> ");
                        }
                    }
                    System.out.println("File berhasil dibuat: AStar.txt");
                }
                    
            } catch (IOException e) {
                System.err.println("Gagal membuat file: " + e.getMessage());
            }
            
        }
            
        scanner.close();
    }
}
