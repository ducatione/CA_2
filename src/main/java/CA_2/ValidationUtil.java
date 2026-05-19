/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

/**
 *
 * @author kkter
 */

import java.util.Scanner;

public class ValidationUtil {

    public static String getNonEmptyString(Scanner scanner, String message) {
        String input;

        do {
            System.out.print(message);
            input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Input cannot be empty.");
            }

        } while (input.isEmpty());

        return input;
    }

    public static ManagerType getValidManagerType(Scanner scanner) {

        while (true) {
            System.out.println("\nSelect Manager Type:");

            ManagerType[] managerTypes = ManagerType.values();

            for (int i = 0; i < managerTypes.length; i++) {
                System.out.println((i + 1) + ". " + managerTypes[i]);
            }

            System.out.print("Enter choice: ");

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice >= 1 && choice <= managerTypes.length) {
                    return managerTypes[choice - 1];
                }
            } else {
                scanner.nextLine();
            }

            System.out.println("Invalid manager type. Please try again.");
        }
    }

    public static DepartmentType getValidDepartmentType(Scanner scanner) {

        while (true) {
            System.out.println("\nSelect Department:");

            DepartmentType[] departments = DepartmentType.values();

            for (int i = 0; i < departments.length; i++) {
                System.out.println((i + 1) + ". " + departments[i]);
            }

            System.out.print("Enter choice: ");

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice >= 1 && choice <= departments.length) {
                    return departments[choice - 1];
                }
            } else {
                scanner.nextLine();
            }

            System.out.println("Invalid department. Please try again.");
        }
    }
}