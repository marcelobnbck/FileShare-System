package org.example;

import java.io.File;
import java.util.Scanner;

public class SimpleFileShare {

    private static final String STORAGE_DIRECTORY = "storage_directory";

    public static void main(String[] args) {
        File storageDir = new File(STORAGE_DIRECTORY);
        if (!storageDir.exists()) {
            storageDir.mkdirs();
        }

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nFileShare System:");
            System.out.println("1. Save File");
            System.out.println("2. Restore File");
            System.out.println("3. Delete File");
            System.out.println("4. List Files");
            System.out.println("5. Search Files");
            System.out.println("6. Quit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    saveFile(scanner);
                    break;
                case "2":
                    restoreFile(scanner);
                    break;
                case "3":
                    deleteFile(scanner);
                    break;
                case "4":
                    listFiles(scanner);
                    break;
                case "5":
                    searchFiles(scanner);
                    break;
                case "6":
                    System.out.println("Thank you for use FileShare System.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void saveFile(Scanner scanner) {
        System.out.print("Enter the full path of the file to save: ");
        String sourceFilePath = scanner.nextLine();
        File sourceFile = new File(sourceFilePath);

        if (!sourceFile.exists() || !sourceFile.isFile()) {
            System.out.println("Error: Source file not found or is not a valid file.");
            return;
        }
    }

    private static void restoreFile(Scanner scanner) {

    }

    private static void deleteFile(Scanner scanner) {

    }

    private static void listFiles(Scanner scanner) {

    }

    private static void searchFiles(Scanner scanner) {

    }
}
