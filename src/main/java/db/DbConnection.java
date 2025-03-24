package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static String driver = "oracle.jdbc.OracleDriver";
    private static String url = "jdbc:oracle:thin:@localhost:1521:XE"; 
    private static String username = "system"; // Change to your Oracle username
    private static String password = "root"; // Change to your Oracle password

    public static Connection getDbConnection() {
        Connection con = null;
        try {
            System.out.println("Loading driver: " + driver);
            Class.forName(driver);
            System.out.println("Connecting to database with URL: " + url);
            con = DriverManager.getConnection(url, username, password);
            System.out.println("✅ Connection successful!");
        } catch (ClassNotFoundException e) {
            System.out.println("❌ Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("❌ Database connection failed: " + e.getMessage());
        }
        return con;
    }

}
