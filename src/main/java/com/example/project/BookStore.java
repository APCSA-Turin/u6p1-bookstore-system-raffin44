package com.example.project;

public class BookStore {
    private Book[] books = new Book[0]; // Dynamic resizing would be better with ArrayList
    private User[] users = new User[10]; // Predefined maximum of 10 users

    // Empty constructor
    public BookStore() {}

    public User[] getUsers() {
        return users;
    }

    public void setUsers(User[] users) {
        this.users = users;
    }

    public Book[] getBooks() {
        return books;
    }

    // Adds a user to the store
    public void addUser(User user) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) {
                users[i] = user; // Add user to the first available spot
                consolidateUsers(); // Ensure array remains compact
                return;
            }
        }
    }

    // Removes a user from the store
    public void removeUser(User user) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] == user) { // Compare by reference; consider overriding equals in User class
                users[i] = null;
                consolidateUsers();
                return;
            }
        }
    }

    // Rearranges the user array to remove null gaps
    public void consolidateUsers() {
        int nextEmpty = 0;
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null) {
                if (i != nextEmpty) {
                    users[nextEmpty] = users[i];
                    users[i] = null;
                }
                nextEmpty++;
            }
        }
    }

    // Adds a book to the inventory
    public void addBook(Book book) {
        int newLength = books.length + 1;
        Book[] newBooks = new Book[newLength];
        for (int i = 0; i < books.length; i++) {
            newBooks[i] = books[i];
        }
        newBooks[newLength - 1] = book; // Add the new book at the end
        books = newBooks;
    }

    // Inserts a book at a specific index
    public void insertBook(Book book, int index) {
        if (index < 0 || index > books.length) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        Book[] newBooks = new Book[books.length + 1];
        for (int i = 0; i < index; i++) {
            newBooks[i] = books[i];
        }
        for (int i = index + 1; i < newBooks.length; i++) {
            newBooks[i] = books[i - 1];
        }
        newBooks[index] = book;
        books = newBooks;
    }

    // Removes a book from the inventory
    public void removeBook(Book book) {
        int index = -1;
        for (int i = 0; i < books.length; i++) {
            if (books[i] == book) {
                index = i; // Find the index of the book
                break;
            }
        }
        if (index == -1) return; // Book not found

        if (books[index].getQuantity() == 1) {
            Book[] newList = new Book[books.length - 1];
            for (int i = 0; i < index; i++) {
                newList[i] = books[i];
            }
            for (int i = index + 1; i < books.length; i++) {
                newList[i - 1] = books[i];
            }
            books = newList;
        } else {
            books[index].setQuantity(books[index].getQuantity() - 1); // Decrement quantity if more than 1
        }
    }

    // Debugging helper for book info
    public String bookStoreBookInfo() {
        String result = "";
        for (Book book : books) {
            result += book.bookInfo() + "\n";
        }
        return result;
    }

    // Debugging helper for user info
    public String bookStoreUserInfo() {
        String result = "";
        for (User user : users) {
            if (user != null) {
                result += user.userInfo() + "\n";
            }
        }
        return result;
    }
}