package All.IrerableInterface;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IterableWithListEmployees {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(101,"John"));
        employees.add(new Employee(102,"Alice"));
        employees.add(new Employee(103,"Bob"));

        for(Employee emp : employees){
            System.out.println("Employee ID: " + emp.getId() + ", Name: " + emp.getName());
        }

        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()){
            Employee emp = iterator.next();
            System.out.println("Employee ID: " + emp.getId() + ", Name: " + emp.getName());

        }

    }






}

class Employee {
    private int id;
    private String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
