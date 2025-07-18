import java.io.*;
import javax.swing.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class test3_selectData{
    public static void main(String[] args) throws IOException, SQLException {
        JFrame frame = new JFrame("JTable Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);

        String[] columnNames = {"ID", "Name", "Capacity"};
        //String[][] data = ;
        // Data container

        String url = "jdbc:sqlite:my.db";
        String sql = "SELECT * FROM warehouses";
        JTable table = new JTable();
        ArrayList<String[]> datalist = new ArrayList<>();

        try (var conn = DriverManager.getConnection(url);
             var stmt = conn.createStatement();
             var rs = stmt.executeQuery(sql)) {
            
  
            while (rs.next()) {
                String[] data = {rs.getString("id"), rs.getString("name"), rs.getString("capacity")};
                datalist.add(data);
            }
            
            String[][] dataArray = datalist.toArray(new String[0][]);
            table = new JTable(dataArray, columnNames);

            // PRINT IN SYSTEM PRINT
            for (String[] row : dataArray) {
                System.out.printf("%-5s%-25s%-10s%n", row[0], row[1], row[2]);
            }

            // PRINT IN JTABLE
            JScrollPane scrollPane = new JScrollPane(table);
            frame.add(scrollPane);
            // Display the frame
            frame.setVisible(true);
                

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}



/*
import javax.swing.*;

public class zexampleJTable {
    public static void main(String[] args) {
        // Create frame


        // Table data and column names
        String[][] data = {
            {"1", "Alice", "Mathematics"},
            {"2", "Bob", "Physics"},
            {"3", "Charlie", "Chemistry"}
        };
        String[] columnNames = {"ID", "Name", "Subject"};

        // Create JTable with data
        JTable table = new JTable(data, columnNames);

        // Add table to scroll pane
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane);
        
        // Display the frame
        frame.setVisible(true);
    }
}
 */
 