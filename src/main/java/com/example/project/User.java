package com.example.project;

public class User {
    private String name;
    private String Id;
    private Book[] bookList = new Book[5]; // User can borrow up to 5 books

    // Constructor initializes name and ID
    public User(String name, String Id) {
        this.name = name;
        this.Id = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public Book[] getBooks() {
        return bookList;
    }

    public void setBooks(Book[] bookList) {
        this.bookList = bookList;
    }

    // Provides details of books the user has borrowed
    public String bookListInfo() {
        StringBuilder result = new StringBuilder();
        for (Book book : bookList) {
            if (book == null) {
                result.append("empty\n");
            } else {
                result.append(book.bookInfo()).append("\n");
            }
        }
        return result.toString();
    }

    // Returns a summary of user details
    public String userInfo() {
        return "Name: " + name + "\nId: " + Id + "\nBooks: \n" + bookListInfo();
    }
}