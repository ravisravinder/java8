package COllections;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ArrayListExample {
    public static void main(String[] args) {
        Cisco5 cisco1   = new Cisco5(1,"Auser",45);
        Cisco5 cisco2   = new Cisco5(3,"Cuser",95);
        Cisco5 cisco3   = new Cisco5(2,"Buser",25);
        ArrayList<Cisco5> arrayList = new ArrayList<>();
        arrayList.add(cisco1);
        arrayList.add(cisco2);
        arrayList.add(cisco3);

        Collections.sort(arrayList, Comparator.comparingInt(c -> c.id));

    }
}
class Cisco5 {
    int id;
    String name;
    int age;

    public Cisco5(int id, String name, int age) {
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
        return "Cisco5{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}