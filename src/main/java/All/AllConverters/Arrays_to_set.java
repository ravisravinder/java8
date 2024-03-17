package All.AllConverters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Arrays_to_set {
    public static void main(String[] args) {
        int a[] = {2,7,9,14,8};
        List<Integer> collect = Arrays.stream(a).boxed().collect(Collectors.toList());

        int[] intArray = {1, 2, 3, 4, 5};
        List<Integer> integerList = new ArrayList<>();
        for (int num : intArray) {
            integerList.add(num);
        }

        int[] intArray1 = {1, 2, 3, 4, 5};
        List<String> stringList = Arrays.stream(intArray1)
                .mapToObj(String::valueOf)
                .collect(Collectors.toList());



    }
}
