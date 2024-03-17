package All.ListInterface;

import java.util.ArrayList;
import java.util.List;

public class ListUsage {
    public static void main(String[] args) {
        List<String> myList = new ArrayList<>();
        myList.add("Apple");
        myList.add("Banana");
        myList.add("Orange");
        System.out.println(myList.get(1));
        System.out.println("Elements in the list:");
        for (String fruit : myList) {
            System.out.println(fruit);
        }
        //myList.add(1,"100");
        myList.add(3,"100");
       // myList.add(-1, "NegativeIndex");
        System.out.println("Elements in the list After update:");
        for (String fruit : myList) {
            System.out.println(fruit);
        }
    }
}
