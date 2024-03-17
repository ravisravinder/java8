package java8.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class AllConverters {
    public static void main(String[] args) {
        String [] strings = {"apple","banana","orange"};
        List<String> stringList = new ArrayList<>(Arrays.asList(strings));

        //Using Java 8 and later
        String [] strings1 = {"apple","banana","orange"};
        List<String> stringList1 = Arrays.stream(strings1).collect(Collectors.toList());

        //COnverting List to Array
        List<String> stringList2 = Arrays.asList("apple","banana","orange");
        String[] strings2 = stringList2.toArray(new String[0]);

        String[] strings3 = stringList2.stream().toArray(String[]::new);

        //COnverting Array to set:
        String [] strings4 =  {"apple", "banana", "orange"};
        Set<String> stringSet = new HashSet<>(Arrays.asList(strings4));

        //Converting Set to Array
        Set<String> stringSet1 = new HashSet<>(Arrays.asList("apple","banana","orange"));
        String[] strings5 = stringSet1.toArray(new String[0]);

    }
}
