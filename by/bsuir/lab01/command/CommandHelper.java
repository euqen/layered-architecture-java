package by.bsuir.lab01.command;

import by.bsuir.lab01.actions.book.getBook.GetAllBooksCommand;
import by.bsuir.lab01.actions.book.getBook.GetByAuthorCommand;
import by.bsuir.lab01.actions.book.getBook.GetByTitleCommand;
import by.bsuir.lab01.actions.book.insertBook.InsertBookCommand;
import by.bsuir.lab01.actions.user.signIn.SignInUserCommand;
import by.bsuir.lab01.actions.user.signOut.SignOutUserCommand;
import by.bsuir.lab01.actions.user.signUp.SignUpUserCommand;

import java.util.HashMap;
import java.util.Map;

public final class CommandHelper {
	private Map<CommandName, Command> commands = new HashMap<CommandName, Command>();
	
	public CommandHelper() {
		commands.put(CommandName.SIGN_IN, new SignInUserCommand());
		commands.put(CommandName.SIGN_UP, new SignUpUserCommand());
		commands.put(CommandName.SIGN_OUT, new SignOutUserCommand());
		commands.put(CommandName.INSERT_BOOK, new InsertBookCommand());
		commands.put(CommandName.GET_ALL, new GetAllBooksCommand());
		commands.put(CommandName.GET_BY_AUTHOR, new GetByAuthorCommand());
		commands.put(CommandName.GET_BY_TITLE, new GetByTitleCommand());
	}	
	
	public Command getCommand(String commandName) {
		CommandName command = CommandName.valueOf(commandName);
		return commands.get(command);		
	}
}
