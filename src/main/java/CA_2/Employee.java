/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

/**
 *
 * @author kkter
 */

public class Employee {

    private String firstName;
    private String lastName;
    private ManagerType managerType;
    private DepartmentType departmentType;

    public Employee(String firstName, String lastName,
            ManagerType managerType,
            DepartmentType departmentType) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.managerType = managerType;
        this.departmentType = departmentType;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public ManagerType getManagerType() {
        return managerType;
    }

    public DepartmentType getDepartmentType() {
        return departmentType;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public String toString() {
        return "Employee Name: " + getFullName()
                + "\nManager Type: " + managerType
                + "\nDepartment: " + departmentType;
    }
}