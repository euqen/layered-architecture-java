package by.bsuir.lab01.command;

import by.bsuir.lab01.actions.book.addNewBook.AddNewBookCommand;
import by.bsuir.lab01.actions.user.signIn.SignInUserCommand;

import java.util.HashMap;
import java.util.Map;

public final class CommandHelper {
	private Map<CommandName, Command> commands = new HashMap<CommandName, Command>();
	
	public CommandHelper(){
		commands.put(CommandName.ADD_NEW_BOOK, new AddNewBookCommand());
		commands.put(CommandName.LOGIN_USER, new SignInUserCommand());
	}	
	
	public Command getCommand(String commandName){
		CommandName command = CommandName.valueOf(commandName);
		return commands.get(command);		
	}
}
