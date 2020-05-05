package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLServer {
    private static final String URL = "jdbc:mysql://localhost:3306";
    private static final String NAME = "root";
    private static final String PASSWORD = "efqan1999";

    public Connection createConnection(){
        try {
            return DriverManager.getConnection(URL,NAME,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Can't connect to mysql server!");
        }
    }
}
