package by.bsuir.lab01.dao.file;

import java.util.List;

import by.bsuir.lab01.dao.DaoException;
import by.bsuir.lab01.dao.FindDao;
import by.bsuir.lab01.entity.Book;

public final class FileFindDao implements FindDao {
	private final static FileFindDao instance = new FileFindDao();
	
	private FileFindDao(){}
	
	public static FileFindDao getInstance(){
		return instance;
	}
	
	public List<Book> findBookByAuthor(String author) throws DaoException{
		return null;
	}
}
