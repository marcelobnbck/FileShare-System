package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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

        System.out.print("Enter the name for the saved file (or leave blank to use the original name): ");
        String desiredName = scanner.nextLine();
        String fileName = desiredName.isEmpty() ? sourceFile.getName() : desiredName;
        Path destinationPath = Paths.get(STORAGE_DIRECTORY, fileName);

        try {
            Files.copy(sourceFile.toPath(), destinationPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File saved successfully as: " + destinationPath.toString());
        } catch (IOException e) {
            System.err.println("Error saving file: " + e.getMessage());
        }
    }

    private static void restoreFile(Scanner scanner) {
        System.out.print("Enter the name of the file to restore from the FileShare: ");
        String fileName = scanner.nextLine();
        Path sourcePath = Paths.get(STORAGE_DIRECTORY, fileName);
        File sourceFile = sourcePath.toFile();

        if (!sourceFile.exists() || !sourceFile.isFile()) {
            System.out.println("Error: File not found in the FileShare.");
            return;
        }

        System.out.print("Enter the full path where you want to restore the file: ");
        String destinationPath = scanner.nextLine();
        File destinationFile = new File(destinationPath);

        try {
            Files.copy(sourcePath, destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File restored successfully to: " + destinationPath);
        } catch (IOException e) {
            System.err.println("Error restoring file: " + e.getMessage());
        }
    }

    private static void deleteFile(Scanner scanner) {
        System.out.print("Enter the name of the file to delete from the FileShare: ");
        String fileName = scanner.nextLine();
        Path filePath = Paths.get(STORAGE_DIRECTORY, fileName);
        File fileToDelete = filePath.toFile();

        if (!fileToDelete.exists() || !fileToDelete.isFile()) {
            System.out.println("Error: File not found in the FileShare.");
            return;
        }

        System.out.print("Are you sure you want to delete '" + fileName + "'? (yes/no): ");
        String confirmation = scanner.nextLine().toLowerCase();

        if (confirmation.equals("yes")) {
            try {
                Files.delete(filePath);
                System.out.println("File '" + fileName + "' deleted successfully.");
            } catch (IOException e) {
                System.err.println("Error deleting file: " + e.getMessage());
            }
        } else {
            System.out.println("Deletion cancelled.");
        }
    }

    private static void listFiles(Scanner scanner) {
        File storageDir = new File(STORAGE_DIRECTORY);
        File[] files = storageDir.listFiles();

        if (files == null || files.length == 0) {
            System.out.println("The FileShare is empty.");
            return;
        }

        System.out.println("Files in the FileShare:");
        for (File file : files) {
            if (file.isFile()) {
                System.out.println("- " + file.getName());
            }
        }
    }

    private static void searchFiles(Scanner scanner) {
        System.out.print("Enter the keyword to search for in file names: ");
        String keyword = scanner.nextLine().toLowerCase();

        File storageDir = new File(STORAGE_DIRECTORY);
        File[] files = storageDir.listFiles();

        if (files == null || files.length == 0) {
            System.out.println("The FileShare is empty.");
            return;
        }

        List<String> matchingFiles = Arrays.stream(files)
                .filter(File::isFile)
                .filter(file -> file.getName().toLowerCase().contains(keyword))
                .map(File::getName)
                .collect(Collectors.toList());

        if (matchingFiles.isEmpty()) {
            System.out.println("No files found containing the keyword '" + keyword + "'.");
        } else {
            System.out.println("Matching files:");
            for (String fileName : matchingFiles) {
                System.out.println("- " + fileName);
            }
        }
    }
}
