package comparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ComparatorExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Doe", null, "Alice", "Bob", null);

        names.sort((s1,s2)-> s1.compareTo(s2));
        System.out.println(names);

        names.sort(Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder()));
        System.out.println(names);
        names.sort(Comparator.nullsFirst(Comparator.naturalOrder()));
        System.out.println(names);
    }
}
