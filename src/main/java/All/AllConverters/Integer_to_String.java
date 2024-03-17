package All.AllConverters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Integer_to_String {
    public static void main(String[] args) {
        List<Integer> al = Stream.of(1,2,3,7,9).collect(Collectors.toList());
        String string[] = al.stream().map(String::valueOf).toArray(b->new String[b]);

        int a2 []= {7,9,6,4};
        String [] strings = Arrays.stream(a2).mapToObj(String::valueOf).toArray(String[]::new);

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Sunday");
        arrayList.add("Monday");
        System.out.println(Arrays.toString(arrayList.toArray()));
    }
}
