package books;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BookInventoryManager {
    private List<Book> books;

    public BookInventoryManager(){
        this.books = new ArrayList<>();
    }

    public void addBook(Book book){
        books.add(book);
    }

    public void removeBook(String isbn){
        books.removeIf(book -> book.getISBN().equals(isbn));
    }

    public Optional<Book> searchBookByIsbn(String isbn){
        return books.stream()
                .filter(book -> book.getISBN().equals(isbn))
                .findFirst();
    }

    public List<Book> getBooksByTitle(String title){
        return books.stream()
                .filter(book -> book.getTitle().toLowerCase().contains(title.toLowerCase()))
                .collect(Collectors.toList());
    }
    public List<Book> searchBookByAuthor(String author){
        return books.stream().filter(book -> book.getAuthor().toLowerCase().contains(author.toLowerCase())).collect(Collectors.toList());
    }

    public void getAllBooks(){
        books.forEach(System.out::println);
    }
}
