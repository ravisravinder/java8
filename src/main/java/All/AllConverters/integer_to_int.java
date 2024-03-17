package All.AllConverters;

public class integer_to_int {
    public static void main(String[] args) {
       // Integer integer = new Integer(55); --> deprecated in java 9
      //  int i = integer.intValue();
        Integer integerObject = Integer.valueOf(42);
        int intValue1  = integerObject;
        int intValue2 = integerObject.intValue();

        // Print the converted values
        System.out.println("Using unboxing: " + intValue1);
        System.out.println("Using intValue() method: " + intValue2);

    }
}
