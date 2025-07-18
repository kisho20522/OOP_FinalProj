import javax.swing.*;

public class zexampleJTable {
    public static void main(String[] args) {
        // Create frame
        JFrame frame = new JFrame("JTable Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);

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
