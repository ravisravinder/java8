package All.AllConverters;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Set_to_Array {
    public static void main(String[] args) {
        Set<String> strings1 = new HashSet<>();
        strings1.add("Ravi");
        strings1.add("David");
        strings1.add("Sachin");

        String s[] = new String[strings1.size()];
        s= strings1.toArray(s);
        System.out.println(Arrays.toString(s));

        String s3 [] = strings1.stream().toArray(String[]::new);
        System.out.println(Arrays.toString(s3));
    }
}
