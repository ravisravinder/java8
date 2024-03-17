package COllections;


public class PriorityQueueExample {
   // PriorityQueue<Cisco3> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(c -> c.id));

}

class Cisco3 {
    int id;
    String name;
    int age;

    public Cisco3(int id, String name, int age) {
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
