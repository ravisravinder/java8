package Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeMain {
    public static void main(String[] args) {
        Employee employee1 = new Employee(1, "John", 30, 3);
        Employee employee2 = new Employee(2, "Alice", 25, 2);
        Employee employee3 = new Employee(3, "Bob", 30, 3);
        Employee employee4 = new Employee(4, "Charlie", 30, 1);

        List<Employee> employees = new ArrayList<>() {{
            add(employee1);
            add(employee2);
            add(employee3);
            add(employee4);
        }};

      Collections.sort(employees, Comparator.comparingInt(Employee::getRank)
                .thenComparing(Employee::getName));

        List<Employee> collect = employees.stream().sorted(Comparator.comparingInt(Employee::getRank).thenComparing(Employee::getName))
                .collect(Collectors.toList());

        collect.forEach(System.out::println);
    }

}
