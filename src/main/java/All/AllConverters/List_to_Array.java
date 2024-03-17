package All.AllConverters;

import java.util.ArrayList;
import java.util.List;

public class List_to_Array {
    public static void main(String[] args) {
        List<String> a = new ArrayList<>(){{
            add("Kony");
            add("SquareTrade");
        }};
        String [] strings = a.toArray(a.toArray(new String[0]));
    }
}
