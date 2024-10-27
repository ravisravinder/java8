package org.example.java8;

import java.util.Arrays;
import java.util.List;

public class ProductOfNon_NegativeIntegers {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(4, 5, -6, 7, -1, 2, -3);

        long reduce = integerList.stream().filter(n -> n >= 0)
                .mapToLong(Integer::longValue)
                .reduce(1, (a, b) -> a * b);
        System.out.println(reduce);
    }
}
