/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

/**
 *
 * @author kkter
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ApplicantManager {

    private List<Employee> employees;

    public ApplicantManager() {
        employees = new ArrayList<>();
    }

    public void loadApplicantsFromFile() {

        try {

            InputStream inputStream = getClass()
                    .getClassLoader()
                    .getResourceAsStream("Applicants_Form.txt");

            if (inputStream == null) {
                System.out.println("File not found.");
                return;
            }

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(inputStream));

            String line;

            boolean firstLine = true;

            while ((line = reader.readLine()) != null) {

                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                String[] data = line.split(",");

                if (data.length < 7) {
                    continue;
                }

                String firstName = data[0].trim();
                String lastName = data[1].trim();

                ManagerType managerType = generateManagerType();
                DepartmentType departmentType = generateDepartmentType();

                Employee employee = new Employee(
                        firstName,
                        lastName,
                        managerType,
                        departmentType
                );

                employees.add(employee);
            }

            System.out.println(employees.size()
                    + " applicants loaded successfully.");

        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }

    private ManagerType generateManagerType() {

        ManagerType[] managerTypes = ManagerType.values();

        int randomIndex = (int) (Math.random() * managerTypes.length);

        return managerTypes[randomIndex];
    }

    private DepartmentType generateDepartmentType() {

        DepartmentType[] departmentTypes = DepartmentType.values();

        int randomIndex = (int) (Math.random() * departmentTypes.length);

        return departmentTypes[randomIndex];
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}