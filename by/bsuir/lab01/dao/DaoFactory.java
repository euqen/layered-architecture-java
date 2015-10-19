package by.bsuir.lab01.dao;

import by.bsuir.lab01.dao.factory.file.FileDaoFactory;
import by.bsuir.lab01.entity.Entity;

import java.util.ArrayList;

public abstract class DaoFactory {

	private static final String DAO_TYPE = "file";

	/**
	 * Get concrete factory depending on using type of dao.
	 *
	 * @param entity
	 * @return Factory
	 */
	public static DaoFactory getDao(Entity entity) {
		if (DAO_TYPE.contentEquals("file")) {
			return FileDaoFactory.getInstance(entity);
		}

		return null;
	}

	public abstract ArrayList<Entity> find() throws DaoException;
	public abstract Entity findOne(Entity entity) throws DaoException;
	public abstract void insert(Entity entity) throws DaoException;

}
