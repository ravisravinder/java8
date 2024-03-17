package All.AllConverters;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ListInteger_Int_Array {
    public static void main(String[] args) {
        List<Integer> al = List.of(1,2,3,4,5,6,7,8);
        // we can use intValue, value of
        IntStream intStream = al.stream().mapToInt(Integer::valueOf);
        IntStream intStream1 = al.stream().mapToInt(Integer::intValue);
        int[] array = intStream1.toArray();
        System.out.println(Arrays.toString(array));

        /**
         * String[] stringArray = stringList.toArray(new String[0]);
         * This approach creates a new String array with an initial length of 0.
         * The toArray method then fills this array with the elements of the
         * List<String>. If the size of the list exceeds the initial capacity
         * of the array, a new array is allocated with sufficient length to
         * accommodate all elements
         */
        List<String> stringList = List.of("Apple", "Banana", "Carrot");
        String[] stringArray = stringList.toArray(new String[0]);
        // Print the elements of the String array
        for (String str : stringArray) {
            System.out.println(str);
        }


        /**
         * In this approach, a constructor reference String[]::new is
         * used to create a new String array. The toArray method
         * dynamically determines the size of the array based on
         * the size of the list and creates an array with the
         * appropriate length to hold all elements. This approach
         * is more concise and efficient compared to specifying an
         * initial array length.
         */
        String[] array1 = stringList.toArray(String[]::new);
    }
}
