package All.IrerableInterface;

import java.util.ArrayList;
import java.util.Iterator;

public class IterableWithCollection {
    public static void main(String[] args) {

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Apple");
        arrayList.add("Banana");
        arrayList.add("Orange");

        //Using Enhanced forloop
        for(String s: arrayList){
            System.out.println(s);
        }

        Iterator<String> iterator = arrayList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }





    }
}
