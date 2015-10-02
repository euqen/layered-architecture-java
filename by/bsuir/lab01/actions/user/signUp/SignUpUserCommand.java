package by.bsuir.lab01.actions.user.signUp;

import by.bsuir.lab01.actions.user.signUp.contracts.SignUpUserContract;
import by.bsuir.lab01.bean.Request;
import by.bsuir.lab01.bean.Response;
import by.bsuir.lab01.bean.User.UserResponse;
import by.bsuir.lab01.command.Command;
import by.bsuir.lab01.command.CommandException;
import by.bsuir.lab01.entity.User;
import by.bsuir.lab01.service.ServiceException;
import by.bsuir.lab01.service.UserService;

import java.util.Map;

public class SignUpUserCommand extends Command {

    @Override
    public Response execute(Request request) {
        UserResponse response = new UserResponse();

        SignUpUserContract signUpContract = new SignUpUserContract();

        User user;

        try {
            signUpContract.validate(request);
            User contractData = signUpContract.getContractData(request);

            try {
                user = (User)UserService.findOne(contractData);
                UserService.insert(contractData);
            }
            catch(ServiceException e) {
                throw new CommandException(e.getMessage(), e);
            }
        }
        catch(CommandException e) {
            response.setErrorMessage(e.getMessage());
            response.setStatus(INTERNAL_ERROR);
            return response;
        }

        response.setSuccessMessage("User successfully signed in!");
        response.setUser(user);
        response.setStatus(SUCCEED);
        return response;
    }

}
