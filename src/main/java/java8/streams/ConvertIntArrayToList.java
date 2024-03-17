package java8.streams;

import java.util.Arrays;
import java.util.List;

public class ConvertIntArrayToList {
    public static void main(String[] args) {
        int a[] = {1,2,3,4,5,6};
        List<Integer> al =
                Arrays.asList(Arrays.stream(a).boxed().toArray(Integer[]::new));



        /**Immutable Size: The List returned by Arrays.asList is fixed-size,
         * meaning you cannot add or remove elements from it.
         * Attempts to modify the size of the list (e.g., by adding or
         * removing elements) will result in an UnsupportedOperationException.
         *
         */
        String [] strings = {"apple","banana","orange"};
        List<String> stringList = Arrays.asList(strings);
        strings[0] = "grape";
        System.out.println(stringList);  // Output: [grape, banana, orange]


    }
}
