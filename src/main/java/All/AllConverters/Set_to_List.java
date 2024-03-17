package All.AllConverters;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Set_to_List {
    public static void main(String[] args) {
        Set<String> stringSet = new HashSet<>(Arrays.asList("2","4"));
        Set<String> stringSet1 = Set.of("2","4");
        Set<String> stringSet2 = Arrays.stream(new String[]{"2","4"}).collect(Collectors.toSet());
        Set<String> stringSet3 = new HashSet<>();
        stringSet3.add("2");
        stringSet3.add("4");

        Set<String> stringSet4 = new HashSet<String>() {{
            add("2");
            add("4");
        }};

        Set<String> stringSet5 = Collections.singleton("2");

    }
}
