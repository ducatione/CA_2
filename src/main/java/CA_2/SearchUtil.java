/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

/**
 *
 * @author kkter
 */

import java.util.List;

/*
 * This class implements recursive Binary Search.
 */
public class SearchUtil {

    public static Employee binarySearch(List<Employee> employees, String targetName) {
        return binarySearchRecursive(employees, targetName, 0, employees.size() - 1);
    }

    private static Employee binarySearchRecursive(
            List<Employee> employees,
            String targetName,
            int left,
            int right) {

        if (left > right) {
            return null;
        }

        int middle = left + (right - left) / 2;

        Employee middleEmployee = employees.get(middle);
        String middleName = middleEmployee.getFullName();

        int comparison = targetName.compareToIgnoreCase(middleName);

        if (comparison == 0) {
            return middleEmployee;
        } else if (comparison < 0) {
            return binarySearchRecursive(employees, targetName, left, middle - 1);
        } else {
            return binarySearchRecursive(employees, targetName, middle + 1, right);
        }
    }
}