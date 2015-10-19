package by.bsuir.lab01.actions.user.signOut;

import by.bsuir.lab01.actions.user.signOut.contracts.SignOutUserContract;
import by.bsuir.lab01.bean.Request;
import by.bsuir.lab01.bean.Response;
import by.bsuir.lab01.bean.User.UserResponse;
import by.bsuir.lab01.command.Command;
import by.bsuir.lab01.command.CommandException;
import by.bsuir.lab01.entity.User;
import by.bsuir.lab01.service.ServiceException;
import by.bsuir.lab01.service.UserService;

public class SignOutUserCommand extends Command {

    /**
     * This command signing user out form the system.
     * Before using service performed request validation.
     *
     * @param request
     * @return response
     */
    @Override
    public Response execute(Request request) {
        UserResponse response = new UserResponse();

        SignOutUserContract signOutUserContract = new SignOutUserContract();

        try {
            signOutUserContract.validate(request);
            User user = signOutUserContract.getContractData(request);

            try {
                UserService.signOut(user);
            }
            catch (ServiceException e) {
                throw new CommandException(e.getMessage(), e);
            }

        }
        catch(CommandException e) {
            response.setErrorMessage(e.getMessage());
            response.setStatus(INTERNAL_ERROR);
            return response;
        }

        response.setSuccessMessage("You have been successfully signed out!");
        response.setStatus(SUCCEED);
        return response;
    }

}
