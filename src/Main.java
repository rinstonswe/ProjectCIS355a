import java.io.*;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.ArrayList;
import java.sql.*;

public class Main
{
    // class level references and variables
    private static Scanner scan = new Scanner(System.in);
    public static DecimalFormat fmt = new DecimalFormat("#,##0.00");


    public static void main(String[] args) {
        int choice = 0;
        final int EXIT_VALUE = 4;

        do {
            //show menu
            System.out.println("Menu\n");
            System.out.println("1) Add Stock");
            System.out.println("2) Remove Stock");
            System.out.println("3) Display Single Stock");
            System.out.println("4) Exit");


            //get users choice
            System.out.print("\nEnter your choice: ");
            choice = scan.nextInt();
            scan.nextLine();

            switch (choice) {
                case 1:
                    addStudent();
                    pause();
                    break;
                case 2:
                    deleteStudent();
                    pause();
                    break;
                case 3:
                    displayAllStudent();
                    pause();
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    break;
                default:        //Normally for error checking
                    System.out.println("\nError. Please select from the menu.");
                    pause();
                    break;
            }
        } while (choice != EXIT_VALUE);
    }

    public static void addStudent()
    {System.out.println("\nAdd Student");}

    public static void deleteStudent() {
        System.out.println("\nDelete Student");
    }

    public static void displayAllStudent()
    {System.out.println("\nShow All Student");}

    public static void pause() {
        System.out.println("\nPress Enter to continue...");
        scan.nextLine();
    }
}