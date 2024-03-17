package treeSetExample;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("Data");
        treeSet.add("Aida");
        treeSet.add("Car");
        treeSet.add("Big-boss");
        treeSet.stream().forEach(System.out::println);

        TreeSet<Integer> integers = new TreeSet<>();
        integers.add(1);
        integers.add(5);
        integers.add(2);
        integers.stream().forEach(System.out::println);
        Cisco cisco1   = new Cisco(1,"Auser",45);
        Cisco cisco2   = new Cisco(3,"Cuser",95);
        Cisco cisco3   = new Cisco(2,"Buser",25);

        TreeSet<Cisco> treeSet1 = new TreeSet<>(Comparator.comparingInt(c -> c.id));
        treeSet1.add(cisco1);
        treeSet1.add(cisco2);
        treeSet1.add(cisco3);
        treeSet1.stream().forEach(System.out::println);
    }
}

class Cisco {
    int id;
    String name;
    int age;

    public Cisco(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

//    @Override
//    public int compareTo(Cisco other){
//        return Integer.compare(this.id,other.id);
//    }

    @Override
    public String toString() {
        return "Cisco{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}