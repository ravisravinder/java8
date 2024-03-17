package All.AllConverters;

import java.util.Arrays;

public class Int_to_Integer {
    public static void main(String[] args) {
        int a[] = {1,14,16,25,27};
        Integer a1[] = new Integer[a.length];
        Arrays.setAll(a1,i->a[i]);
    }
}
