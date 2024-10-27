package org.example.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FindKthLargetElement {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 12, 44, 32, 52, 81, 59, 84, 72, 37);

        int k = 4;

        Integer num = list.stream().sorted(Comparator.reverseOrder())
                .limit(k).skip(k - 1)
                .findFirst().orElse(-1);

        System.out.println(num);

    }
}
