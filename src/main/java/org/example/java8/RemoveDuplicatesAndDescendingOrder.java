package org.example.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RemoveDuplicatesAndDescendingOrder {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 2, 4, 5, 1);
        Set<Integer> collect = numbers.stream().distinct().sorted(Comparator.comparingInt(Integer::intValue).reversed()
        ).collect(Collectors.toSet());
        System.out.println(collect);

    }
}
