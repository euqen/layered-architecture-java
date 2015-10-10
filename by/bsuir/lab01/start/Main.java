package by.bsuir.lab01.start;

import by.bsuir.lab01.actions.user.UserController;
import by.bsuir.lab01.view.Console;

public class Main {

	public static void main(String[] args) {
		UserController userController = new UserController();
		Console console = Console.getInstance();

		if (userController.autoSignIn()) {
			console.showBookActions();
		}
		else {
			console.showUserActions();
		}

	}

}
