package All.mapInterface;

import java.util.HashMap;
import java.util.Map;

public class MapUsage {
    public static void main(String[] args) {
        Map<String,Integer> myMap = new HashMap<>();
        myMap.put("Apple",10);
        myMap.put("Banana",5);
        myMap.put("Orange",8);
        for(Map.Entry<String,Integer> entry : myMap.entrySet()){
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }
    }
}
