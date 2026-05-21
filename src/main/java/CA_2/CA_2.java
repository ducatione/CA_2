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
        
        BinaryTree binaryTree = new BinaryTree();

        boolean running = true;

        while (running) {
            displayMenu();

            int choice = getMenuChoice();

            switch (choice) {
                
                case 1 -> {
                    if (applicantManager.getEmployees().isEmpty()) {
                        System.out.println("No applicants available to sort.");
                        break;
                    }

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
                }

                case 2 -> {
                    if (applicantManager.getEmployees().isEmpty()) {
                        System.out.println("No applicants available to search.");
                        break;
                    }

                    applicantManager.setEmployees(
                            SortUtil.mergeSort(applicantManager.getEmployees())
                    );

                    String searchName = ValidationUtil.getNonEmptyString(
                            scanner,
                            "Enter applicant full name to search: "
                    );

                    Employee foundEmployee = SearchUtil.binarySearch(
                            applicantManager.getEmployees(),
                            searchName
                    );

                    if (foundEmployee != null) {
                        System.out.println("\nApplicant found:");
                        System.out.println(foundEmployee);
                    } else {
                        System.out.println("\nApplicant not found.");
                    }
                }
                    
                case 3 -> {
                    String firstName = ValidationUtil.getNonEmptyString(
                            scanner,
                            "Enter employee first name: "
                    );

                    String lastName = ValidationUtil.getNonEmptyString(
                            scanner,
                            "Enter employee last name: "
                    );

                    ManagerType managerType = ValidationUtil.getValidManagerType(scanner);
                    DepartmentType departmentType = ValidationUtil.getValidDepartmentType(scanner);

                    Employee newEmployee = new Employee(
                            firstName,
                            lastName,
                            managerType,
                            departmentType
                    );

                    applicantManager.getEmployees().add(newEmployee);

                    System.out.println("\nEmployee added successfully:");
                    System.out.println(newEmployee);
                }

                    
                case 4 -> {
                    if (applicantManager.getEmployees().isEmpty()) {
                        System.out.println("No employees available to create binary tree.");
                        break;
                    }

                    binaryTree = new BinaryTree();

                    int treeLimit = Math.min(20, applicantManager.getEmployees().size());

                    for (int i = 0; i < treeLimit; i++) {
                        binaryTree.insert(applicantManager.getEmployees().get(i));
                    }

                    System.out.println("\nBinary tree created successfully.");
                    System.out.println(treeLimit + " employees inserted using level-order insertion.");
                }

                    
                case 5 -> {
                    if (binaryTree.getNodeCount() == 0) {
                        System.out.println("Binary tree has not been created yet. Please select option 4 first.");
                        break;
                    }

                    System.out.println("\n===== EMPLOYEE BINARY TREE =====");
                    binaryTree.displayLevelOrder();

                    System.out.println("\nTree Height: " + binaryTree.getHeight());
                    System.out.println("Total Nodes: " + binaryTree.getNodeCount());
                }

                case 6 -> {
                    System.out.println("Exiting system. Goodbye.");
                    running = false;
                }

                default -> System.out.println("Invalid option. Please choose between 1 and 6.");
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