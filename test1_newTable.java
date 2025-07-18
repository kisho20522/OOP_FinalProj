import java.sql.DriverManager;
import java.sql.SQLException;

public class test1_newTable {

    public static void main(String[] args) {
        // SQLite connection string
        var url = "jdbc:sqlite:my.db";

        // SQL statement for creating a new table
        var sql = "CREATE TABLE IF NOT EXISTS warehouses ("
                + "	id INTEGER PRIMARY KEY,"
                + "	name text NOT NULL,"
                + "	capacity REAL"
                + ");";

        try (var conn = DriverManager.getConnection(url);
             var stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}