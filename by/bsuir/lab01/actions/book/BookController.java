package by.bsuir.lab01.actions.book;

import by.bsuir.lab01.bean.Request;
import by.bsuir.lab01.bean.Response;
import by.bsuir.lab01.command.Command;
import by.bsuir.lab01.command.CommandException;
import by.bsuir.lab01.command.CommandHelper;

public class BookController {
	private CommandHelper commandList = new CommandHelper();

	private Response executeRequest(Request request) {
		Response response = null;
		try {
			String commandName = request.getCommandName();
			Command command = commandList.getCommand(commandName);
			response = command.execute(request);
		}
		catch(CommandException ex) {
			response = new Response();
			response.setErrorMessage("Error message!");
		}

		return response;		
	}
}
