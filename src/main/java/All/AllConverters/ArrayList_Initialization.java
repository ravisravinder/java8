package All.AllConverters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayList_Initialization {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>(){{
            add("apple");
            add("banana");
            add("carrot");
            add("dark chocolate");
        }};

        ArrayList<String> arrayList1 = new ArrayList<>(Arrays.asList("e","f","g","h"));
        List<String> arrayList2 = new ArrayList<>(List.of("i","j","k","l"));

        List<List<String>> arrayList3 = new ArrayList<>();
        arrayList3.add(Arrays.asList("a","b"));
        arrayList3.add(Arrays.asList("c","d"));

        List<String> al1 = List.of("a1","b1","c1","d1");
    }
}
