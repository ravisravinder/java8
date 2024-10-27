package org.example.java8;

import java.util.Arrays;
import java.util.List;

public class CubeonElements {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(4,5,6,7,1,2,3);

        integerList.stream().map(i->i*i*i)
                .filter(i->i>50)
                .forEach(System.out::println);
    }
}
