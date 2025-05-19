package ui;
import exceptions.*;
import java.util.Scanner;
import model.*;

public class Executable {
    private static ProjectManagementSystem system;
    private static Scanner scanner;

    public static void main(String[] args){
        system = new ProjectManagementSystem();
        scanner = new Scanner(System.in);

        System.out.println("Welcome to the Faculty Project Management System");

        try{
            initializeSystem();
            showMainMenu();
        }catch (Exception e){
            System.err.println("An error ocurred: " + e.getMessage());
        }finally {
            scanner.close();
        }
    }

    private static void initializeSystem() {
        System.out.println("Please choose an option to initialize the system: ");
        System.out.println("1. Load demo data");
        System.out.println("2. Load data form file");
        System.out.print("Enter your choice (1-2): ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        try{
            if (choice == 1){
                system.initializeSystem("demo");
                System.out.println("Demo data loaded succesfully");
            }else if( choice == 2){
                System.out.println("Enter the path to the data file: ");
                String filePath = scanner.nextLine();
                system.initializeSystem(filePath);
                System.out.println("Data loaded succesfully form file");
            } else {
                System.out.println("Invalid choice. Using empty system");
            }
        }catch (InvalidFileException e){
            System.out.println("Error loading data: " + e.getMessage());
            System.out.println("Starting with empty system");
        }
    }

    public static void showMainMenu() {
        while (true) {
            System.out.println("\n Main Menu:");
            System.out.println("1. Manage courses");
            System.out.println("2. Manage professors");
            System.out.println("3. Manage projects");
            System.out.println("4. Search Projects");
        }
    }
}
