import books.Book;
import books.BookInventoryManager;
import lending.LendingManager;
import patrons.Patron;
import patrons.PatronManager;

public class Main {
    public static void main(String[] args) {
        // Initialize Managers
        BookInventoryManager bookManager = new BookInventoryManager();
        PatronManager patronManager = new PatronManager();
        LendingManager lendingManager = new LendingManager(bookManager);

        // Add Books
        bookManager.addBook(new Book("The Catcher in the Rye", "J.D. Salinger", "12345", 1951));
        bookManager.addBook(new Book("To Kill a Mockingbird", "Harper Lee", "67890", 1960));

        // Add Patrons
        Patron patron = new Patron("Alice", "P001", "alice@example.com");
        patronManager.addPatron(patron);

        // Borrow a Book
        lendingManager.checkOutBook("12345", patron);

        // Return a Book
        lendingManager.returnBook("12345");

        // List Books and Patrons
        bookManager.getAllBooks();
        patronManager.listAllPatrons();
    }
}