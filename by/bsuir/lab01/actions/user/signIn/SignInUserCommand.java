package by.bsuir.lab01.actions.user.signIn;

import by.bsuir.lab01.bean.Request;
import by.bsuir.lab01.bean.Response;
import by.bsuir.lab01.command.Command;
import by.bsuir.lab01.actions.user.signIn.contracts.SignInUserContract;
import by.bsuir.lab01.command.CommandException;
import by.bsuir.lab01.service.ServiceException;
import by.bsuir.lab01.service.UserService;

import java.util.Map;

public class SignInUserCommand implements Command {

	@Override
	public Response execute(Request request) {
		Response response = new Response();

		SignInUserContract signInContract = new SignInUserContract();

		try {
			signInContract.validate(request);
		}
		catch(CommandException e) {
			response.setErrorMessage(e.getMessage());
			return response;
		}

		Map<String, String> contractData = signInContract.getContractData(request);

		boolean isExists = false;

		try {
			isExists = UserService.getByUserName(contractData.get("username"));
		}
		catch(ServiceException e) {
			response.setErrorMessage(e.getMessage());
			return response;
		}

		if (!isExists) {
			response.setErrorMessage("User with this login does not exists");
			return response;
		}

		boolean isSignedIn = UserService.signIn(contractData);

		if (!isSignedIn) {
			response.setErrorMessage("Something wrong");
			response.setStatus(500);
			return response;
		}

		response.setSuccessMessage("User successfully signed in");
		response.setStatus(200);
		return response;
	}

}
