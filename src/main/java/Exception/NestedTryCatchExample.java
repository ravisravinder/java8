package Exception;

public class NestedTryCatchExample {
    public static void main(String[] args) {
        try {
            int[] numbers = {1, 2, 3};
            System.out.println(numbers[4]); // ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());

            try {
                String str = null;
                System.out.println(str.length()); // NullPointerException
            } catch (NullPointerException ex) {
                System.out.println("Caught NullPointerException: " + ex.getMessage());
            }
        }
    }
}

