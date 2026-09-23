package lw01.prelab;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Membaca jobs.txt menggunakan getResourceAsStream dari classpath
        InputStream inputStream = Main.class.getResourceAsStream("jobs.txt");
        if (inputStream == null) {
            inputStream = Main.class.getResourceAsStream("/jobs.txt");
        }
        if (inputStream == null) {
            inputStream = Main.class.getClassLoader().getResourceAsStream("jobs.txt");
        }

        if (inputStream == null) {
            System.err.println("Error: File jobs.txt tidak ditemukan!");
            return;
        }

        List<PrintJob> jobs = new ArrayList<>();

        try (Scanner scanner = new Scanner(inputStream)) {
            while (scanner.hasNext()) {
                String type = scanner.next();
                String id = scanner.next();
                int pages = scanner.nextInt();

                PrintJob job;
                if (type.equalsIgnoreCase("MONO")) {
                    job = new MonoPrint(id, pages);
                } else if (type.equalsIgnoreCase("COLOUR")) {
                    job = new ColourPrint(id, pages);
                } else {
                    continue;
                }
                jobs.add(job);
            }
        }

        // Loop polimorfik tunggal tanpa instanceof / casting
        for (PrintJob job : jobs) {
            System.out.println(job.summary());
        }
    }
}
