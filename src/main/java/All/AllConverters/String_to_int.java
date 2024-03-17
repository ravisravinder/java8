package All.AllConverters;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class String_to_int {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("10","20","30");

        List<Integer> collect = stringList.stream().map(Integer::parseInt).collect(Collectors.toList());
        collect.forEach(System.out::println);
        List<Integer> collect1 = stringList.stream().map(Integer::valueOf).collect(Collectors.toList());
        collect1.forEach(System.out::println);

        String s1 = "100";
        int a= Integer.parseInt(s1);
        int b = Integer.valueOf(s1);
        Integer a1 = Integer.valueOf(s1);
        Integer a2 = Integer.parseInt(s1);
        System.out.println("a "+a+" "+b+" "+a1+" "+a2);


        String[] strings = {"1","2","3","4","5"};
        // Convert String array to List of Strings
        List<String> stringList1 = Arrays.asList(strings);
        // Print the elements of the list of strings
        System.out.println("List of Strings:");
        stringList1.forEach(System.out::println);

        // Convert String array to List of Integers
        List<Integer> integerList = Arrays.stream(strings)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        // Print the elements of the list of integers
        System.out.println("\nList of Integers:");
        integerList.forEach(System.out::println);
    }
}
