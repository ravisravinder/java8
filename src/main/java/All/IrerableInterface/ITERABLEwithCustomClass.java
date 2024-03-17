package All.IrerableInterface;

import java.util.Iterator;

public class ITERABLEwithCustomClass implements Iterable<Integer> {
    private final int[] array;
    public ITERABLEwithCustomClass(int array[]){
        this.array=array;
    }

    @Override
    public Iterator<Integer> iterator(){

        return new Iterator<Integer>() {
            private int index =0;
            @Override
            public boolean hasNext() {
                return index<array.length;
            }

            @Override
            public Integer next() {
                return array[index++];
            }
        };
    }

    public static void main(String[] args) {
        int a[] = {1,2,3,4,5,6};
        ITERABLEwithCustomClass r_iterator= new ITERABLEwithCustomClass(a);
        for(int a2: r_iterator){
            System.out.println(a2);
        }
    }


}
