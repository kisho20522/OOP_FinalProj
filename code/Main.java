import java.util.Scanner;

public class Main { // OLD MAIN (USED TO TEST METHODS)
    public static void main(String[] args) {
        Library library = new Library();  // Create an instance of the Library
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        String title, author, publicationDate, name = new String();
        int isbn = 0;
        int copies = 0;
        int choice = 0, choice2 = 0;
        //Book newBook = new Book();

        while (!exit) {
            // Display menu options
            System.out.println("\n=== Library Management System ===");
            System.out.println("1. Add a Book");
            System.out.println("2. View Database");
            System.out.println("3. Borrow a Book");
            System.out.println("4. Return a Book");
            System.out.println("5. Add new person");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consumes the "enter" after putting int value

            switch (choice) {
                case 1: // ask whether the author exists in database or new author
                    System.out.println("\n == New author or existing author (in database) ==");
                    System.out.println("1. New author");
                    System.out.println("2. Existing author");
                    System.out.print("Enter your choice: ");
                    choice2 = scanner.nextInt();
                    scanner.nextLine(); // consumes the "enter" after putting int value

                    switch (choice2) {
                        case 1: // New author
                            System.out.print("Enter author name: ");
                            author = scanner.nextLine();
                            
                            if (author.trim().isEmpty()) {
                                System.out.println("Author name cannot be empty!");
                                break;
                            }

                            Author newAuthor = new Author(author);
                            newAuthor.addPersonToDatabase(newAuthor); //sdfhakl;sfasdjfl;askfl;asdj

                            System.out.print("Enter book title: ");
                            title = scanner.nextLine();
        
                            System.out.print("Enter ISBN: ");
                            isbn = scanner.nextInt();
                            scanner.nextLine(); // consumes the "enter" after putting int value
        
                            System.out.print("Enter publication date: ");
                            publicationDate = scanner.nextLine();
        
                            System.out.print("Enter number of copies: ");
                            copies = scanner.nextInt();
                            scanner.nextLine(); // consumes the "enter" after putting int value
        
                            Book newBook = new Book(title, newAuthor, isbn, publicationDate, copies);
                            library.addBook(newBook, newAuthor);
                            System.out.println("Book added successfully!");
                            break;

                            
                        case 2:  // Existing author
                            System.out.print("Enter author name: ");
                            scanner.nextLine(); // consumes the "enter" after putting int value
                            String existingAuthorName = scanner.nextLine();
                            Author existingAuthor = Author.getPersonFromDatabase(existingAuthorName);
                        
                            if (existingAuthor != null) {
                                // Continue to add book details
                                System.out.print("Enter book title: ");
                                title = scanner.nextLine();
                                
                                System.out.print("Enter ISBN: ");
                                isbn = scanner.nextInt();
                                scanner.nextLine(); // consumes the "enter" after putting int value
                                
                                System.out.print("Enter publication date: ");
                                publicationDate = scanner.nextLine();
                                
                                System.out.print("Enter number of copies: ");
                                copies = scanner.nextInt();
                                scanner.nextLine(); // consumes the "enter" after putting int value
                                
                                // Create and add the new book using the existing author
                                newBook = new Book(title, existingAuthor, isbn, publicationDate, copies);
                                library.addBook(newBook, existingAuthor);
                                System.out.println("Book added successfully!");
                            } else {
                                System.out.println("Author not found. Please try again or add a new author.");
                            }
                            break;

                        default:
                            System.out.println("Invalid input. Please try again.\n");
                            break;
                    }
                    break;

                case 2: // View all books
                    System.out.println("\n == View all ==");
                    System.out.println("1. Person");
                    System.out.println("2. Books");
                    System.out.print("Enter your choice: ");
                    choice2 = scanner.nextInt();
                    scanner.nextLine(); // consumes the "enter" after putting int value

                    switch(choice2){
                        case 1:
                            library.getPerson();
                            break;
                            
                        case 2:
                            library.getBooks();
                            break;

                        default:
                            System.out.println("Invalid input. Please try again.\n");
                            break;
                    }
                    break;

                case 3:
                        // Borrow a book
                    // System.out.print("Enter your member ID: ");
                    // int memberId = scanner.nextInt();
                    // scanner.nextLine();  // Consume the newline

                    // System.out.print("Enter the title of the book to borrow: ");
                    // String borrowTitle = scanner.nextLine();

                    // Member member = library.getMemberById(memberId);
                    // if (member != null) {
                    //     library.borrowBook(member, borrowTitle);
                    // } else {
                    //     System.out.println("Member not found.");
                    // }
                    break;

                case 4:
                    // // Return a book
                    // System.out.print("Enter your member ID: ");
                    // int returnMemberId = scanner.nextInt();
                    // scanner.nextLine();

                    // System.out.print("Enter the title of the book to return: ");
                    // String returnTitle = scanner.nextLine();

                    // Member returnMember = library.getMemberById(returnMemberId);
                    // if (returnMember != null) {
                    //     library.returnBook(returnMember, returnTitle);
                    // } else {
                    //     System.out.println("Member not found.");
                    // }
                    break;

                case 5: // add new person
                    System.out.println("\n == Add New Person ==");
                    System.out.println("1. Member");
                    System.out.println("2. Librarian");
                    System.out.print("Enter your choice: ");
                    choice2 = scanner.nextInt();
                    scanner.nextLine(); // consumes the "enter" after putting int value

                    switch (choice2){
                        case 1:
                        case 2:
                            System.out.print("Enter name: ");
                            name = scanner.nextLine();
                            library.addPerson(name, choice2);
                            break;

                        default:
                            System.out.println("Invalid input. Please try again.\n");
                            break;
                    }
                    break;

                case 6: // Exit the program
                    exit = true;
                    System.out.println("Exiting... Thank you!");
                    break;

                default:
                    System.out.println("Invalid input. Please try again.");
            }
        }
        scanner.close();  // Close the scanner to avoid resource leaks
    }
}
