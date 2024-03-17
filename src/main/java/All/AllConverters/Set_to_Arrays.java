package All.AllConverters;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Set_to_Arrays {
    public static void main(String[] args) {
        Set<String> strings = Stream.of("A","B","C")
                .collect(Collectors.toSet());

        String s[] = strings.stream().toArray(String[]::new);
        System.out.println(Arrays.toString(s));
    }
}
