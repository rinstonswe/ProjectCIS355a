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
        final int EXIT_VALUE = 5;

        do {
            //show menu
            System.out.println("Menu\n");
            System.out.println("1) Add Customer");
            System.out.println("2) Edit Total Cost for Customer");
            System.out.println("3) Delete Customer");
            System.out.println("4) Display All Customers");
            System.out.println("5) Exit\n");


            //get users choice
            choice = 0;      // choice variable should be created before the do-while menu loop
            while( choice == 0 )
            {
                try {
                    System.out.print("\nEnter your choice: ");
                    choice = Integer.parseInt(scan.nextLine());
                }
                catch(NumberFormatException ex) {
                    System.out.println("\nError. Please use numbers only for the menu.");
                }
            }


            switch(choice)
            {
                case 1:
                    addCustomer();
                    pause();
                    break;
                case 2:
                    editTotalCost();
                    pause();
                    break;
                case 3:
                    deleteCustomer();
                    pause();
                    break;
                case 4:
                    displayAllCustomers();
                    pause();
                    break;
                case 5:
                    System.out.println("\nGoodbye!");
                    break;
                default:
                    System.out.println("\nError. Please select from the menu.");
                    pause();
                    break;
            }
        } while (choice != EXIT_VALUE);
    }

    public static void addCustomer()
    {
        // get customer information
        System.out.print( "\nEnter customer ID: " );
        int cusID = scan.nextInt();     // 3 ENTER
        scan.nextLine();                // use up the ENTER key since getting String next
        System.out.print( "Enter customer name: " );
        String cusName = scan.nextLine();
        System.out.print( "Enter address: " );
        String address = scan.nextLine();
        System.out.print( "Enter yard type: " );
        String yardType = scan.nextLine();
        System.out.print( "Enter yard length: " );
        double yardLength = scan.nextDouble();   // 92.1 ENTER
        scan.nextLine();                    // use up the ENTER key
        System.out.print( "Enter yard width: " );
        double yardWidth = scan.nextDouble();
        scan.nextLine();
        System.out.print( "Enter total cost: " );
        double totalCost = scan.nextDouble();   // 92.1 ENTER
        scan.nextLine();

        // create a Customer object
        Customer cus = new Customer(cusID, cusName, address, yardType, yardLength, yardWidth, totalCost);

        // add the Customer to the database using the DataIO object
        try
        {
            DataIO db = new DataIO();
            db.add(cus);
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

    private static void deleteCustomer()
    {
        // get the name of the customer to delete
        System.out.print("\nEnter ID of customer to delete: ");
        int idToDelete = scan.nextInt();
        scan.nextLine();

        try
        {
            // delete the record using the border class
            DataIO data = new DataIO();
            boolean result = data.delete(idToDelete);
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

    private static void editTotalCost(){
        System.out.print("\nEnter ID of customer to update total cost: ");
        int cusId = scan.nextInt();
        scan.nextLine();
        System.out.print("\nEnter new total cost: ");
        int newCost = scan.nextInt();
        scan.nextLine();

        try
        {
            DataIO data = new DataIO();
            boolean result = data.update(cusId, newCost);
            if (result)              // same as:  if (result == true)
                System.out.println("\nRecord was updated in the database.");
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

    private static void displayAllCustomers()
    {
        // show output heading
        System.out.println("\nCustomer List:\n");
        System.out.printf("%-5s%-15s%-10s%-10s%-10s%-10s%-10s%n", "ID", "Name",
                "Address", "Type", "Length", "Width", "Total Cost");

        // read the customer records
        try
        {
            DataIO db = new DataIO();
            ArrayList<Customer> data = db.getAll();
            for (int i = 0; i < data.size(); i++)
            {
                Customer cus = data.get(i);
                System.out.printf("%-5d%-15s%-10.1s%-10.1s%-10.1f%-10.1f%-10s%n",
                        cus.getCustomerID(), cus.getName(), cus.getAddress(), cus.getYardType(),
                        cus.getLength(), cus.getWidth(), cus.getTotalCost());
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