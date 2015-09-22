package by.bsuir.lab01.service;

import by.bsuir.lab01.dao.DaoException;
import by.bsuir.lab01.dao.DaoFactory;
import by.bsuir.lab01.dao.ModificationDao;

public final class ModificationRepositoryService {
	private ModificationRepositoryService(){}
	
	public static boolean addNewBookService(String title) throws ServiceException {
		DaoFactory daoFactory = DaoFactory.getDaoFactory();
		ModificationDao modificationDao = daoFactory.getModificationDao();
		
		try {
			modificationDao.addNewBook(title);
		} catch (DaoException ex) {
			throw new ServiceException("Service Exception MEssage", ex);
		}
		return true;
	}
}
