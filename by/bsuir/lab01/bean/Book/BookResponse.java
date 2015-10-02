package by.bsuir.lab01.bean.Book;

import by.bsuir.lab01.bean.Response;
import by.bsuir.lab01.entity.Book;
import by.bsuir.lab01.entity.Entity;

import java.util.ArrayList;

public class BookResponse extends Response {

    private ArrayList<Entity> books;
    private Book book;

    public ArrayList<Entity> getBooks() {
        return this.books;
    }

    public void setBooks(ArrayList<Entity> books) {
        this.books = books;
    }

    public Book getBook() {
        return this.book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

}
