package by.bsuir.lab01.actions;

import by.bsuir.lab01.bean.Request;
import by.bsuir.lab01.bean.Response;
import by.bsuir.lab01.command.Command;
import by.bsuir.lab01.command.CommandException;
import by.bsuir.lab01.command.CommandHelper;
import by.bsuir.lab01.view.Console;

public class Controller {

    private CommandHelper commandList = new CommandHelper();

    /**
     * Render specific message type depending on response status.
     *
     * @param response
     */
    protected void render(Response response) {
        if (response.getStatus() == 200) {
            Console.notification(response.getSuccessMessage());
        }
        else if (response.getStatus() == 500) {
            Console.warning(response.getErrorMessage());
        }
        else {
            Console.alert(response.getErrorMessage());
        }
    }

    /**
     * Execute specific request depending on command name
     *
     * @param request
     * @return
     */

    protected Response executeRequest(Request request) {
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
