package All.AllConverters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class List_To_ArrayList {
    public static void main(String[] args) {
        List<Integer> al = Stream.of(1,7,9,26).collect(Collectors.toList());
        ArrayList<Integer> arrayList = al.stream().collect(Collectors.toCollection(ArrayList::new));
        Integer integer[] = al.toArray(new Integer[0]);


        List<String> al1 = Arrays.asList("333","324");
        List<Integer> al2 = al1.stream().map(a->Integer.valueOf(a)).collect(Collectors.toList());
    }
}
