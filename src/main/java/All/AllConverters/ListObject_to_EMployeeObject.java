package All.AllConverters;

import java.util.List;

public class ListObject_to_EMployeeObject {
    public static void main(String[] args) {
        List<EmployeeRavi> employeeRaviList = createEMployeeList();
        EmployeeRavi[] employeeArray = employeeRaviList.toArray(EmployeeRavi[]::new);
        // Print the elements of the Employee array
        for (EmployeeRavi employee : employeeArray) {
            System.out.println(employee);
        }

        //We can use this one as well
        EmployeeRavi[] array = employeeRaviList.toArray(new EmployeeRavi[0]);

        // Print the elements of the Employee array
        for (EmployeeRavi employee : array) {
            System.out.println(employee);
        }

    }

    private static List<EmployeeRavi> createEMployeeList() {
        List<EmployeeRavi> employeeRaviList =
                List.of(new EmployeeRavi("John", 30),
                        new EmployeeRavi("Alice", 25),
                        new EmployeeRavi("Bob", 35));
        return employeeRaviList;
    }
}

class EmployeeRavi {
    private String name;
    private int age;

    public EmployeeRavi(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name=" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
