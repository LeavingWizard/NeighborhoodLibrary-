# 📚 Library Management System

A **simple, user-friendly Library Management System** written in Java that allows users to view available books, check out books, and view checked-out books. The project is organized using Maven and designed with an intuitive user interface.

---

## 🌟 Features

- 📖 **Show available books**: View a list of books currently available in the library.
- 🚀 **Show checked-out books**: See a list of books that have been checked out along with the name of the person who checked them out.
- ✅ **Check out books**: Check out a book by providing your name and the book's ID.
- 🔙 **Check in books**: Return a checked-out book to the library.
- ⚠️ **Error handling**: Gracefully handle invalid inputs and display appropriate error messages.

---

## 📷 Screenshots

### 🏠 Home Screen

![Home Screen](/Users/leavingwizard/Desktop/Screenshot 2023-04-25 at 8.17.35 AM.png)

### 📚 Available Books

![Available Books](/Users/leavingwizard/Desktop/Screenshot 2023-04-25 at 8.19.08 AM.png)

### 🚀 Checked-Out Books

![Checked-Out Books](/Users/leavingwizard/Desktop/Screenshot 2023-04-25 at 8.20.18 AM.png)

### ⚠️ Error Handling

![Error Handling](/Users/leavingwizard/Desktop/Screenshot 2023-04-25 at 8.21.07 AM.png)

---

## 💡 Interesting Piece of Code

The `showAvailableBooks()` method in the `Library` class uses a for-each loop to iterate through the array of books and display the available books. It also handles user input for checking out a book and manages errors.

```java
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
