package by.bsuir.lab01.dao;

import by.bsuir.lab01.dao.factoryimpl.FileDaoFactory;

public abstract class DaoFactory {
	private static final String DAO_TYPE = "file";//you must read it from property file
	
	public static DaoFactory getDaoFactory(){
		switch (DAO_TYPE){
		case "file":
			return FileDaoFactory.getInstance();
		}
		return null;
	}
	

	public abstract FindDao getFindDao();
	public abstract ModificationDao getModificationDao();
}
