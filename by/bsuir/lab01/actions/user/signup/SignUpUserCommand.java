package by.bsuir.lab01.actions.user.signup;

import by.bsuir.lab01.actions.user.signup.contracts.SignUpUserContract;
import by.bsuir.lab01.bean.Request;
import by.bsuir.lab01.bean.Response;
import by.bsuir.lab01.command.Command;
import by.bsuir.lab01.command.CommandException;
import by.bsuir.lab01.service.ServiceException;
import by.bsuir.lab01.service.UserService;

import java.util.Map;

public class SignUpUserCommand implements Command {

    @Override
    public Response execute(Request request) {
        Response response = new Response();

        SignUpUserContract signUpContract = new SignUpUserContract();

        try {
            signUpContract.validate(request);
        }
        catch(CommandException e) {
            response.setErrorMessage(e.getMessage());
            return response;
        }

        Map<String, String> contractData = signUpContract.getContractData(request);

        boolean isExists = false;

        try {
            isExists = UserService.getByUserName(contractData.get("username"));
        }
        catch(ServiceException e) {
            response.setErrorMessage(e.getMessage());
            return response;
        }

        if (isExists) {
            response.setErrorMessage("User with this login already exists");
            return response;
        }

        boolean isSignedUp = UserService.signUp(contractData);

        if (!isSignedUp) {
            response.setErrorMessage("Something wrong");
            response.setStatus(500);
            return response;
        }

        response.setSuccessMessage("User successfully signed in");
        response.setStatus(200);
        return response;
    }


}
