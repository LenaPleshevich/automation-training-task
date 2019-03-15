package com.epam.classes.book;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String []args){
        Library library = createLibrary();
        System.out.println(library.listBookForAuthor("Roberts"));
        System.out.println(library.listBookForPublishingOffice("AST"));
        System.out.println(library.listBookForYearPublishing(2018));
    }
    public static Library createLibrary(){
        List<Book> bookList = new ArrayList<Book>();
        Library library = new Library(bookList);
        List<String> authorsBookShantaram = new ArrayList<String>();
        authorsBookShantaram.add("Roberts");
        Book shantaram = new Book(1,"Shantaram",authorsBookShantaram,"Azbuka",2017,30,TypeBookBinding.PERFECT);
        library.getBookList().add(shantaram);
        List<String> authorsBookSherlock = new ArrayList<String>();
        authorsBookSherlock.add("Doyle");
        Book sherlock = new Book(2,"The stories about Sherlock Holmes ",authorsBookSherlock,"AST",2017,5,TypeBookBinding.PAMPHLET);
        library.getBookList().add(sherlock);
        List<String> authorsBookThePeopleInTheTrees = new ArrayList<String>();
        authorsBookThePeopleInTheTrees.add("Yanagihara");
        Book peopleInTheTrees = new Book(3,"The people in the trees",authorsBookThePeopleInTheTrees,"AST",2018,27,TypeBookBinding.SECTION_SEWN);
        library.getBookList().add(peopleInTheTrees);
        List<String> authorsBookDeceptionPoint = new ArrayList<String>();
        authorsBookDeceptionPoint.add("Brown");
        Book deceptionPoint = new Book(4,"Deception point",authorsBookDeceptionPoint,"AST",2019,6,TypeBookBinding.PAMPHLET);
        library.getBookList().add(deceptionPoint);
        List<String> authorsBookIfIStay = new ArrayList<String>();
        authorsBookIfIStay.add("Forman");
        Book ifIStay = new Book(5,"If KI stay",authorsBookIfIStay,"Exmo",2015,10,TypeBookBinding.SECTION_SEWN);
        library.getBookList().add(ifIStay);
        return library;
    }


}
