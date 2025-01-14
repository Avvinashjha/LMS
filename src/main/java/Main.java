package main;

import books.Book;
import books.BookInventoryManager;
import lending.LendingManager;
import patrons.Patron;
import patrons.PatronManager;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Library Management System ===\n");

        // Step 1: Initialize Managers
        BookInventoryManager bookManager = new BookInventoryManager();
        PatronManager patronManager = new PatronManager();
        LendingManager lendingManager = new LendingManager(bookManager);

        // Step 2: Add Books to Inventory
        System.out.println("Adding books to inventory...");
        bookManager.addBook(new Book("Let Us C", "Yashavant Kanetkar", "978-8120348645", 1992));
        bookManager.addBook(new Book("Java: The Complete Reference", "Herbert Schildt", "978-1260440232", 2020));
        bookManager.addBook(new Book("Introduction to Algorithms", "Cormen et al.", "978-0262033848", 2009));
        bookManager.addBook(new Book("Clean Code: A Handbook of Agile Software Craftsmanship", "Robert C. Martin", "978-0132350884", 2008));
        System.out.println("Books added.\n");

        // Step 3: Register Patrons
        System.out.println("Registering patrons...");
        Patron patron1 = new Patron("Rajesh Kumar", "P001", "rajesh.kumar@example.com");
        Patron patron2 = new Patron("Priya Sharma", "P002", "priya.sharma@example.com");
        Patron patron3 = new Patron("Anita Gupta", "P003", "anita.gupta@example.com");
        patronManager.addPatron(patron1);
        patronManager.addPatron(patron2);
        patronManager.addPatron(patron3);
        System.out.println("Patrons registered.\n");

        // Step 4: Borrow Books
        System.out.println("Rajesh borrows 'Let Us C'...");
        lendingManager.checkoutBook("978-8120348645", patron1);

        System.out.println("Priya borrows 'Java: The Complete Reference'...");
        lendingManager.checkoutBook("978-1260440232", patron2);

        System.out.println("\n");

        // Step 5: Return Books
        System.out.println("Priya returns 'Java: The Complete Reference'...");
        lendingManager.returnBook("978-1260440232");

        System.out.println("\n");

        // Step 6: List All Books
        System.out.println("Listing all books in inventory:");
        bookManager.getAllBooks();

        System.out.println("\n");

        // Step 7: List All Patrons
        System.out.println("Listing all registered patrons:");
        patronManager.listAllPatrons();

        System.out.println("\nSystem demo completed!");
    }
}