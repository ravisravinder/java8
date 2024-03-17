package All.AllConverters;

import java.util.HashMap;
import java.util.Map;

public class Map_to_Array {
    public static void main(String[] args) {
        Map<Integer,String> stringMap = new HashMap<>(){{
            put(1,"Ravi");
            put(2,"Vijay");
        }};

        String [] strings = stringMap.values().toArray(new String[0]);
        Integer[] integes = stringMap.keySet().toArray(new Integer[0]);

    }
}
