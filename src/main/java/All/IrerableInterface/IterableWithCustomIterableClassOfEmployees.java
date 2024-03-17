package All.IrerableInterface;

import java.util.Iterator;

public class IterableWithCustomIterableClassOfEmployees {
    public static void main(String[] args) {
        Employees employees1 = new Employees(3);
        employees1.add(new Employee1(101, "John"));
        employees1.add(new Employee1(102, "Alice"));
        employees1.add(new Employee1(103, "Bob"));

        for(Employee1 emp : employees1){
            System.out.println("Employee ID: " + emp.getId() + ", Name: " + emp.getName());
        }

        Iterator<Employee1> iterator = employees1.iterator();
        while (iterator.hasNext()){
            Employee1 emp = iterator.next();
            System.out.println("Employee ID: " + emp.getId() + ", Name: " + emp.getName());
        }
    }
}

class Employees implements Iterable<Employee1>{
    private Employee1[] employees;
    private int size;

    public Employees(int capacity){
        employees = new Employee1[capacity];
        size=0;
    }

    public  void add(Employee1 emp){
        if(size< employees.length){
            employees[size++]=emp;
        }
    }

    @Override
    public Iterator<Employee1> iterator() {
        return new Iterator<Employee1>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public Employee1 next() {
                return employees[index++];
            }
        };
    }
}

class Employee1 {
    private int id;
    private String name;

    public Employee1(int id, String name) {
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
