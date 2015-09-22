package by.bsuir.lab01.view;

import by.bsuir.lab01.bean.NewBookRequest;
import by.bsuir.lab01.bean.NewBookResponse;
import by.bsuir.lab01.bean.Response;
import by.bsuir.lab01.actions.user.UserController;

public class View {
	// view -> actions -> command(domain) -> service -> dao -> source
	private UserController userController = new UserController();

	public void menu(int command) {


	}

	public static void alert(String message) {

	}

	public static void warning(String message) {

	}

	public static void notification(String message) {

	}

	public void signIn() {
		String username;
		String password;

		System.out.println("Username:");
		username = System.console().readLine();
		System.out.println("Password:");
		password = System.console().readLine();

		userController.signIn(username, password);
	}

	public void signUp() {
		String username;
		String password;

		System.out.println("Username:");
		username = System.console().readLine();
		System.out.println("Password:");
		password = System.console().readLine();

		userController.signUp(username, password);
	}

}
