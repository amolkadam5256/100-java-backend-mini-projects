package Main;
import java.sql.Connection;         // For DB connection
import java.sql.DriverManager;      // To get DB connection
import java.sql.SQLException;       // Handles SQL exceptions

public class Main {

    // DB connection details
    private static final String url = "jdbc:mysql://localhost:3306/DBConnection";  // DB URL
    private static final String user = "root";                                     // DB username
    private static final String password = "amolkadam7709";                        // DB password

    public static void main(String[] args) {

        // Load MySQL JDBC driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");   // Load driver
            System.out.println("Driver load");           // Success message
        } catch (ClassNotFoundException e) {
            e.printStackTrace();                         // Error loading driver
        }

        // Connect to the database
        try {
            Connection conn = DriverManager.getConnection(url, user, password);  // Establish connection
            System.out.println("Database is connected");                         // Success message

            // Print current database name
            String dbName = conn.getCatalog();  // Get current DB name
            System.out.println("Using Database: " + dbName);

        } catch (SQLException e) {
            e.printStackTrace();                         // Error connecting to DB
        }
    }
}
