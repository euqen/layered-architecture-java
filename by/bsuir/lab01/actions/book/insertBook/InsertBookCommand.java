package by.bsuir.lab01.actions.book.insertBook;

import by.bsuir.lab01.actions.book.insertBook.contracts.InsertBookContract;
import by.bsuir.lab01.bean.Book.BookResponse;
import by.bsuir.lab01.bean.Request;
import by.bsuir.lab01.bean.Response;
import by.bsuir.lab01.command.CommandException;
import by.bsuir.lab01.command.Command;
import by.bsuir.lab01.entity.Book;
import by.bsuir.lab01.service.BaseViewService;
import by.bsuir.lab01.service.ServiceException;
import by.bsuir.lab01.service.UserService;

public class InsertBookCommand extends Command {

	@Override
	public Response execute(Request request) throws CommandException {
		BookResponse response = new BookResponse();
		InsertBookContract insertBookContract = new InsertBookContract();

		try {
			insertBookContract.validate(request);
			Book contractData = insertBookContract.getContractData(request);

			try {
				Boolean isSudo = UserService.isSudoUser();
				if (isSudo) {
					BaseViewService.insert(contractData);
				}
				else {
					throw new CommandException("You have no sudo rights to do this operation!");
				}
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

		response.setSuccessMessage("Book has been successfully inserted!");
		response.setStatus(SUCCEED);
		return response;
	}

}
