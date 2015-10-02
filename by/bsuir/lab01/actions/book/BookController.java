package by.bsuir.lab01.actions.book;

import by.bsuir.lab01.bean.Book.BookRequest;
import by.bsuir.lab01.actions.Controller;
import by.bsuir.lab01.bean.Response;

public class BookController extends Controller {

	public void getByAuthor(String author) {
		BookRequest request = new BookRequest();
		request.setAuthor(author);
		request.setCommandName("GET_BY_AUTHOR");

		Response response = this.executeRequest(request);
		this.render(response);
	}

	public void getByTitle(String title) {
		BookRequest request = new BookRequest();
		request.setTitle(title);
		request.setCommandName("GET_BY_TITLE");

		Response response = this.executeRequest(request);
		this.render(response);
	}

	public void getAll() {
		BookRequest request = new BookRequest();
		request.setCommandName("GET_ALL");

		Response response = this.executeRequest(request);
		this.render(response);
	}

	public void insert(String author, String title) {

		BookRequest request = new BookRequest();
		request.setAuthor(author);
		request.setTitle(title);
		request.setCommandName("INSERT_BOOK");

		Response response = this.executeRequest(request);
		this.render(response);
	}
}
