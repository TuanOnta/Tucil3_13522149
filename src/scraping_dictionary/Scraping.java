package scraping_dictionary;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Scraping {
    public static void scraping(String dictionary_name) {
        String fileName = "src/Data/" + dictionary_name;
        List<String> words = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Hapus spasi ekstra jika ada
                String word = line.trim();
                words.add(word);
            }
        } catch (IOException e) {
            System.err.println("Gagal membaca file: " + e.getMessage());
        }

        List<String> words1 = new ArrayList<>();
        List<String> words2 = new ArrayList<>();
        List<String> words3 = new ArrayList<>();
        List<String> words4 = new ArrayList<>();
        List<String> words5 = new ArrayList<>();
        List<String> words6 = new ArrayList<>();
        List<String> words7 = new ArrayList<>();
        List<String> words8 = new ArrayList<>();
        List<String> words9 = new ArrayList<>();
        List<String> words10 = new ArrayList<>();
        List<String> words11 = new ArrayList<>();
        List<String> words12 = new ArrayList<>();
        

        for (String str : words) {
            if (str.length() == 1) {
                words1.add(str);
            } else if (str.length() == 2) {
                words2.add(str);
            } else if (str.length() == 3) {
                words3.add(str);
            } else if (str.length() == 4) {
                words4.add(str);
            } else if (str.length() == 5) {
                words5.add(str);
            } else if (str.length() == 6) {
                words6.add(str);
            } else if (str.length() == 7) {
                words7.add(str);
            } else if (str.length() == 8) {
                words8.add(str);
            } else if (str.length() == 9) {
                words9.add(str);
            } else if (str.length() == 10) {
                words10.add(str);
            } else if (str.length() == 11) {
                words11.add(str);
            } else if (str.length() == 12) {
                words12.add(str);
            }
        }

        // write words1 to file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/Data/words1.txt"))) {
            for (String str : words1) {
                writer.write(str);
                writer.newLine(); // Menambahkan newline setelah setiap elemen
            }
            System.out.println("File berhasil dibuat: words1.txt");
        } catch (IOException e) {
            System.err.println("Gagal membuat file: " + e.getMessage());
        }

        // write words2 to file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/Data/words2.txt"))) {
            for (String str : words2) {
                writer.write(str);
                writer.newLine(); // Menambahkan newline setelah setiap elemen
            }
            System.out.println("File berhasil dibuat: words2.txt");
        } catch (IOException e) {
            System.err.println("Gagal membuat file: " + e.getMessage());
        }

        // write words3 to file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/Data/words3.txt"))) {
            for (String str : words3) {
                writer.write(str);
                writer.newLine(); // Menambahkan newline setelah setiap elemen
            }
            System.out.println("File berhasil dibuat: words3.txt");
        } catch (IOException e) {
            System.err.println("Gagal membuat file: " + e.getMessage());
        }

        // write words4 to file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/Data/words4.txt"))) {
            for (String str : words4) {
                writer.write(str);
                writer.newLine(); // Menambahkan newline setelah setiap elemen
            }
            System.out.println("File berhasil dibuat: words4.txt");
        } catch (IOException e) {
            System.err.println("Gagal membuat file: " + e.getMessage());
        }

        // write words5 to file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/Data/words5.txt"))) {
            for (String str : words5) {
                writer.write(str);
                writer.newLine(); // Menambahkan newline setelah setiap elemen
            }
            System.out.println("File berhasil dibuat: words5.txt");
        } catch (IOException e) {
            System.err.println("Gagal membuat file: " + e.getMessage());
        }

        // write words6 to file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/Data/words6.txt"))) {
            for (String str : words6) {
                writer.write(str);
                writer.newLine(); // Menambahkan newline setelah setiap elemen
            }
            System.out.println("File berhasil dibuat: words6.txt");
        } catch (IOException e) {
            System.err.println("Gagal membuat file: " + e.getMessage());
        }

        // write words7 to file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/Data/words7.txt"))) {
            for (String str : words7) {
                writer.write(str);
                writer.newLine(); // Menambahkan newline setelah setiap elemen
            }
            System.out.println("File berhasil dibuat: words7.txt");
        } catch (IOException e) {
            System.err.println("Gagal membuat file: " + e.getMessage());
        }

        // write words8 to file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/Data/words8.txt"))) {
            for (String str : words8) {
                writer.write(str);
                writer.newLine(); // Menambahkan newline setelah setiap elemen
            }
            System.out.println("File berhasil dibuat: words8.txt");
        } catch (IOException e) {
            System.err.println("Gagal membuat file: " + e.getMessage());
        }

        // write words9 to file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/Data/words9.txt"))) {
            for (String str : words9) {
                writer.write(str);
                writer.newLine(); // Menambahkan newline setelah setiap elemen
            }
            System.out.println("File berhasil dibuat: words9.txt");
        } catch (IOException e) {
            System.err.println("Gagal membuat file: " + e.getMessage());
        }

        // write words10 to file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/Data/words10.txt"))) {
            for (String str : words10) {
                writer.write(str);
                writer.newLine(); // Menambahkan newline setelah setiap elemen
            }
            System.out.println("File berhasil dibuat: words10.txt");
        } catch (IOException e) {
            System.err.println("Gagal membuat file: " + e.getMessage());
        }

        // write words11 to file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/Data/words11.txt"))) {
            for (String str : words11) {
                writer.write(str);
                writer.newLine(); // Menambahkan newline setelah setiap elemen
            }
            System.out.println("File berhasil dibuat: words11.txt");
        } catch (IOException e) {
            System.err.println("Gagal membuat file: " + e.getMessage());
        }

        // write words12 to file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/Data/words12.txt"))) {
            for (String str : words12) {
                writer.write(str);
                writer.newLine(); // Menambahkan newline setelah setiap elemen
            }
            System.out.println("File berhasil dibuat: words12.txt");
        } catch (IOException e) {
            System.err.println("Gagal membuat file: " + e.getMessage());
        }

        
    }
}
