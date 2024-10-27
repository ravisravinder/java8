package org.example.java8;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindFirstNonRepeatingChar {
    public static void main(String[] args) {
        String str = "abacdbef";

        Optional<Character> first = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity()
                        , LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == 1l)
                .map(Map.Entry::getKey)
                .findFirst();
        System.out.println(first.get());
    }
}
