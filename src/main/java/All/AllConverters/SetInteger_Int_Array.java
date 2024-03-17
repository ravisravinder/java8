package All.AllConverters;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetInteger_Int_Array {
    public static void main(String[] args) {
        Set<Integer> integerSet = Set.of(1,2,3,4,5);
        int[] array = integerSet.stream().mapToInt(Integer::intValue).toArray();
            //here array will give 1,2 3 4 5, sometimes 4 5 1 2 3
        // Using LinkedHashSet to maintain insertion order
        Set<Integer> integerSet1 = new LinkedHashSet<>(Set.of(1, 2, 3, 4, 5));



        // Print the elements of the int array
        for (int value : array) {
            System.out.println(value);
        }

        System.out.println("------------7-------");
        //if java version is below-8
        int[] intArray = new int[integerSet.size()];
        int index=0;
        for(Integer a: integerSet){
            intArray[index++]= a;
        }
        // Print the elements of the int array
        for (int intValue : intArray) {
            System.out.println(intValue);
        }
        System.out.println("---------------------");
        for (Integer intValue : intArray) {
            System.out.println(intValue);
        }

        System.out.println("==========================");
        // Iterator to traverse the set
        Iterator<Integer> iterator = integerSet.iterator();

        // Iterate over the set and fill the int array
        int index1 = 0;
        while (iterator.hasNext()) {
            intArray[index1++] = iterator.next();
        }

        // Print the elements of the int array
        for (int value : intArray) {
            System.out.println(value);
        }

    }
}
