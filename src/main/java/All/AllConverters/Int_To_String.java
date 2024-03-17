package All.AllConverters;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Int_To_String {
    public static void main(String[] args) {

        int m1 = 100;
        String s = String.valueOf(m1);

        Integer m2 = 200;
        String s1 = String.valueOf(m2);

        System.out.println("S :"+s +"  s1 :"+s1);
        int a[] ={1,2,3,4,5,6,7,8};

        String [] strings = Arrays.stream(a)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);
        Arrays.stream(strings).forEach(System.out::println);



        //java 7

        String [] stringArray = new String[a.length];
        for(int i=0;i<a.length;i++){
            stringArray[i]=String.valueOf(a[i]);
        }
        System.out.println(Arrays.toString(stringArray));
        // we can use
        // Print the elements of the string array
        for (String str : stringArray) {
            System.out.println(str);
        }


        List<Integer> integerList = List.of(1,2,3,4,5);
        List<String> stringList = integerList.stream()
                .map(Objects::toString).collect(Collectors.toList());
        stringList.forEach(System.out::println);


    }
}
