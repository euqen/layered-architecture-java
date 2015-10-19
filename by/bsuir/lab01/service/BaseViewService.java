package by.bsuir.lab01.service;

import by.bsuir.lab01.dao.DaoException;
import by.bsuir.lab01.dao.DaoFactory;
import by.bsuir.lab01.entity.Entity;

import java.util.ArrayList;

public class BaseViewService {

	/**
	 * Base insert method which call specific factory depending on type of passed object.
	 *
	 * @param entity
	 * @throws ServiceException
	 */
	public static void insert(Entity entity) throws ServiceException {
		DaoFactory daoFactory = DaoFactory.getDao(entity);

		try {
			daoFactory.insert(entity);
		}
		catch (DaoException e) {
			throw new ServiceException(e.getMessage(), e);
		}

	}

	/**
	 * Base find method which call specific factory depending on type of passed object.
	 *
	 * @param entity
	 * @return First found entity or null
	 * @throws ServiceException
	 */
	public static Entity findOne(Entity entity) throws ServiceException {
		DaoFactory daoFactory = DaoFactory.getDao(entity);

		Entity result;

		try {
			result = daoFactory.findOne(entity);
		}
		catch (DaoException e) {
			throw new ServiceException(e.getMessage(), e);
		}

		return result;
	}

	/**
	 * Base find method which call specific factory depending on type of passed object.
	 *
	 * @param entity
	 * @return All found entities
	 * @throws ServiceException
	 */
	public static ArrayList<Entity> find(Entity entity) throws  ServiceException {
		DaoFactory daoFactory = DaoFactory.getDao(entity);

		ArrayList<Entity> result;

		try {
			result = daoFactory.find();
		}
		catch (DaoException e) {
			throw new ServiceException(e.getMessage(), e);
		}

		return result;
	}
}
