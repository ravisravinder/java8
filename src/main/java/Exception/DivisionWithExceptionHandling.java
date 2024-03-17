package Exception;

import java.util.Scanner;

public class DivisionWithExceptionHandling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter numerator: ");
        int numerator = scanner.nextInt();

        System.out.print("Enter denominator: ");
        int denominator = scanner.nextInt();

        try {
            int result = divide(numerator, denominator);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static int divide(int numerator, int denominator) {
//        try{
//            int numerator1 = numerator;
//            return   numerator1 /denominator;
//        } catch (Exception e){
//            e.getMessage();
//        }
        if (denominator == 0) {
            throw new ArithmeticException("Cannot divide by zero.");
        }
        return 12;
    }
}
