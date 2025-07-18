import java.sql.DriverManager;
import java.sql.SQLException;

public class zcreateBorrowsTable {

    public static void main(String[] args) {
        // SQLite connection string
        var url = "jdbc:sqlite:library.db";

        // SQL statement for creating a new table
        var sql = "CREATE TABLE IF NOT EXISTS borrows (" +
                  "	isbn INTEGER NOT NULL," +       // foreign key
                  "	id INTEGER NOT NULL," +         // foreign key
                  "	borrowDate date NOT NULL," +
                  "	quantity REAL," +
                  "	CONSTRAINT fk1_isbn FOREIGN KEY (isbn) REFERENCES books(isbn)," +
                  "	CONSTRAINT fk2_id FOREIGN KEY (id) REFERENCES person(isbn)" +
                  ");";

                  // borrow should have fk isbn, fk customerid, and quantity

        try (var conn = DriverManager.getConnection(url);
             var stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("Table created successfully");
        
    }
}