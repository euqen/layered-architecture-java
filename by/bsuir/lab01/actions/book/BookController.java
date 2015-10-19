package by.bsuir.lab01.actions.book;

import by.bsuir.lab01.bean.Book.BookRequest;
import by.bsuir.lab01.actions.Controller;
import by.bsuir.lab01.bean.Book.BookResponse;
import by.bsuir.lab01.bean.Response;
import by.bsuir.lab01.entity.Book;
import by.bsuir.lab01.entity.Entity;
import by.bsuir.lab01.view.Console;

import java.util.ArrayList;
import java.util.Iterator;

public class BookController extends Controller {

	/**
	 * Sends a request to get books by author.
	 *
	 * @param author
	 */
	public void getByAuthor(String author) {
		BookRequest request = new BookRequest();
		request.setAuthor(author);
		request.setCommandName("GET_BY_AUTHOR");

		BookResponse response = (BookResponse)this.executeRequest(request);

		render(response);
		printBooks(response);

		Console console = Console.getInstance();
		console.showBookActions();
	}

	/**
	 * Sends a request to get books by title.
	 *
	 * @param title
	 */
	public void getByTitle(String title) {
		BookRequest request = new BookRequest();
		request.setTitle(title);
		request.setCommandName("GET_BY_TITLE");

		BookResponse response = (BookResponse)this.executeRequest(request);

		render(response);
		printBooks(response);

		Console console = Console.getInstance();
		console.showBookActions();
	}

	/**
	 * Sends a request to get all books.
	 */
	public void getAll() {
		BookRequest request = new BookRequest();
		request.setCommandName("GET_ALL");

		BookResponse response = (BookResponse)this.executeRequest(request);

		render(response);
		printBooks(response);

		Console console = Console.getInstance();
		console.showBookActions();
	}

	/**
	 * Sends a request to insert book.
	 *
	 * @param author
	 * @param title
	 */
	public void insert(String author, String title) {

		BookRequest request = new BookRequest();
		request.setAuthor(author);
		request.setTitle(title);
		request.setCommandName("INSERT_BOOK");

		Response response = this.executeRequest(request);
		render(response);

		Console console = Console.getInstance();
		console.showBookActions();
	}

	/**
	 * Call view to print books from response.
	 *
	 * @param response
	 */
	private void printBooks(BookResponse response) {
		ArrayList<Entity> books = response.getBooks();
		Iterator<Entity> iterator = books.iterator();

		while(iterator.hasNext()) {
			Book book = (Book)iterator.next();
			Console.println(book.title + " - " + book.author);
		}
	}
}
