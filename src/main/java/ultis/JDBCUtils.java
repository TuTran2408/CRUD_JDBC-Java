package ultis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtils {
    private Connection connection;

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        if (connection == null || connection.isClosed()) {
            String url = "jdbc:mysql://localhost:3306/test4";
            String username = "root";
            String password = "";

            // Step 1* register the driver class with DriverManager
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: get a Database Connection

            connection = DriverManager.getConnection(url, username, password);
        }

        return connection;
    }

    public void disconnect() throws SQLException {
        if (connection != null && connection.isClosed()) {
            connection.close();
        }
    }
}
