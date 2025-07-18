import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.util.ArrayList;

public class Library extends JFrame{
    // Private attributes
    public static JFrame framePerson = null;
    public static JFrame frameBooks = null;
    public static JFrame frameTransaction = null;
    private static String url = "jdbc:sqlite:library.db";
    private static String sql = new String();


    //imma regulate the count here
    public static int personCounter(){
        sql = "SELECT max(id) FROM person";
        try (var conn = DriverManager.getConnection(url);
        var stmt = conn.createStatement();
        var rs = stmt.executeQuery(sql)) {
        int idCount = rs.getInt("max(id)");
        return idCount+1;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return 0;
        }
        

        // sql = "SELECT max(isbn) FROM books";
        // try (var conn = DriverManager.getConnection(url);
        // var stmt = conn.createStatement();
        // var rs = stmt.executeQuery(sql)) {
        // int isbnCount = rs.getInt("max(isbn)");
        // System.out.println(isbnCount);

        // } catch (SQLException e) {
        //     System.err.println(e.getMessage());
        // }

    }



    //Getters for books and person
    public void getBooks() {
            sql = "SELECT * FROM books";
        System.out.printf("%-25s%-15s%-10s%-20s%-10s%n", "\ntitle" , "author", "isbn", "publicationDate", "availableCopies");
        try (var conn = DriverManager.getConnection(url);
                var stmt = conn.createStatement();
                var rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.printf("%-25s%-15s%-10s%-20s%-10s%n",
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getInt("isbn"),
                        rs.getString("publicationDate"),
                        rs.getInt("availableCopies")
                );
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void getPerson() {
        sql = "SELECT * FROM person";

        System.out.printf("%-25s%-10s%-10s%n", "name", "id", "access");
        try (var conn = DriverManager.getConnection(url);
                var stmt = conn.createStatement();
                var rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.printf("%-25s%-10s%-10s%n",
                        rs.getString("name"),
                        rs.getInt("id"),
                        rs.getString("access")
                );
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    

    //add and remove person
    public void addPerson(String name, int access) { // only member or librarian but not author
        if (access < 1 || access > 2){ // access == 1 for Member, 2 for Librarian
            System.out.println("Invalid input, please try again.");
        } else if (access == 1) {
            Member m = new Member(name);
            m.addPersonToDatabase(m);
        } else if (access == 2) {
            Librarian p = new Librarian(name);
            p.addPersonToDatabase(p);
        }
    }

    public void removePerson(int id) { // remove a book from library
        var sql = "DELETE FROM person WHERE id = ?";

        try (var conn = DriverManager.getConnection(url);
                var pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();             // execute the delete statement

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return;
        }
        System.out.println("person successfully deleted");
    }


    // add and remove books
    public void addBook(Book books, Author author) { // Add a book to the library
        author.addBook(books);
    }

    public void removeBook(int isbn) { // remove a book from library
        var sql = "DELETE FROM books WHERE isbn = ?";

        try (var conn = DriverManager.getConnection(url);
                var pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, isbn);
            pstmt.executeUpdate();             // execute the delete statement

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return;
        }
        System.out.println("book successfully deleted");
    }

    // Displays Books in JTable
    public static void displayAllBooks() {
        if (frameBooks != null){
            frameBooks.dispose();
        }
        frameBooks = new JFrame("Books Table");
        frameBooks.setSize(700, 300);

        String sql = "SELECT * FROM books";
        String[] columnNames = {"Title", "Author", "ISBN", "Publication Date", "Available Copies"};
        JTable table = new JTable();
        ArrayList<String[]> datalist = new ArrayList<>();

        try (var conn = DriverManager.getConnection(url);
            var stmt = conn.createStatement();
            var rs = stmt.executeQuery(sql)) {
        
        while (rs.next()) {
            String[] data = { rs.getString("title"), rs.getString("author"),
            rs.getString("isbn"), rs.getString("publicationDate"), rs.getString("availableCopies") };
            datalist.add(data);
        }
        
        String[][] dataArray = datalist.toArray(new String[0][]);
        table = new JTable(dataArray, columnNames);

        // PRINT IN JTABLE
        JScrollPane scrollPane = new JScrollPane(table);
        frameBooks.add(scrollPane);
        frameBooks.setVisible(true);
            
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    // Displays person in JTable
    public static void displayAllPerson() {
        if (framePerson != null){
            framePerson.dispose();
        }
        framePerson = new JFrame("Person Table");
        framePerson.setSize(400, 300);


        String sql = "SELECT * FROM Person";
        String[] columnNames = {"Name", "ID", "Access"};
        JTable table = new JTable();
        ArrayList<String[]> datalist = new ArrayList<>();

        try (var conn = DriverManager.getConnection(url);
            var stmt = conn.createStatement();
            var rs = stmt.executeQuery(sql)) {
        
        while (rs.next()) {
            String[] data = { rs.getString("name"), rs.getString("id"), rs.getString("access") };
            datalist.add(data);
        }
        
        String[][] dataArray = datalist.toArray(new String[0][]);
        table = new JTable(dataArray, columnNames);

        // PRINT IN JTABLE
        JScrollPane scrollPane = new JScrollPane(table);
        framePerson.add(scrollPane);
        framePerson.setVisible(true);
            
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }


    public static void borrowBook(int access, int id, int isbn){
        if (access < 1 || access > 2){ // access == 1 for Member, 2 for Librarian
            System.out.println("Invalid input, wrong access");
        } else if (access == 1) {
            Member m = new Member();
            m.borrowBook(id, isbn);
        } else if (access == 2) {
            Librarian p = new Librarian();
            p.borrowBook(id, isbn);
        }
    }
    
    public static void returnBook(int access, int id, int isbn){
        if (access < 1 || access > 2){ // access == 1 for Member, 2 for Librarian
            System.out.println("Invalid input, wrong access");
        } else if (access == 1 ) {
            Member m = new Member();
            m.returnBook(id, isbn);
        } else if (access == 2) {
            Librarian p = new Librarian();
            p.returnBook(id, isbn);
        }
    }

    public static void displayTransaction(){ // transaction between people who borrows books
        if (frameTransaction != null){
            frameTransaction.dispose();
        }
        frameTransaction = new JFrame("Transaction Table");
        frameTransaction.setSize(700, 300);

        String sql = "SELECT * FROM borrows";
        String[] columnNames = {"ISBN", "ID", "Borrow Date", "Quantity"};
        JTable table = new JTable();
        ArrayList<String[]> datalist = new ArrayList<>();

        try (var conn = DriverManager.getConnection(url);
            var stmt = conn.createStatement();
            var rs = stmt.executeQuery(sql)) {
        
        while (rs.next()) {
            String[] data = { rs.getString("isbn"), rs.getString("id"),
            rs.getString("borrowDate"), rs.getString("quantity") };
            datalist.add(data);
        }
        
        String[][] dataArray = datalist.toArray(new String[0][]);
        table = new JTable(dataArray, columnNames);

        // PRINT IN JTABLE
        JScrollPane scrollPane = new JScrollPane(table);
        frameTransaction.add(scrollPane);
        frameTransaction.setVisible(true);
            
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static int getAvailableCopiesofBook(int isbn){
        sql = "SELECT availableCopies FROM books WHERE isbn = ? LIMIT 1";
        
        try (var conn = DriverManager.getConnection(url);
             var pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, isbn);
            var rs = pstmt.executeQuery();
            if (rs.next()) {  // Check if the result set has any rows
                int availableCopies = rs.getInt("availableCopies");  // Correct column name
                System.out.println("Copies of book: " + availableCopies);
                return availableCopies;
            } else {
                System.out.println("No book found with ISBN: " + isbn);
                return 0;  
            }
        } catch (SQLException e) {
            System.out.println("error getAvailableCopiesofBook ");
            System.err.println(e.getMessage());
            return 0;
        }
    }



    // IS X IN DATABASE CHECKER
    public static boolean isPersonInDatabase(String personName) { // USES STRING: check the database whether inputted person exists or not
        String url = "jdbc:sqlite:library.db";
        String sql = "SELECT 1 FROM person WHERE name = ? LIMIT 1";
        
        try (var conn = DriverManager.getConnection(url);
             var pstmt = conn.prepareStatement(sql)) {
    
            pstmt.setString(1, personName);
            var rs = pstmt.executeQuery();
    
            // Returns true if a matching record exists
            return rs.next();  
    
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;  // Returns false if an error occurs
        }
    }

    public static boolean isPersonInDatabase(int id) { // USES INT (used to check if x exists before deletion)
        String url = "jdbc:sqlite:library.db";
        String sql = "SELECT 1 FROM person WHERE id = ? LIMIT 1";
        
        try (var conn = DriverManager.getConnection(url);
             var pstmt = conn.prepareStatement(sql)) {
    
            pstmt.setInt(1, id);
            var rs = pstmt.executeQuery();
    
            // Returns true if a matching record exists
            return rs.next();  
    
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;  // Returns false if an error occurs
        }
    }

    public static boolean isBookInDatabase(int isbn) { // USES INT (used to check if x exists before deletion)
        String url = "jdbc:sqlite:library.db";
        String sql = "SELECT 1 FROM books WHERE isbn = ? LIMIT 1";
        
        try (var conn = DriverManager.getConnection(url);
             var pstmt = conn.prepareStatement(sql)) {
    
            pstmt.setInt(1, isbn);
            var rs = pstmt.executeQuery();
    
            // Returns true if a matching record exists
            return rs.next();  
    
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;  // Returns false if an error occurs
        }
    }


    

    
}
