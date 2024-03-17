package All.AllConverters;

import java.util.ArrayList;
import java.util.List;

public class ArrayList_Initialization {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>(){{
            add("apple");
            add("banana");
            add("carrot");
            add("dark chocolate");
        }};

        List<String> al1 = List.of("a1","b1","c1","d1");
    }
}
