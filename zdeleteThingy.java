import java.sql.DriverManager;
import java.sql.SQLException;

public class zdeleteThingy {
    public static void main(String[] args) {
        var url = "jdbc:sqlite:library.db";
        var sql = "DELETE FROM person WHERE id = ?";
        var id = 1;

        try (var conn = DriverManager.getConnection(url);
             var pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);

            // execute the delete statement
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        System.out.println("successfully deleted");
    }
}