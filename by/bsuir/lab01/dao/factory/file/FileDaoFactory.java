package by.bsuir.lab01.dao.factory.file;

import by.bsuir.lab01.dao.DaoException;
import by.bsuir.lab01.dao.DaoFactory;
import by.bsuir.lab01.entity.Book;
import by.bsuir.lab01.entity.Entity;
import by.bsuir.lab01.entity.User;

import java.util.ArrayList;

public abstract class FileDaoFactory extends DaoFactory {

	public static FileDaoFactory getInstance(Entity entity) {
		if (entity instanceof Book) {
			return BookDao.getInstance();
		}

		if (entity instanceof User) {
			return UserDao.getInstance();
		}

		return null;
	}

	public abstract ArrayList<Entity> find() throws DaoException;
	public abstract Entity findOne(Entity entity) throws DaoException;
	public abstract void insert(Entity entity) throws DaoException;

}
