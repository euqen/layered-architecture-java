package by.bsuir.lab01.service;

import by.bsuir.lab01.dao.DaoException;
import by.bsuir.lab01.dao.DaoFactory;
import by.bsuir.lab01.dao.factory.file.BookDao;
import by.bsuir.lab01.entity.Book;
import by.bsuir.lab01.entity.Entity;

import java.util.ArrayList;

public final class BookService extends BaseViewService {

    /**
     * Provide a service which getting all books using author field.
     *
     * @param book
     * @return Collection of found entities
     * @throws ServiceException
     */
    public static ArrayList<Entity> findByAuthor(Book book) throws ServiceException {
        BookDao bookDao = (BookDao)DaoFactory.getDao(book);

        ArrayList<Entity> result;

        try {
            result = bookDao.findByAuthor(book);
        }
        catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }

        return result;
    }

    /**
     * Provide a service which getting all books using title field.
     *
     * @param book
     * @return Collection of found entities
     * @throws ServiceException
     */
    public static ArrayList<Entity> findByTitle(Book book) throws ServiceException {
        BookDao bookDao = (BookDao)DaoFactory.getDao(book);

        ArrayList<Entity> result;

        try {
            result = bookDao.findByTitle(book);
        }
        catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }

        return result;
    }

}
