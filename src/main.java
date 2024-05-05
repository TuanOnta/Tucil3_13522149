import java.io.BufferedReader;
import java.io.FileReader;
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
        ucs.find(firstword, lastword, words);
        

        // Algortima GreedyBFS
        GreedyBFS greedyBFS = new GreedyBFS();
        System.out.println("\n\nAlgortima GreedyBFS");
        greedyBFS.find(firstword, lastword, words);
        

        // Algortima A*
        AStar aStar = new AStar();
        System.out.println("\n\nAlgortima A*");
        aStar.find(firstword, lastword, words);


        scanner.close();
    }
}
