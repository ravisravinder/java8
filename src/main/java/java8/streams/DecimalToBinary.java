package java8.streams;

public class DecimalToBinary {
    public static void main(String[] args) {
        int decimalNumber = 16;

        // Create an array to store binary digits
        int[] binaryArray = new int[32]; // Assuming a 32-bit binary representation

        // Counter for the binary array
        int index = 0;

        // Convert decimal to binary
        while (decimalNumber > 0) {
            // Store the remainder when dividing by 2
            binaryArray[index] = decimalNumber % 2;

            // Divide the number by 2
            decimalNumber = decimalNumber / 2;

            // Move to the next index in the binary array
            index++;
        }

        // Display the binary representation
        System.out.print("Binary representation: ");
        for (int i = index - 1; i >= 0; i--) {
            System.out.print(binaryArray[i]);
        }
    }
}

