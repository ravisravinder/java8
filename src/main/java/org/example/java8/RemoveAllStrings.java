package org.example.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveAllStrings {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "banana", "orange", "kiwi");
        char specificChar = 'a';
        List<String> collect = list.stream().filter(s -> !s.contains(String.valueOf(specificChar)))
                .collect(Collectors.toList());
        System.out.println(collect);

    }
}
