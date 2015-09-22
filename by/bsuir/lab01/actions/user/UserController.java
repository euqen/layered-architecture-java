package by.bsuir.lab01.actions.user;

import by.bsuir.lab01.bean.SignInRequest;
import by.bsuir.lab01.bean.Response;
import by.bsuir.lab01.bean.Request;
import by.bsuir.lab01.command.Command;
import by.bsuir.lab01.command.CommandException;
import by.bsuir.lab01.command.CommandHelper;
import by.bsuir.lab01.view.View;


public class UserController {

    private CommandHelper commandList = new CommandHelper();

    public void signIn(String username, String password) {

        SignInRequest signInRequest = new SignInRequest();
        signInRequest.setUsername(username);
        signInRequest.setPassword(password);
        signInRequest.setCommandName("SIGN_IN");
        this.executeRequest(signInRequest);

    }

    public void signUp(String username, String password) {

        SignInRequest signInRequest = new SignInRequest();
        signInRequest.setUsername(username);
        signInRequest.setPassword(password);
        signInRequest.setCommandName("SIGN_UP");

        Response response = this.executeRequest(signInRequest);

        String message = null;

        if (response.getStatus() == 200) {
            View.notification(response.getSuccessMessage());
        }
        else {
            View.alert(response.getErrorMessage());
        }

    }

    public void singOut() {

    }

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
