import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MainJFrame extends javax.swing.JFrame {

    Library library1 = new Library();
    public MainJFrame() {
        initComponents();
    }
                    
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jButton1.setText("Add new");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Remove");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("View all");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });


        jButton4.setText("Add new");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Remove");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("View all");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Borrow");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Return");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Books");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Members");

        jLabel4.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 22)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Library Management System");
        jLabel4.setToolTipText("");

        jButton9.setText("Transactions");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addComponent(jButton7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton8))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(192, 192, 192)
                        .addComponent(jButton9)))
                .addContainerGap(137, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 140, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(jButton8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton9)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>                        

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) { // add person                         
        String[] options = { "Member", "Librarian" };
        int selection = JOptionPane.showOptionDialog(null, "Member or Librarian?", "Add new person", 0, 3, null, options, options[0]);
        selection++;

        String name = new String();
        JTextField field1 = new JTextField();
        Object[] message = {
            "Enter name:", field1
        };
        int option = JOptionPane.showConfirmDialog(null, message, "Add new person", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION)
        {
            name = field1.getText();
            if (Library.isPersonInDatabase(name)) {
                JOptionPane.showMessageDialog(null, "Name already exists in database.");
                return;  // Exit method, returning to main menu
            }
            library1.addPerson(name, selection);
            JOptionPane.showMessageDialog(this,"New person added successfully");
        } 
    }                                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {      // remove person
        int id = 0;
        JTextField field1 = new JTextField();
        Object[] message = {
            "Enter person ID:", field1
        };
        int option = JOptionPane.showConfirmDialog(null, message, "Delete person", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try{
                id = Integer.parseInt(field1.getText());
            } catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Invalid input (input a number).");
                return;
            }
            
            if (Library.isPersonInDatabase(id)) {
                library1.removePerson(id);
                JOptionPane.showMessageDialog(this,"Person deleted successfully");
                return;
            } else {
                JOptionPane.showMessageDialog(this,"Person doesn't exist in the database");
                return;
            }
        }
    }         
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {      // view all person
        Library.displayAllPerson();
    }     

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {      // add books
        Author newAuthor = new Author();

        String[] options = { "New author", "Existing author" };
        int selection = JOptionPane.showOptionDialog(null, "New author or existing author (in database)", "Add new book", 0, 3, null, options, options[0]);
        
         if (selection == 0){               // NEW AUTHOR
            String author = new String();
            JTextField field1 = new JTextField();
            Object[] message = {
                "Enter author name:", field1
            };
            int option = JOptionPane.showConfirmDialog(null, message, "New author", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION)
            {
                author = field1.getText();
                newAuthor = new Author(author);
                newAuthor.addPersonToDatabase(newAuthor); //sdfhakl;sfasdjfl;askfl;asdj
            }
        }
        if (selection == 1) {              // EXISTING AUTHOR
            String author = new String();
            JTextField field1 = new JTextField();
            Object[] message = {
                "Enter author name:", field1
            };
            int option = JOptionPane.showConfirmDialog(null, message, "Existing author", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                author = field1.getText();
                newAuthor = Author.getPersonFromDatabase(author);
                if (newAuthor == null) {  // Check if the author was found
                    JOptionPane.showMessageDialog(null, "Author not found in the database.");
                    return;  // Exit method, returning to main menu
                }
            }
        }
    
        String title = new String();
        String pubDate = new String(); 
        int isbn = 0, copies = 0;
        JTextField field1 = new JTextField();
        JTextField field2 = new JTextField();
        JTextField field3 = new JTextField();
        JTextField field4 = new JTextField();

        Object[] message = {
            "Enter title: ", field1,
            "Enter ISBN (####): ", field2,
            "Enter publication date (MM/DD/YYYY): ", field3,
            "Enter number of copies: ", field4
        };
        int option = JOptionPane.showConfirmDialog(null, message, "Add new book", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION){
            try{ 
                title = field1.getText();
                pubDate = field3.getText();
                isbn = Integer.parseInt(field2.getText());
                copies = Integer.parseInt(field4.getText());
                JOptionPane.showMessageDialog(this,"New book added successfully");
            } catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Invalid input (ISBN and num of copies should be a number)");
                return;
            }
            Book newBook = new Book(title, newAuthor, isbn, pubDate, copies);
            library1.addBook(newBook, newAuthor);
        }     
    }                              

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {      // remove book
        int isbn = 0;
        JTextField field1 = new JTextField();
        Object[] message = {
            "Enter book ISBN:", field1
        };
        int option = JOptionPane.showConfirmDialog(null, message, "Delete book", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            isbn = Integer.parseInt(field1.getText());
            if (Library.isBookInDatabase(isbn)) {
                try{
                    isbn = Integer.parseInt(field1.getText());
                } catch (NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "Invalid input (input a number).");
                    return;
                }
                library1.removeBook(isbn);
                JOptionPane.showMessageDialog(this,"Book deleted successfully");
                return;
            } else {
                JOptionPane.showMessageDialog(this,"Book doesn't exist in the database");
                return;
            }
        }
    }                                        

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {      // view all books
        Library.displayAllBooks();
    }                                        

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {      // borrow book                          
        int id = 0, isbn = 0;
        String[] options = { "Member", "Librarian" };
        int selection = JOptionPane.showOptionDialog(null, "Who wants to a borrow book?", "Borrow book", 0, 3, null, options, options[0]);
        selection++;

        JTextField field1 = new JTextField();
        JTextField field2 = new JTextField();
        Object[] message = {
            "Enter Person id: ", field1,
            "Enter Book isbn: ", field2
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Borrow book", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION)
        {
            try {
                id = Integer.parseInt(field1.getText());
                isbn = Integer.parseInt(field2.getText());
                if (Library.getAvailableCopiesofBook(isbn) > 0){
                    Library.borrowBook(selection, id, isbn);
                    JOptionPane.showMessageDialog(this,"Book successfully borrowed");
                } else {
                    JOptionPane.showMessageDialog(this,"There are currently no copies available in this book");
                    return;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this,"Invalid input (input a number)");
                return;
            }
        }
    }      

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {      // return book
        int id = 0, isbn = 0;
        String[] options = { "Member", "Librarian" };
        int selection = JOptionPane.showOptionDialog(null, "Who wants to a return a book?", "Return book", 0, 3, null, options, options[0]);
        selection++;

        JTextField field1 = new JTextField();
        JTextField field2 = new JTextField();
        Object[] message = {
            "Enter Person id: ", field1,
            "Enter Book isbn: ", field2
        };
        int option = JOptionPane.showConfirmDialog(null, message, "Return book", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION)
        {
            try {
                id = Integer.parseInt(field1.getText());
                isbn = Integer.parseInt(field2.getText());
                Library.returnBook(selection, id, isbn);
                JOptionPane.showMessageDialog(this,"Book successfully returned");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this,"Invalid input (input a number)");
                return;
            }
        }
    }                             
               
    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {      // view transactions 
        Library.displayTransaction();
    }                                                                               

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration                   
}
