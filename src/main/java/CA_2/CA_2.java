/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package CA_2;

/**
 *
 * @author kkter
 */


import java.util.Scanner;

public class CA_2 {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ApplicantManager applicantManager = new ApplicantManager();
        applicantManager.loadApplicantsFromFile();

        boolean running = true;

        while (running) {
            displayMenu();

            int choice = getMenuChoice();

            switch (choice) {
                    
                case 1:
                    applicantManager.setEmployees(
                            SortUtil.mergeSort(applicantManager.getEmployees())
                    );

                    System.out.println("\nApplicants sorted alphabetically.");
                    System.out.println("First 20 applicants:");

                    int limit = Math.min(20, applicantManager.getEmployees().size());

                    for (int i = 0; i < limit; i++) {
                        System.out.println((i + 1) + ". "
                                + applicantManager.getEmployees().get(i).getFullName());
                    }
                    break;

                case 2:
                    System.out.println("Search applicant selected.");
                    break;

                case 3:
                    System.out.println("Add employee selected.");
                    break;

                case 4:
                    System.out.println("Create binary tree selected.");
                    break;

                case 5:
                    System.out.println("Display tree selected.");
                    break;

                case 6:
                    System.out.println("Exiting system. Goodbye.");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option. Please choose between 1 and 6.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\n===== BANK EMPLOYEE MANAGEMENT SYSTEM =====");
        System.out.println("1. Sort Applicants");
        System.out.println("2. Search Applicant");
        System.out.println("3. Add Employee");
        System.out.println("4. Create Binary Tree");
        System.out.println("5. Display Tree");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int getMenuChoice() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
            System.out.print("Enter your choice: ");
        }

        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }
}