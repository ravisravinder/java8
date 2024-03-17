package All.AllConverters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ArrayList_to_Map {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("ONe");
        list.add("Tw0");
        list.add("Three");
        Map<Integer,String> map = new HashMap<>();
        map= list.stream().collect(Collectors.toMap(list::indexOf,s->s));
        // Print the Map
        System.out.println("Map from ArrayList:");
        map.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
