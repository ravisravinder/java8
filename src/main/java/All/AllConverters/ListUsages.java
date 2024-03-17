package All.AllConverters;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListUsages {
    public static void main(String[] args) {

    //    List<String> list1 = java.util.Arrays.asList("apple", "banana", "orange");

        List<String> list1 = Arrays.asList("123","234","332");
        List<String> list2 = Stream.of("foo","bar").collect(Collectors.toList());
    }
}
