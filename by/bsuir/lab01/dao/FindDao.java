package by.bsuir.lab01.dao;

import java.util.List;

import by.bsuir.lab01.entity.Book;

public interface FindDao {
	List<Book> findBookByAuthor(String author) throws DaoException;
}
