public interface Borrowable {
    void borrowBook(int id, int isbn);
    void returnBook(int id, int isbn);
}
