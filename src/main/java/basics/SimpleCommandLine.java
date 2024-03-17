package basics;

import java.util.Scanner;

public class SimpleCommandLine {
    private static String currentDirectory = "C:/Users/Ravinder_Sabbani/Desktop/java-design-patterns-master";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println(currentDirectory+"> ");
            String input = "cd ..";
            if(input.equalsIgnoreCase("exit")){
                System.out.println("Exiting the program");
                break;
            }
            processCommand(input);
        }
        scanner.close();
    }

    private static void processCommand(String input) {
        if(input.equals("cd ..")){
            navigateUp();
        } else if (input.startsWith("cd ")) {
            navigateTo(input.substring(3));
        }else{
            System.out.println("Unknown command: "+input);
        }
    }

    private static void navigateUp() {
        // Split the current directory into individual components using the forward slash as the delimiter
        String[] components = currentDirectory.split("/");

        // Check if there are at least two components (to avoid issues with the root directory)
        if (components.length >= 2) {
            // Remove the last component (current directory) to go up one level
            StringBuilder newPath = new StringBuilder(components[0]);
            for (int i = 1; i < components.length - 1; i++) {
                newPath.append("/").append(components[i]);
            }
            currentDirectory = newPath.toString();
        } else {
            System.out.println("Already at the root directory.");
        }
    }

    private static void navigateTo(String targetDirectory) {
        // Update the current directory by appending the target directory
        if (currentDirectory.endsWith("/")) {
            currentDirectory += targetDirectory;
        } else {
            currentDirectory += "/" + targetDirectory;
        }
    }




}
