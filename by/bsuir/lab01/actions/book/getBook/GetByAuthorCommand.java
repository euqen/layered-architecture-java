package by.bsuir.lab01.actions.book.getBook;

import by.bsuir.lab01.actions.book.getBook.contracts.GetByAuthorContract;
import by.bsuir.lab01.bean.Book.BookResponse;
import by.bsuir.lab01.bean.Request;
import by.bsuir.lab01.bean.Response;
import by.bsuir.lab01.command.Command;
import by.bsuir.lab01.command.CommandException;
import by.bsuir.lab01.entity.Book;
import by.bsuir.lab01.entity.Entity;
import by.bsuir.lab01.service.BaseViewService;
import by.bsuir.lab01.service.BookService;
import by.bsuir.lab01.service.ServiceException;

import java.util.ArrayList;

public class GetByAuthorCommand extends Command {

    @Override
    public Response execute(Request request) {
        BookResponse response = new BookResponse();

        GetByAuthorContract getByAuthorContract = new GetByAuthorContract();

        ArrayList<Entity> result;

        try {
            getByAuthorContract.validate(request);
            Book contractData = getByAuthorContract.getContractData(request);

            try {
                result = BookService.findByAuthor(contractData);
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

        response.setSuccessMessage("Found " + result.size() + " book(s)");
        response.setBooks(result);
        response.setStatus(SUCCEED);
        return response;
    }

}
