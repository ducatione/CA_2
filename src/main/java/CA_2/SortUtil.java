/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

/**
 *
 * @author kkter
 */

import java.util.ArrayList;
import java.util.List;

public class SortUtil {

    public static List<Employee> mergeSort(List<Employee> employees) {

        if (employees.size() <= 1) {
            return employees;
        }

        int middle = employees.size() / 2;

        List<Employee> left = new ArrayList<>(employees.subList(0, middle));
        List<Employee> right = new ArrayList<>(employees.subList(middle, employees.size()));

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

    private static List<Employee> merge(List<Employee> left, List<Employee> right) {

        List<Employee> sortedList = new ArrayList<>();

        int leftIndex = 0;
        int rightIndex = 0;

        while (leftIndex < left.size() && rightIndex < right.size()) {

            String leftName = left.get(leftIndex).getFullName();
            String rightName = right.get(rightIndex).getFullName();

            if (leftName.compareToIgnoreCase(rightName) <= 0) {
                sortedList.add(left.get(leftIndex));
                leftIndex++;
            } else {
                sortedList.add(right.get(rightIndex));
                rightIndex++;
            }
        }

        while (leftIndex < left.size()) {
            sortedList.add(left.get(leftIndex));
            leftIndex++;
        }

        while (rightIndex < right.size()) {
            sortedList.add(right.get(rightIndex));
            rightIndex++;
        }

        return sortedList;
    }
}