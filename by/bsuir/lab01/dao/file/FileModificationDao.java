package by.bsuir.lab01.dao.file;

import by.bsuir.lab01.dao.DaoException;
import by.bsuir.lab01.dao.ModificationDao;

public final class FileModificationDao implements ModificationDao {
	private final static FileModificationDao instance = new FileModificationDao();
	
	private static final String fileName = "books.txt";//you must read it from property file
	
	private FileModificationDao(){}
	
	public static FileModificationDao getInstance(){
		return instance;
	}
	@Override
	public boolean addNewBook(String title) throws DaoException {
		
		/*try{
			// work with file here
		}catch(IOException ex){
			throw new DaoException("Dao ExceptionMessage", ex);
		}*/
		return false;
	}

}
