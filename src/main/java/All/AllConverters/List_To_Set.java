package All.AllConverters;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class List_To_Set {
    public static void main(String[] args) {
        List<String> alist = Arrays.asList("Geek","For","Geeks");
        Set<String> collect = alist.stream().collect(Collectors.toSet());
        HashSet<String> strings = Optional.of(alist).map(HashSet::new).orElse(null);

        Set<String> stringSet = new HashSet<>(alist);
        Set<String> stringSet1 = new TreeSet<>(alist);

        List<String> stringList2 = collect.stream().collect(Collectors.toList());

    }
}
