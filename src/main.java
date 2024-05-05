import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import scraping_dictionary.Scraping;
import method.*;

public class main {
    public static void main(String[] args) {
        WordUtil util = new WordUtil();
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

        
        System.out.print("Masukkan kata awal: ");
        String firstword = scanner.nextLine();
        System.out.print("Masukkan kata akhir: ");
        String lastword = scanner.nextLine();

        System.out.println();
        System.out.println("Masukan Algoritma yang ingin digunakan: ");
        System.out.println("1. Uniform Cost Search");
        System.out.println("2. Greedy Best First Search Search");
        System.out.println("3. A* Search");
        
        flag = true;
        ArrayList<String> result;
        while (flag){
            System.out.print("Masukkan pilihan: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    result = new UCS().UCS(firstword, lastword);
                    flag = false;
                    System.out.println("Kata yang ditemukan: ");
                    result.stream().forEach(System.out::println);
                    break;
                default:
                    System.out.println("Input tidak valid, silahkan masukkan angka 1-3");
                    break;
            }
        }

    }
}
