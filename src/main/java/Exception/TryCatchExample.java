package Exception;

public class TryCatchExample {
    public static void main(String[] args) {
        try {
            int result = divide(10, 0);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Caught an exception: " + e.getMessage());
        }
    }

    static int divide(int numerator, int denominator) {
        return numerator / denominator;
    }
}

