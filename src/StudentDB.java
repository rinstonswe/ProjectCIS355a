import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentDB {

    private final String CONNECTION_STRING = "jdbc:sqlite:database.db";
    private final String USERNAME = "N/A";
    private final String PASSWORD = "N/A";

    private static Scanner scan = new Scanner(System.in);

    public StudentDB() throws ClassNotFoundException, SQLException {
        //check for driver
        Class.forName("org.sqlite.JDBC");

        //connect to database
        Connection conn = DriverManager.getConnection(CONNECTION_STRING);

        //create table if it does not exist
        String sqlCreateTable = "CREATE TABLE IF NOT EXISTS students "
                + "(StudentID INTEGER PRIMARY KEY, "
                + "StudentName TEXT, Test1 REAL, Test2 REAL, Test3 REAL)";
        Statement stmt = conn.createStatement();
        stmt.execute(sqlCreateTable);

        //close the connection
        conn.close();
    }

    public void add( Student stu ) throws SQLException
    {

        // connect to the database
        Connection conn = DriverManager.getConnection(CONNECTION_STRING);

        // write the Student record to the database
        String strSQL = "INSERT INTO students (StudentID, StudentName, Test1, Test2, Test3) "
                + "VALUES (?, ?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(strSQL);
        pstmt.setInt( 1, stu.getID() );
        pstmt.setString( 2, stu.getName() );
        pstmt.setDouble( 3, stu.getTest1() );
        pstmt.setDouble( 4, stu.getTest2() );
        pstmt.setDouble( 5, stu.getTest3() );

        pstmt.execute();

        // close the connection to the database
        conn.close();
    }

    public boolean delete(String nameToDelete) throws SQLException
    {
        // connect to the database
        Connection conn = DriverManager.getConnection(CONNECTION_STRING);

        // delete the record
        String strSQL = "DELETE FROM students WHERE StudentName LIKE ?";
        PreparedStatement pstmt = conn.prepareStatement(strSQL);
        pstmt.setString(1, nameToDelete);
        int rowsAffected = pstmt.executeUpdate();

        // close the connection to the database
        conn.close();

        if (rowsAffected > 0)
            return true;   // record was deleted
        else
            return false;  // zero rows affected so record was not found
    }

    public ArrayList<Student> getAll() throws SQLException
    {
        // create an empty ArrayList
        ArrayList<Student> list = new ArrayList<Student>();

        // connect to the database
        Connection conn = DriverManager.getConnection(CONNECTION_STRING);

        // get records from the database
        String strSQL = "SELECT * FROM students";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(strSQL);

        while (rs.next())     // read while we have more records
        {
            // get information from the record and create a Student object
            int stuID = rs.getInt(1);
            String name = rs.getString(2);
            double test1 = rs.getDouble(3);
            double test2 = rs.getDouble(4);
            double test3 = rs.getDouble(5);

            Student stu = new Student(stuID, name, test1, test2, test3);

            // add the Student object to the ArrayList
            list.add(stu);
        }

        // close the connection to the database
        conn.close();

        // return the ArrayList
        return list;
    }



}
