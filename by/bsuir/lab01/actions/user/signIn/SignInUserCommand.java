package by.bsuir.lab01.actions.user.signIn;

import by.bsuir.lab01.bean.Request;
import by.bsuir.lab01.bean.Response;
import by.bsuir.lab01.bean.User.UserResponse;
import by.bsuir.lab01.command.Command;
import by.bsuir.lab01.actions.user.signIn.contracts.SignInUserContract;
import by.bsuir.lab01.command.CommandException;
import by.bsuir.lab01.entity.User;
import by.bsuir.lab01.service.ServiceException;
import by.bsuir.lab01.service.UserService;
import by.bsuir.lab01.view.Console;

public class SignInUserCommand extends Command {

	@Override
	public Response execute(Request request) {
		UserResponse response = new UserResponse();

		SignInUserContract signInContract = new SignInUserContract();

		User result = null;

		try {
			signInContract.validate(request);
			User contractData = signInContract.getContractData(request);

			try {
				result = (User)UserService.findOne(contractData);

				if (!result.exists()) {
					throw new CommandException("User " + contractData.username + " does not exists!");
				}

				if (!result.isPasswordCorrect()) {
					throw new CommandException("Oops! Incorrect password!");
				}

				UserService.signIn(contractData);
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

		response.setSuccessMessage("User successfully signed in");
		response.setUser(result);
		response.setStatus(SUCCEED);
		return response;
	}

}
