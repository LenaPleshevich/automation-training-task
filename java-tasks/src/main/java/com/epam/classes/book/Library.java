package com.epam.classes.book;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> bookList;

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public Library(List<Book> bookList) {
        this.bookList = bookList;
    }

    public List<Book> listBookForAuthor(String author) {
        List<Book> searchResultsBooks = new ArrayList<Book>();
        for (Book book: bookList) {
            for (String nameAuthor: book.getAuthors()) {
                if(nameAuthor.equals(author)) {
                    searchResultsBooks.add(book);
                }
            }
        }
        return searchResultsBooks;
    }

    public List<Book> listBookForPublishingOffice(String namePublishingOffice) {
        List<Book> searchResultsBooks = new ArrayList<Book>();
        for (Book book:bookList) {
            if(book.getPublishingOffice().equals(namePublishingOffice)) {
                searchResultsBooks.add(book);
            }
        }
        return searchResultsBooks;
    }

    public List<Book> listBookForYearPublishing(int yearPublishing) {
        List<Book> searchResultsBooks = new ArrayList<Book>();
        for (Book book: bookList) {
            if(book.getYearPublishing() > yearPublishing) {
                searchResultsBooks.add(book);
            }
        }
        return searchResultsBooks;
    }
}
