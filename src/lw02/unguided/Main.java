package lw02.unguided;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        LinkedList<String[]> orders = new LinkedList<>();

        Scanner scanner = new Scanner(
            Main.class.getResourceAsStream("orders.txt")
        );

        while (scanner.hasNext()) {
            String[] order = new String[4];
            order[0] = scanner.next();
            order[1] = scanner.next();
            order[2] = scanner.next();
            order[3] = scanner.next();
            orders.add(order);
        }

        scanner.close();

        LinkedList<String[]> foods = new LinkedList<>();
        foods.add(new String[]{"Bakso", "2"});
        foods.add(new String[]{"Sate", "1"});
        foods.add(new String[]{"Soto", "2"});

        LinkedList<String[]> drinks = new LinkedList<>();
        drinks.add(new String[]{"EsTeh", "4"});
        drinks.add(new String[]{"EsJeruk", "2"});

        Queue<String[]> queue = new LinkedList<>();
        queue.addAll(orders);

        Stack<String[]> failed = new Stack<>();
        LinkedList<String[]> successfulOrders = new LinkedList<>();

        while (!queue.isEmpty()) {
            String[] order = queue.poll();
            String name = order[0];
            String sideDish = order[1];
            String drink = order[2];
            String table = order[3];

            String[] foodItem = null;
            boolean foodAvailable = true;
            if (!sideDish.equals("-")) {
                for (String[] f : foods) {
                    if (f[0].equals(sideDish)) {
                        foodItem = f;
                        break;
                    }
                }
                foodAvailable = (foodItem != null && Integer.parseInt(foodItem[1]) > 0);
            }

            String[] drinkItem = null;
            boolean drinkAvailable = true;
            if (!drink.equals("-")) {
                for (String[] d : drinks) {
                    if (d[0].equals(drink)) {
                        drinkItem = d;
                        break;
                    }
                }
                drinkAvailable = (drinkItem != null && Integer.parseInt(drinkItem[1]) > 0);
            }

            if (foodAvailable && drinkAvailable) {
                if (foodItem != null) {
                    int stock = Integer.parseInt(foodItem[1]) - 1;
                    foodItem[1] = String.valueOf(stock);
                }
                if (drinkItem != null) {
                    int stock = Integer.parseInt(drinkItem[1]) - 1;
                    drinkItem[1] = String.valueOf(stock);
                }
                successfulOrders.add(order);
            } else {
                failed.push(order);
            }
        }

        System.out.println("=== Successfully Processed Orders ===");
        for (String[] order : successfulOrders) {
            System.out.println(order[0] + " " + order[1] + " " + order[2] + " " + order[3]);
        }

        System.out.println("\n=== Remaining Food Stock ===");
        for (String[] food : foods) {
            System.out.println(food[0] + " : " + food[1]);
        }

        System.out.println("\n=== Remaining Drink Stock ===");
        for (String[] drink : drinks) {
            System.out.println(drink[0] + " : " + drink[1]);
        }

        System.out.println("\n=== Failed Orders ===");
        while (!failed.isEmpty()) {
            String[] order = failed.pop();
            System.out.println(order[0] + " " + order[1] + " " + order[2] + " " + order[3]);
        }
    }
}
