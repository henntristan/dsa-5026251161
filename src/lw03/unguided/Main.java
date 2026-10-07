package lw03.unguided;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Set<String> registeredStudents = new LinkedHashSet<>();

        Scanner sc1 = new Scanner(Main.class.getResourceAsStream("registrations.txt"));

        while (sc1.hasNextLine()) {

            String studentId = sc1.nextLine();

            registeredStudents.add(studentId);
        }

        sc1.close();

        Set<String> checkedInStudents = new LinkedHashSet<>();

        int rejectedAttempts = 0;

        System.out.println("===== Event Check-In Results =====");

        Scanner sc2 = new Scanner(Main.class.getResourceAsStream("checkins.txt"));

        while (sc2.hasNextLine()) {

            String studentId = sc2.nextLine();

            if (registeredStudents.contains(studentId)) {

                if (checkedInStudents.add(studentId)) {

                    System.out.println(studentId + ": Checked in");

                } else {

                    System.out.println(studentId + ": Rejected (already checked in)");
                    rejectedAttempts++;
                }

            } else {

                System.out.println(studentId + ": Rejected (not registered)");
                rejectedAttempts++;
            }
        }

        sc2.close();

        int absentStudents = registeredStudents.size() - checkedInStudents.size();

        System.out.println();
        System.out.println("===== Final Event Summary =====");
        System.out.println("Registered students: " + registeredStudents.size());
        System.out.println("Successful check-ins: " + checkedInStudents.size());
        System.out.println("Absent students: " + absentStudents);
        System.out.println("Rejected attempts: " + rejectedAttempts);
    }
}