package lw03.prelab;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println("===== Problem 1 =====");
        List<String> playlist = new ArrayList<>();
        Scanner scanner1 = new Scanner(Main.class.getResourceAsStream("playlist.txt"));

        while (scanner1.hasNextLine()) {
            String line = scanner1.nextLine().trim();
            if (line.isEmpty()) continue;

            String[] parts = line.split(" ", 2);
            String command = parts[0];

            if (command.equals("ADD")) {
                playlist.add(parts[1]);
            } else if (command.equals("INSERT")) {
                String[] insertParts = parts[1].split(" ", 2);
                int index = Integer.parseInt(insertParts[0]);
                playlist.add(index, insertParts[1]);
            } else if (command.equals("REMOVE")) {
                playlist.remove(parts[1]);
            }
        }
        scanner1.close();

        System.out.println("Total songs: " + playlist.size());
        for (int i = 0; i < playlist.size(); i++) {
            System.out.println((i + 1) + ": " + playlist.get(i));
        }

        System.out.println();

        System.out.println("===== Problem 2 =====");
        Set<String> participants = new LinkedHashSet<>();
        int duplicateCount = 0;

        Scanner scanner2 = new Scanner(Main.class.getResourceAsStream("participants.txt"));

        while (scanner2.hasNextLine()) {
            String name = scanner2.nextLine().trim();
            if (name.isEmpty()) continue;

            if (participants.contains(name)) {
                duplicateCount++;
            } else {
                participants.add(name);
            }
        }
        scanner2.close();

        System.out.println("Unique participants: " + participants.size());
        int rank = 1;
        for (String participant : participants) {
            System.out.println(rank + ". " + participant);
            rank++;
        }
        System.out.println("Duplicate registrations: " + duplicateCount);

        System.out.println();

        System.out.println("===== Problem 3 =====");
        Map<String, Integer> inventory = new LinkedHashMap<>();
        int failedSales = 0;

        Scanner scanner3 = new Scanner(Main.class.getResourceAsStream("inventory.txt"));

        while (scanner3.hasNextLine()) {
            String line = scanner3.nextLine().trim();
            if (line.isEmpty()) continue;

            String[] parts = line.split(" ");
            String type = parts[0];
            String product = parts[1];
            int quantity = Integer.parseInt(parts[2]);

            if (type.equals("ADD")) {
                if (inventory.containsKey(product)) {
                    inventory.put(product, inventory.get(product) + quantity);
                } else {
                    inventory.put(product, quantity);
                }
            } else if (type.equals("SELL")) {
                if (inventory.containsKey(product) && inventory.get(product) >= quantity) {
                    inventory.put(product, inventory.get(product) - quantity);
                } else {
                    failedSales++;
                }
            }
        }
        scanner3.close();

        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("Failed sales: " + failedSales);
    }
}