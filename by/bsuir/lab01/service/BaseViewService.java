package by.bsuir.lab01.service;

import by.bsuir.lab01.dao.DaoException;
import by.bsuir.lab01.dao.DaoFactory;
import by.bsuir.lab01.dao.ModificationDao;
import by.bsuir.lab01.entity.Book;
import by.bsuir.lab01.entity.Entity;

import java.util.ArrayList;
import java.util.Map;

public class BaseViewService {
	
	public static void insert(Entity entity) throws ServiceException {
		DaoFactory daoFactory = DaoFactory.getDao(entity);

		try {
			daoFactory.insert(entity);
		}
		catch (DaoException e) {
			throw new ServiceException(e.getMessage(), e);
		}

	}

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
