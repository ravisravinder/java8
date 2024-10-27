package org.example.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Merge2ListsRemoveDuplicates {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3);
        List<Integer> list1 = Arrays.asList(3, 4, 5);
        List<Integer> collect = Stream.concat(list.stream(), list1.stream())
                .distinct().collect(Collectors.toList());
        System.out.println(collect);
    }
}
