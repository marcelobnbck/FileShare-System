# Simple FileShare System in Java

This is a basic, simplified FileShare system implemented in Java. It allows users to save, restore, delete, list, and search files within a designated local directory.

## Features

* **Save File:** Allows you to copy a file from your local file system into the FileShare storage directory. You can optionally specify a new name for the saved file.
* **Restore File:** Copies a file from the FileShare storage directory back to a specified location on your local file system.
* **Delete File:** Removes a file from the FileShare storage directory after user confirmation.
* **List Files:** Displays a list of all files currently stored in the FileShare storage directory.
* **Search Files:** Allows you to search for files within the FileShare storage directory based on a keyword in their names.

## Getting Started

### Prerequisites

* **Java Development Kit (JDK):** Make sure you have Java installed on your system. You can download it from [Oracle's website](https://www.oracle.com/java/technologies/javase-downloads.html) or use an open-source distribution like [OpenJDK](https://openjdk.java.net/).

### Running the Application

1.  **Save the Code:** Save the provided Java code as `SimpleFileShare.java`.
2.  **Compile:** Open your terminal or command prompt, navigate to the directory where you saved the file, and compile the code using the Java compiler:
    ```bash
    javac SimpleFileShare.java
    ```
    This will generate a `SimpleFileShare.class` file.
3.  **Run:** Execute the compiled class file:
    ```bash
    java SimpleFileShare
    ```
    The application will start in your console, presenting a menu of options.

### Storage Directory

The files saved using this system will be stored in a directory named `storage_directory` which will be created in the same directory where you run the Java program.
