import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Member extends Person implements Borrowable{
    private String access = "Member";

    public String getAccess() {
        return access;
    }


    public Member() {
        super.name = new String();
        super.id = 0;
        super.access = new String();
    }
    // Constructor
    public Member(String name) {
        super(name, Library.personCounter(), 0); // Calls the constructor of the base class
    }


    public void addPersonToDatabase(Person member){
        String sql = "INSERT INTO person(name, id, access) VALUES(?,?,?)";

        try (var conn = DriverManager.getConnection(url);
            var pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, member.getName());
            pstmt.setInt(2, member.getID());
            pstmt.setString(3, this.access);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    // gets the member from database to be used in existing member at choice2, main class
    public static Member getPersonFromDatabase(String memberName) {
        String url = "jdbc:sqlite:library.db";
        String sql = "SELECT * FROM person WHERE name = ? AND access = 'Member'";
        try (var conn = DriverManager.getConnection(url);
             var pstmt = conn.prepareStatement(sql)) {
    
            pstmt.setString(1, memberName);
            var rs = pstmt.executeQuery();
    
            if (rs.next()) {
                // Extract member data from the result set
                int id = rs.getInt("id");
                String name = rs.getString("name");
                return new Member(name, id);  // Custom constructor for existing member
            } else {
                System.out.println("Member not found in database.");
                return null;
            }
    
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
    
    public Member(String name, int id) {
        super(name, id, 0);  // Use the ID retrieved from the database
        this.id = id;
    }



    //Override
    public void borrowBook(int id, int isbn) { // only runs if Books.availableCopies >= 1
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

        sql = "UPDATE books SET availableCopies = (SELECT availableCopies - 1 FROM books WHERE isbn = ? LIMIT 1) WHERE isbn = ?";
        try (var conn = DriverManager.getConnection(url);
            var pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, isbn);
            pstmt.setInt(2, isbn);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return;
        }
    }

    //Override
    public void returnBook(int id, int isbn) { // 
        String sql = "DELETE FROM borrows WHERE ROWID = (SELECT ROWID FROM borrows WHERE isbn = ? AND id = ? LIMIT 1)";

        try (var conn = DriverManager.getConnection(url);
            var pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, isbn);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return;
        }

        sql = "UPDATE books SET availableCopies = (SELECT availableCopies + 1 FROM books WHERE isbn = ? LIMIT 1) WHERE isbn = ? ";
        try (var conn = DriverManager.getConnection(url);
            var pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, isbn);
            pstmt.setInt(2, isbn);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return;
        }
    }



}
