package lw01.prelab;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File file = new File("jobs.txt");
        if (!file.exists()) {
            file = new File("src/lw01/prelab/jobs.txt");
        }
        if (!file.exists()) {
            file = new File("lw01/prelab/jobs.txt");
        }
        if (!file.exists()) {
            file = new File("prelab 1/jobs.txt");
        }

        List<PrintJob> jobs = new ArrayList<>();

        try (Scanner scanner = new Scanner(file)) {
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
        } catch (FileNotFoundException e) {
            System.err.println("Error: File jobs.txt tidak ditemukan!");
            return;
        }

        for (PrintJob job : jobs) {
            System.out.println(job.summary());
        }
    }
}
