package All.setInterface;

import java.util.HashSet;
import java.util.Set;

/**
 * Here are some of the common methods provided by the Set interface:
 *
 * add(E e): Adds the specified element to the set if it is not already present.
 * remove(Object o): Removes the specified element from the set if it is present.
 * contains(Object o): Returns true if the set contains the specified element.
 * isEmpty(): Returns true if the set contains no elements.
 * size(): Returns the number of elements in the set.
 * clear(): Removes all elements from the set.
 */
public class SetUsage {
    public static void main(String[] args) {
        Set<String> mySet = new HashSet<>();
        mySet.add("Apple");
        mySet.add("Banana");
        mySet.add("Orange");
        mySet.add("Apple");
        System.out.println("Contains 'Banana'? " + mySet.contains("Banana"));
        mySet.remove("adasd");

        String[] array = mySet.toArray(new String[mySet.size()]);

        String element = array[0];
        System.out.println("Retrieved element: " + element);


    }
}
