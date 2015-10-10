package by.bsuir.lab01.actions.user.autoSignIn;

import by.bsuir.lab01.actions.user.signIn.contracts.SignInUserContract;
import by.bsuir.lab01.bean.Request;
import by.bsuir.lab01.bean.Response;
import by.bsuir.lab01.bean.User.UserResponse;
import by.bsuir.lab01.command.Command;
import by.bsuir.lab01.command.CommandException;
import by.bsuir.lab01.entity.User;
import by.bsuir.lab01.service.ServiceException;
import by.bsuir.lab01.service.UserService;

public class AutoSignInCommand extends Command {

    @Override
    public Response execute(Request request) {
        UserResponse response = new UserResponse();

        User cookie = null;
        User result = null;
        try {
            try {
                cookie = UserService.getTemporaryAuthData();

                if (cookie.username == null || cookie.password == null) {
                    response.setAutoAuthError("Cookie is invalid! Please sign in or sign up again!");
                }
                else {
                    result = (User)UserService.findOne(cookie);

                    if (!result.exists() || !result.isPasswordCorrect()) {
                        response.setAutoAuthError("Password or username is incorrect! Please sign up or sign in again!");
                    }
                }

            }
            catch (ServiceException e) {
                throw new CommandException(e.getMessage(), e);
            }
        }
        catch (CommandException e) {
            response.setErrorMessage(e.getMessage());
            response.setStatus(INTERNAL_ERROR);
            return response;
        }

        if (response.hasErrors()) {
            response.setErrorMessage(response.getAutoAuthError());
            response.setStatus(NO_CONTENT);
        }
        else {
            response.setSuccessMessage("User successfully signed in");
            response.setUser(result);
            response.setStatus(SUCCEED);
        }

        return response;
    }


}
