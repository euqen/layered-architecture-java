package by.bsuir.lab01.view;

import by.bsuir.lab01.actions.book.BookController;
import by.bsuir.lab01.actions.user.UserController;

import java.util.Scanner;

public final class Console {
	// view -> actions -> command(domain) -> service -> dao -> source

	private Console() {}

	private static final Console instance = new Console();

	public static Console getInstance() {
		return instance;
	}

	private UserController userController = new UserController();
	private BookController bookController = new BookController();

	private Scanner input = new Scanner(System.in);

	private static final String ANSI_RESET = "\u001B[0m";
	private static final String ANSI_RED = "\u001B[31m";
	private static final String ANSI_GREEN = "\u001B[32m";
	private static final String ANSI_YELLOW = "\u001B[33m";

	public void showUserActions() {
		System.out.println("\n");
		System.out.println("Sign In: 1");
		System.out.println("SignUp: 2");
		System.out.print("> ");

		String command = input.next();

		if (command.contentEquals("1")) {
			this.signIn();
		} else if (command.contentEquals("2")){
			this.signUp();
		} else {
			this.warning("Oh, snap! There is no such command yet!");
		}
	}

	public void showBookActions() {
		System.out.println("\n");
		System.out.println("Find books by author: 1");
		System.out.println("Find books by title: 2");
		System.out.println("Find all books: 3");
		System.out.println("Insert new book: 4");
		System.out.println("Sign Out: 5");
		System.out.print("> ");

		String command = input.next();

		if (command.contentEquals("1")) {
			this.getByAuthor();
		} else if (command.contentEquals("2")) {
			this.getByTitle();
		} else if (command.contentEquals("3")) {
			this.getAll();
		} else if (command.contentEquals("4")) {
			this.insert();
		} else if (command.contentEquals("5")) {
			this.signOut();
		}
		else {
			this.warning("Oh, snap! There is no such command yet!");
		}
	}

	public void getByAuthor() {
		System.out.print("Author: ");
		String author = input.next();

		bookController.getByAuthor(author);
	}

	public void getByTitle() {
		System.out.print("Title: ");
		String title = input.next();

		bookController.getByTitle(title);
	}

	public void getAll() {
		bookController.getAll();
	}

	public void insert() {
		System.out.print("Author: ");
		String author = input.next();
		System.out.print("Title: ");
		String title = input.next();

		bookController.insert(author, title);
	}

	public void signIn() {
		String username;
		String password;

		System.out.print("Username: ");
		username = input.next();
		System.out.print("Password: ");
		password = input.next();

		userController.signIn(username, password);
	}

	public void signUp() {
		String username;
		String password;

		System.out.println("Username:");
		username = input.next();
		System.out.println("Password:");
		password = input.next();

		userController.signUp(username, password);
	}

	public void signOut() {
		userController.signOut();
	}

	public static void alert(String message) {
		System.out.print(ANSI_RED + "ERROR : ");
		System.out.print(message + ANSI_RESET);
	}

	public static void warning(String message) {
		System.out.print(ANSI_YELLOW + "WARN : ");
		System.out.print(message + ANSI_RESET);
	}

	public static void notification(String message) {
		System.out.println(ANSI_GREEN + message + ANSI_RESET);
	}

	public static void println(String message) {
		System.out.println(message);
	}
}
