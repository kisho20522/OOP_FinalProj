import java.sql.DriverManager;
import java.sql.SQLException;

public class zcreateLibTable {

    public static void main(String[] args) {
        // SQLite connection string
        var url = "jdbc:sqlite:library.db";

        // SQL statement for creating a new table
        var sql = "CREATE TABLE IF NOT EXISTS books (" +
                  "	title text NOT NULL," +
                  "	author text NOT NULL," +
                  "	isbn INTEGER PRIMARY KEY," +
                  "	publicationDate date NOT NULL," +
                  "	availableCopies REAL" +
                  ");";

        try (var conn = DriverManager.getConnection(url);
             var stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Table created successfully");
        
    }
}