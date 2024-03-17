package All.AllConverters;

import java.util.stream.IntStream;

public class ArraysExamples {
    public static void main(String[] args) {
        int m1[] = new int[]{1,2,3,4};
        int m2[] = {5,6,7,8,9};
        int m3[] = IntStream.of(14,15,17).toArray();
        int m4[] = IntStream.range(10,30).toArray();
        int m5[] = IntStream.of(56,46,86,23,67,42).sorted().toArray();
        java.util.Arrays.stream(m5).forEach(System.out::println);


    }
}
