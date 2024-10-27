package org.example.java8;

import java.util.Comparator;
import java.util.List;

public class LongestPalindromeString {
    public static void main(String[] args) {
        List<String> list = List.of("level", "hello", "radar", "world", "madam", "java", "Malayalam");
        String str = list.stream().filter(s -> new StringBuilder(s).reverse().toString().equalsIgnoreCase(s))
                .max(Comparator.comparingInt(String::length)).orElse("");

        System.out.println(str);
    }
}
