package com.epam.classes.book;

import java.util.List;


public class Book {
    private int idBook;
    private String name;
    private List<String> authors;
    private String publishingOffice;
    private int yearPublishing;
    private int price;
    private TypeBookBinding typeBookBinding;

    public Book(int idBook, String name, List<String> authors, String publishingOffice, int yearPublishing, int price, TypeBookBinding typeBookBinding) {
        this.idBook = idBook;
        this.name = name;
        this.authors = authors;
        this.publishingOffice = publishingOffice;
        this.yearPublishing = yearPublishing;
        this.price = price;
        this.typeBookBinding = typeBookBinding;
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public String getPublishingOffice() {
        return publishingOffice;
    }

    public void setPublishingOffice(String publishingOffice) {
        this.publishingOffice = publishingOffice;
    }

    public int getYearPublishing() {
        return yearPublishing;
    }

    public void setYearPublishing(int yearPublishing) {
        this.yearPublishing = yearPublishing;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public TypeBookBinding getTypeBookBinding() {
        return typeBookBinding;
    }

    public void setTypeBookBinding(TypeBookBinding typeBookBinding) {
        this.typeBookBinding = typeBookBinding;
    }

    @Override
    public String toString() {
        return "Book{" +
                "idBook=" + idBook +
                ", name='" + name + '\'' +
                ", authors=" + authors +
                ", publishingOffice='" + publishingOffice + '\'' +
                ", yearPublishing=" + yearPublishing +
                ", price=" + price +
                ", typeBookBinding=" + typeBookBinding +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (idBook != book.idBook) return false;
        if (yearPublishing != book.yearPublishing) return false;
        if (price != book.price) return false;
        if (!name.equals(book.name)) return false;
        if (!authors.equals(book.authors)) return false;
        if (!publishingOffice.equals(book.publishingOffice)) return false;
        return typeBookBinding == book.typeBookBinding;
    }

    @Override
    public int hashCode() {
        int result = idBook;
        result = 31 * result + name.hashCode();
        result = 31 * result + authors.hashCode();
        result = 31 * result + publishingOffice.hashCode();
        result = 31 * result + yearPublishing;
        result = 31 * result + price;
        result = 31 * result + typeBookBinding.hashCode();
        return result;
    }
}

