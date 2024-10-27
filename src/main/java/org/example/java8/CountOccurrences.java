package org.example.java8;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountOccurrences {
    public static void main(String[] args) {
        String[] words= {"apple", "banana", "apple", "orange", "banana", "apple"};
        Map<String, Long> collect = getCollect(words);
        System.out.println(collect);


    }

    private static Map<String, Long> getCollect(String[] words) {
        return Arrays.stream(words).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
