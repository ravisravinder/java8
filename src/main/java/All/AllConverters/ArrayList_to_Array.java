package All.AllConverters;

import java.util.ArrayList;
import java.util.List;

public class ArrayList_to_Array {
    public static void main(String[] args) {
        List<String> stringList  = new ArrayList<>();
        stringList.add("10");
        stringList.add("20");
        int a[] = stringList.stream().mapToInt(Integer::valueOf).toArray();

        Integer[] a2 = stringList.stream().map(Integer::parseInt).toArray(b->new Integer[b]);
    }
}
