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
            System.out.println("1) Add Student");
            System.out.println("2) Remove Student");
            System.out.println("3) Display all students");
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
                    displayAllStudents();
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
    {
        // get student information
        System.out.print( "\nEnter student ID: " );
        int stuID = scan.nextInt();     // 3 ENTER
        scan.nextLine();                // use up the ENTER key since getting String next
        System.out.print( "Enter student name: " );
        String stuName = scan.nextLine();
        System.out.print( "Enter test1 grade: " );
        double test1 = scan.nextDouble();
        System.out.print( "Enter test2 grade: " );
        double test2 = scan.nextDouble();
        System.out.print( "Enter test3 grade: " );
        double test3 = scan.nextDouble();   // 92.1 ENTER
        scan.nextLine();                    // use up the ENTER key

        // create a Student object
        Student stu = new Student(stuID, stuName, test1, test2, test3);

        // add the Student to the database using the StudentDB object
        try
        {
            StudentDB db = new StudentDB();
            db.add(stu);
            System.out.println( "\nRecord was written to the database." );
        }
        catch (ClassNotFoundException ex)
        {
            System.out.println( "\nError. Database driver not found: " + ex.getMessage() );
        }
        catch (SQLException ex)
        {
            System.out.println( "\nDatabase Error: " + ex.getMessage() );
        }
    }

    private static void deleteStudent()
    {
        // get the name of the student to delete
        System.out.print("\nEnter name of student to delete: ");
        String nameToDelete = scan.nextLine();

        try
        {
            // delete the record using the border class
            StudentDB data = new StudentDB();
            boolean result = data.delete(nameToDelete);
            if (result)              // same as:  if (result == true)
                System.out.println("\nRecord was deleted from the database.");
            else
                System.out.println("\nRecord was not found.");
        }
        catch (ClassNotFoundException ex)
        {
            System.out.println("\nError: Driver not found. Error message: " + ex.getMessage());
        }
        catch (SQLException ex)
        {
            System.out.println("\nError: " + ex.getMessage());
        }
    }

    private static void displayAllStudents()
    {
        // show output heading
        System.out.println("\nGradebook:\n");
        System.out.printf("%-5s%-15s%-10s%-10s%-10s%-10s%n", "ID", "Name",
                "Test1", "Test2", "Test3", "Average", "Grade");

        // read the student records
        try
        {
            StudentDB db = new StudentDB();
            ArrayList<Student> data = db.getAll();
            for (int i = 0; i < data.size(); i++)
            {
                Student stu = data.get(i);
                System.out.printf("%-5d%-15s%-10.1f%-10.1f%-10.1f%-10.1f%-10s%n",
                        stu.getID(), stu.getName(), stu.getTest1(), stu.getTest2(),
                        stu.getTest3(), stu.calculateAverage(), stu.calculateLetterGrade());
            }
        }
        catch(ClassNotFoundException ex)
        {
            System.out.println("\nError. Database driver not found: " + ex.getMessage());
        }
        catch(SQLException ex)
        {
            System.out.println("\nDatabase Error: " + ex.getMessage());
        }
    }

    public static void pause() {
        System.out.println("\nPress Enter to continue...");
        scan.nextLine();
        System.out.println("\n\n");
    }
}