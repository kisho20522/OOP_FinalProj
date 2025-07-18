import java.sql.DriverManager;
import java.sql.SQLException;

public class test5_deleteData {
    public static void main(String[] args) {
        var url = "jdbc:sqlite:my.db";
        var sql = "DELETE FROM warehouses WHERE id = ?";
        var id = 3;

        try (var conn = DriverManager.getConnection(url);
             var pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);

            // execute the delete statement
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}