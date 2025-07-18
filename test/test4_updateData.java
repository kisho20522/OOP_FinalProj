import java.sql.DriverManager;
import java.sql.SQLException;

public class test4_updateData {
    public static void main(String[] args) {
        var url = "jdbc:sqlite:my.db";
        var sql = "UPDATE warehouses SET name = ? , "
                + "capacity = ? "
                + "WHERE id = ?";

        var name = "Finished Products";
        var capacity = 5500;
        var id = 3;

        try (var conn = DriverManager.getConnection(url);
             var pstmt = conn.prepareStatement(sql)) {
            // set the parameters
            pstmt.setString(1, name);
            pstmt.setDouble(2, capacity);
            pstmt.setInt(3, id);
            // update
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
