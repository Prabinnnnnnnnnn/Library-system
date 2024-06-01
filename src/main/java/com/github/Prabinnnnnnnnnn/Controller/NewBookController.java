package com.github.Prabinnnnnnnnnn.Controller;

import com.github.Prabinnnnnnnnnn.models.Book;
import com.github.Prabinnnnnnnnnn.models.BookCopy;
import com.github.Prabinnnnnnnnnn.models.BookCopyStatus;

import java.util.ArrayList;
import java.util.Date;


public class NewBookController {
    private final ArrayList<Book> books;


    public NewBookController() {
        this.books = new ArrayList<>();
    }

    public boolean  checkForExisting(String title) {
        for (Book book : books) {
            if (book.checkForExisting(title)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkForEdition(String title, String edition) {
        for(Book book : books ) {
            if (book.checkForEdition(title, edition)) {
                return true;
            }
        }
        return false;
    }

    public void createNewCopy(Book book, int copyNum, BookCopyStatus status, Date dueBack) {
        BookCopy newCopy = new BookCopy(copyNum, status, dueBack);
        book.createNewCopy(newCopy);
    }

    public void createNewBook(String title, String author, String edition, String pubYear, String ISBN, String publisher, String catalogueNumber) {
        Book newBook = new Book(title, author, edition, pubYear, ISBN, publisher, catalogueNumber);
        books.add(newBook);
    }
    public ArrayList<Book> getBooks() {
        return books;
    }
    public void deleteBook(Book book) {
        books.remove(book);
    }
}