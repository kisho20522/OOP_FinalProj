import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

public class testframe {
    public static void main(String[] args) {
        // LibraryGUI libraryGUI = new LibraryGUI();
        //     libraryGUI.setVisible(true);


        JLabel label = new JLabel();
        label.setText("Library Management System");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.TOP);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.TOP);
        label.setForeground(new Color(255, 255, 255));
        label.setFont(new Font("Times New Roman",Font.BOLD,20));
        

        JFrame frame = new JFrame();
        frame.setTitle("Title");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(750,750);
        frame.setVisible(true);
        frame.add(label);

        frame.getContentPane().setBackground(new Color(35, 35,35));


        
    
    }
}
