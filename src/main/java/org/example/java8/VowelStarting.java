package org.example.java8;

import java.util.Arrays;
import java.util.List;

public class VowelStarting {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "banana", "orange", "kiwi", "strawberry");
        long count = list.stream().filter(s -> "aeiouAEIOU".contains(String.valueOf(s.charAt(0)))).count();
        System.out.println(count);
    }
}
