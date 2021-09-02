package db_connection;
import java.sql.*;

public class dbConn {
    
    private static final String url = "jdbc:mysql://localhost:3306/inventory_system";
    private static final String username = "root";
    private static final String password = "";

    public static void connectDb(String[] args) {

        System.out.println("Connecting database...");
        
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Database connected!");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect to database!", e);
        }
    }

}
