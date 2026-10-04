package org.example;

import org.example.entity.Employee;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        LinkedList<Employee> employees = new LinkedList<>();

        employees.add(new Employee(1, "Ahmet", "Yılmaz"));
        employees.add(new Employee(2, "Mehmet", "Demir"));
        employees.add(new Employee(1, "Ahmet", "Yılmaz"));
        employees.add(new Employee(3, "Ayşe", "Kaya"));
        employees.add(null);
    }

    public static List<Employee> findDuplicates(List<Employee> employees) {

        LinkedList<Employee> duplicates = new LinkedList<>();
        HashMap<Integer, Integer> counts = new HashMap<>();

        for (Employee employee : employees) {

            if (employee == null) {
                continue;
            }

            int id = employee.getId();

            counts.put(
                    id,
                    counts.getOrDefault(id, 0) + 1
            );
        }

        for (Employee employee : employees) {

            if (employee == null) {
                continue;
            }

            if (counts.get(employee.getId()) > 1 &&
                    !duplicates.contains(employee)) {

                duplicates.add(employee);
            }
        }

        return duplicates;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> employees) {

        HashMap<Integer, Employee> uniques = new HashMap<>();

        for (Employee employee : employees) {

            if (employee == null) {
                continue;
            }

            uniques.put(
                    employee.getId(),
                    employee
            );
        }

        return uniques;
    }

    public static List<Employee> removeDuplicates(List<Employee> employees) {

        LinkedList<Employee> result = new LinkedList<>();
        HashMap<Integer, Integer> counts = new HashMap<>();

        for (Employee employee : employees) {

            if (employee == null) {
                continue;
            }

            int id = employee.getId();

            counts.put(
                    id,
                    counts.getOrDefault(id, 0) + 1
            );
        }

        for (Employee employee : employees) {

            if (employee == null) {
                continue;
            }

            if (counts.get(employee.getId()) == 1) {
                result.add(employee);
            }
        }

        return result;
    }
}