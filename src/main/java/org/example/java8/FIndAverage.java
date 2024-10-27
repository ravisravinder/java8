package org.example.java8;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class FIndAverage {
    public static void main(String[] args) {
        List<Double> doubles = Arrays.asList(1.2, 3.5, 2.8, 4.1, 5.7);
        OptionalDouble average = doubles.stream().mapToDouble(Double::doubleValue).average();
        System.out.println(average.getAsDouble());
    }
}
