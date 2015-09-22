package by.bsuir.lab01.dao.factoryimpl;

import by.bsuir.lab01.dao.DaoFactory;
import by.bsuir.lab01.dao.FindDao;
import by.bsuir.lab01.dao.ModificationDao;
import by.bsuir.lab01.dao.file.FileFindDao;
import by.bsuir.lab01.dao.file.FileModificationDao;

public final class FileDaoFactory extends DaoFactory{
	private final static FileDaoFactory instance = new FileDaoFactory();
	
	private FileDaoFactory(){}
	
	public final static FileDaoFactory getInstance(){
		return instance;
	}
	
	@Override
	public FindDao getFindDao() {
		return FileFindDao.getInstance();
	}

	@Override
	public ModificationDao getModificationDao() {
		return FileModificationDao.getInstance();
	}

}
