import java.sql.DriverManager;
import java.sql.SQLException;

public class Author extends Person{
    protected String access = "Author";

    public String getAccess() {
        return access;
    }

    public Author() {
        super.name = new String();
        super.id = 0;
        super.access = new String();
    }
    // Constructor for new Author
    public Author(String name) {
        super(name, Library.personCounter(), 2); // Calls the constructor of the base class
    }

    public void addPersonToDatabase(Person author){ //adds author to database
        String sql = "INSERT INTO person(name, id, access) VALUES(?,?,?)";

        try (var conn = DriverManager.getConnection(url);
            var pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, author.name);
            pstmt.setInt(2, author.id);
            pstmt.setString(3, this.access);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }


    public static Author getPersonFromDatabase(String authorName) { // used when creating book with existing author
        String url = "jdbc:sqlite:library.db";
        String sql = "SELECT * FROM person WHERE name = ? AND access = 'Author'";
        try (var conn = DriverManager.getConnection(url);
             var pstmt = conn.prepareStatement(sql)) {
    
            pstmt.setString(1, authorName);
            var rs = pstmt.executeQuery();
    
            if (rs.next()) {
                // Extract author data from the result set
                int id = rs.getInt("id");
                String name = rs.getString("name");
                return new Author(name, id);  // Custom constructor for existing author
            } else {
                System.out.println("Author not found in database.");
                return null;
            }
    
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
    
    public Author(String name, int id) {
        super(name, id, 2);  // Use the ID retrieved from the database
        this.id = id;
    }


    // Method to add a book
    public void addBook(Book books) {
        String sql = "INSERT INTO books(title, author, isbn, publicationDate, availableCopies) VALUES(?,?,?,?,?)";

        try (var conn = DriverManager.getConnection(url);
            var pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, books.getTitle());
            pstmt.setString(2, this.name);
            pstmt.setInt(3, books.getISBN());
            pstmt.setString(4, books.getpublicationDate());
            pstmt.setInt(5, books.getAvailableCopies());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }


    public void printAuthor(Person author){ // FOR DEBUG
        System.out.println("Author details: ");
        System.out.println(author.name);
        System.out.println(author.id);
        System.out.println(access);
    }



}
