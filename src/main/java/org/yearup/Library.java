package org.yearup;

import java.util.Scanner;

public class Library {
    private final Book[] books = new Book[5];

    public Library() {
        books[0] = new Book(1, "978-3-16-148410-0", "Book 1");
        books[1] = new Book(2, "978-1-234-56789-7", "Book 2");
        books[2] = new Book(3, "978-0-123-45678-3", "Book 3");
        books[3] = new Book(4, "978-9-876-54321-0", "Book 4");
        books[4] = new Book(5, "978-0-987-65432-1", "Book 5");
    }

    public void showAvailableBooks() {
        System.out.println("Available Books:");
        for (Book book : books) {
            if (!book.isCheckedOut()) {
                System.out.println("ID: " + book.getId() + ", ISBN: " + book.getIsbn() + ", Title: " + book.getTitle());
            }
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the ID of the book to check out, or 0 to go back to the main menu:");
        int bookId = scanner.nextInt();

        if (bookId == 0) {
            return;
        }

        Book selectedBook = findBookById(bookId);
        if (selectedBook == null || selectedBook.isCheckedOut()) {
            System.out.println("Invalid book ID or the book is already checked out.");
            return;
        }

        System.out.print("Enter your name: ");
        String name = scanner.next();
        selectedBook.checkOut(name);
        System.out.println("Book checked out successfully!");
    }

    private Book findBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }
}