public class Book {
    // Private attributes
    private String title;             // book title
    private Author author;            // author class
    private int ISBN;                 // book id (primary key)
    private String publicationDate;   // book publication date
    private int availableCopies;      // book quantity on library

    // Constructor
    public Book() {
        this.title = new String();
        this.author = new Author(null);
        this.ISBN = 0;
        this.publicationDate = new String();
        this.availableCopies = 0;
    }

    public Book(String title, Author author, int ISBN, String publicationDate, int availableCopies) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.publicationDate = publicationDate;
        this.availableCopies = availableCopies;
    }

    // Public getter and setter for 'title'
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    // Public getter and setter for 'title'
    public String getAuthor() {
        return author.getName();
    }

    public void setAuthor(Author author) {
        this.author = author;
    }


    // Public getter and setter for 'ISBN'
    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }


    // Public getter and setter for 'publicationDate'
    public String getpublicationDate() {
        return publicationDate;
    }

    public void setpublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }


    // Public getter and setter for 'availableCopies' with validation
    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        if (availableCopies >= 0) {  // Ensures no negative copies
            this.availableCopies = availableCopies;
        } else {
            System.out.println("Available copies cannot be negative.");
        }
    }



}


