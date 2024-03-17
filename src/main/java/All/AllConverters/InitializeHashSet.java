package All.AllConverters;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InitializeHashSet {
    public static void main(String[] args) {
        Set<String> strings = Stream.of("A","B","C")
                .collect(Collectors.toCollection(HashSet::new));

        String string[] = new String[]{"Ravi","Ganesh","Mahesh"};
        Set<String> str2 = Arrays.stream(string)
                .collect(Collectors.toCollection(HashSet::new));

        List<String> stringList = List.of("123","345","456");
        stringList.stream().collect(Collectors.toCollection(HashSet::new));

    }
}
