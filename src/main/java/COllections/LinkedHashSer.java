package COllections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

public class LinkedHashSer {

    public static void main(String[] args) {
        List<Cisco1> ciscoList = new ArrayList<>();
        ciscoList.add(new Cisco1(1, "Auser", 45));
        ciscoList.add(new Cisco1(3, "Cuser", 95));
        ciscoList.add(new Cisco1(2, "Buser", 25));

        Comparator<Cisco1> comparator = Comparator.comparingInt(c->c.id);
        List<Cisco1> collect = ciscoList.stream().sorted(comparator).collect(Collectors.toList());

        //  // Add sorted elements to LinkedHashSet
        LinkedHashSet<Cisco1> linkedHashSer = new LinkedHashSet(collect);

        for (Cisco1 cisco : linkedHashSer) {
            System.out.println("ID: " + cisco.id + ", Name: " + cisco.name + ", Age: " + cisco.age);
        }

    }
}


    class Cisco1 {
        int id;
        String name;
        int age;

        public Cisco1(int id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

    }
