package All.AllConverters;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IntArrayToStringList {
    public static void main(String[] args) {
        int[] intArray = {1,2,3,4,5};
        List<String> stringList = convertIntArrayToString(intArray);

        // Print the elements of the list of strings
        System.out.println("List of Strings:");
        stringList.forEach(System.out::println);
    }

    private static List<String> convertIntArrayToString(int[] intArray) {
     return Arrays.stream(intArray)
             .mapToObj(String::valueOf)
             .collect(Collectors.toList());
    }
}
