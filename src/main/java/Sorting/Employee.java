package Sorting;

public class Employee {
    private int id;
    private String name;
    private int age;
    private int rank;

    public Employee(int id, String name, int age, int rank){
        this.id=id;
        this.name=name;
        this.age=age;
        this.rank =rank;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getRank() {
        return rank;
    }

    @Override
    public String toString(){
        return "Employee {"+
                "id="+id+
                ", name="+name+'\''+
                ", age"+age +
                ", rank"+ rank +
                '}';

    }
}
