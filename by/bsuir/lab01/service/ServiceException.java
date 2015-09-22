package by.bsuir.lab01.service;

public class ServiceException extends Exception {
	private static final long serialVersionUID = 1L;

	public ServiceException(String message){
		super(message);
	}
	
	public ServiceException(String message, Exception ex){
		super(message, ex);
	}
}
