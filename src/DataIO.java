import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DataIO
{
    // class level constants   
    private final String CONNECTION_STRING = "jdbc:sqlite:database.db";
    private final String USER_NAME = "N/A";
    private final String PASSWORD = "N/A";

    private static Scanner scan = new Scanner(System.in);

    public DataIO() throws ClassNotFoundException, SQLException {
        //check for driver
        Class.forName("org.sqlite.JDBC");

        //connect to database
        Connection conn = DriverManager.getConnection(CONNECTION_STRING);

        //create table if it does not exist
        String sqlCreateTable = "CREATE TABLE IF NOT EXISTS customers "
                + "(CustomerID INTEGER PRIMARY KEY, "
                + "CustomerName TEXT, Address TEXT, YardType TEXT, YardLength REAL, YardWidth REAL, TotalCost REAL)";
        Statement stmt = conn.createStatement();
        stmt.execute(sqlCreateTable);



        //close the connection
        conn.close();
    }
    public void add( Customer cust ) throws SQLException
    {

        // connect to the database
        Connection conn = DriverManager.getConnection(CONNECTION_STRING);

        // write the customer record to the database
        String strSQL = "INSERT INTO customers (CustomerID, CustomerName, Address, YardType, YardLength, YardWidth, TotalCost) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(strSQL);
        pstmt.setInt( 1, cust.getCustomerID() );
        pstmt.setString( 2, cust.getName() );
        pstmt.setString( 3, cust.getAddress() );
        pstmt.setString( 4, cust.getYardType() );
        pstmt.setDouble( 5, cust.getLength() );
        pstmt.setDouble( 6, cust.getWidth() );
        pstmt.setDouble( 7, cust.getTotalCost() );

        pstmt.execute();

        // close the connection to the database
        conn.close();
    }

    public boolean delete(int idToDelete) throws SQLException
    {
        // connect to the database
        Connection conn = DriverManager.getConnection(CONNECTION_STRING);

        // delete the record
        String strSQL = "DELETE FROM customers WHERE CustomerID = ?";
        PreparedStatement pstmt = conn.prepareStatement(strSQL);
        pstmt.setInt(1, idToDelete);
        int rowsAffected = pstmt.executeUpdate();

        // close the connection to the database
        conn.close();

        if (rowsAffected > 0)
            return true;   // record was deleted
        else
            return false;  // zero rows affected so record was not found
    }

    public boolean update(int cusIdUpdate, double newTotal) throws SQLException
    {
        Connection conn = DriverManager.getConnection(CONNECTION_STRING);

        String strSQL = "UPDATE customers SET TotalCost = ? WHERE CustomerID = ?";
        PreparedStatement pstmt = conn.prepareStatement(strSQL);
        pstmt.setDouble(1, newTotal);
        pstmt.setInt(2, cusIdUpdate);
        int rowsAffected = pstmt.executeUpdate();

        // close the connection to the database
        conn.close();

        if (rowsAffected > 0)
            return true;   // record was updated
        else
            return false;
    }

    public ArrayList<Customer> getAll() throws SQLException
    {
        // create an empty ArrayList
        ArrayList<Customer> list = new ArrayList<Customer>();

        // connect to the database
        Connection conn = DriverManager.getConnection(CONNECTION_STRING);

        // get records from the database
        String strSQL = "SELECT * FROM customers";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(strSQL);

        while (rs.next())     // read while we have more records
        {
            // get information from the record and create a Customer object
            int cusID = rs.getInt(1);
            String name = rs.getString(2);
            String address = rs.getString(3);
            String yardType = rs.getString(4);
            double yardLength = rs.getDouble(5);
            double yardWidth = rs.getDouble(5);
            double totalCost = rs.getDouble(5);

            Customer cus = new Customer(cusID, name, address, yardType, yardLength, yardWidth, totalCost);

            // add the Customer object to the ArrayList
            list.add(cus);
        }

        // close the connection to the database
        conn.close();

        // return the ArrayList
        return list;
    }
} // end of file
