package lending;

import books.Book;
import books.BookInventoryManager;
import patrons.Patron;

import java.util.Optional;

public class LendingManager {
    private BookInventoryManager inventoryManager;

    public LendingManager(BookInventoryManager inventoryManager){
        this.inventoryManager = inventoryManager;
    }

    public boolean checkoutBook(String isbn, Patron patron){
        Optional<Book> bookOptional = inventoryManager.searchBookByIsbn(isbn);
        if (bookOptional.isPresent()) {
            Book book = bookOptional.get();
            if (book.isAvailable()) {
                book.setAvailable(false);
                patron.addToBorrowingHistory(isbn);
                System.out.println("Book checked out by: " + patron.getName());
                return true;
            } else {
                System.out.println("Book not available!");
            }
        } else {
            System.out.println("Book not found!");
        }
        return false;
    }

    public boolean returnBook(String isbn) {
        Optional<Book> bookOptional = inventoryManager.searchBookByIsbn(isbn);
        if (bookOptional.isPresent()) {
            Book book = bookOptional.get();
            if (!book.isAvailable()) {
                book.setAvailable(true);
                System.out.println("Book returned successfully.");
                return true;
            } else {
                System.out.println("Book was not borrowed!");
            }
        } else {
            System.out.println("Book not found!");
        }
        return false;
    }
}
