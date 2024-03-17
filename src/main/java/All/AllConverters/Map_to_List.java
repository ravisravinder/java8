package All.AllConverters;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Map_to_List {
    public static void main(String[] args) {
        Map<Integer, String > map = new HashMap<>(){{
            put(1,"Allstate");
            put(2,"Apidel-Tech");
        }};
        List<Integer> keys = map.keySet().stream().collect(Collectors.toList());
        List<String> values = map.values().stream().collect(Collectors.toList());

        Set<Integer> keySets = map.keySet().stream().collect(Collectors.toSet());
    }
}
