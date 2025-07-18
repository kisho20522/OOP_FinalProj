import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Librarian extends Person implements Borrowable{
    private String access = "Librarian";

    public String getAccess() {
        return access;
    }

    public Librarian() {
        super.name = new String();
        super.id = 0;
        super.access = new String();
    }
    // Constructor
    public Librarian(String name) {
        super(name, Library.personCounter(), 1); // Calls the constructor of the base class
    }

    public void addPersonToDatabase(Person Librarian){
        String sql = "INSERT INTO person(name, id, access) VALUES(?,?,?)";

        try (var conn = DriverManager.getConnection(url);
            var pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, Librarian.getName());
            pstmt.setInt(2, Librarian.getID());
            pstmt.setString(3, this.access);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    // gets the librarian from database to be used in existing librarian at choice2, main class
    public static Librarian getPersonFromDatabase(String librarianName) {
        String url = "jdbc:sqlite:library.db";
        String sql = "SELECT * FROM person WHERE name = ? AND access = 'Librarian'";
        try (var conn = DriverManager.getConnection(url);
                var pstmt = conn.prepareStatement(sql)) {
    
            pstmt.setString(1, librarianName);
            var rs = pstmt.executeQuery();
    
            if (rs.next()) {
                // Extract librarian data from the result set
                int id = rs.getInt("id");
                String name = rs.getString("name");
                return new Librarian(name, id);  // Custom constructor for existing librarian
            } else {
                System.out.println("Librarian not found in database.");
                return null;
            }
    
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    public Librarian(String name, int id) {
        super(name, id, 1);  // Use the ID retrieved from the database
        this.id = id;
    }



    //Override
    public void borrowBook(int id, int isbn) { // librarians can borrow books w/o regards to availableCopies
        java.util.Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/YYYY");
        String strDate = dateFormat.format(date); // str date throws current system date
        System.out.println(strDate);
        String sql = "INSERT INTO borrows(isbn, id, borrowDate, quantity) VALUES(?,?,?,?)";

        try (var conn = DriverManager.getConnection(url);
            var pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, isbn);
            pstmt.setInt(2, id);
            pstmt.setString(3, strDate);
            pstmt.setInt(4,1);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return;
        }
    }

    //Override
    public void returnBook(int id, int isbn) { // librarians can return books w/o adding to availableCopies 
        String sql = "DELETE FROM borrows WHERE isbn = ? AND id = ? LIMIT 1";

        try (var conn = DriverManager.getConnection(url);
            var pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, isbn);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return;
        }
    }
}
