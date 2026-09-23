package lw01.unguided;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InputStream inputStream = null;

        File file = new File("washes.txt");
        if (file.exists()) {
            try {
                inputStream = new FileInputStream(file);
            } catch (Exception e) {
            }
        }

        if (inputStream == null) {
            inputStream = Main.class.getResourceAsStream("washes.txt");
        }
        if (inputStream == null) {
            inputStream = Main.class.getResourceAsStream("/lw01/unguided/washes.txt");
        }
        if (inputStream == null) {
            inputStream = Main.class.getResourceAsStream("/washes.txt");
        }
        if (inputStream == null) {
            inputStream = Main.class.getClassLoader().getResourceAsStream("washes.txt");
        }

        if (inputStream == null) {
            System.err.println("Error: File washes.txt tidak ditemukan!");
            return;
        }

        try (Scanner scanner = new Scanner(inputStream)) {
            if (!scanner.hasNextInt()) {
                return;
            }

            int count = scanner.nextInt();
            WashService[] washes = new WashService[count];

            for (int i = 0; i < count && scanner.hasNext(); i++) {
                String type = scanner.next();
                String id = scanner.next();
                int days = scanner.nextInt();
                int units = scanner.nextInt(); // dibaca sesuai format 4 nilai di washes.txt

                if (type.equalsIgnoreCase("MOTORCYCLE")) {
                    washes[i] = new MotorcycleWash(id, days);
                } else if (type.equalsIgnoreCase("CAR")) {
                    washes[i] = new CarWash(id, days);
                }
            }

            for (WashService wash : washes) {
                if (wash != null) {
                    System.out.println(wash.summary());
                }
            }
        }
    }
}
