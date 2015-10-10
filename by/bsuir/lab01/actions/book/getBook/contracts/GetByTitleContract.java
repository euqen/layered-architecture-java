package by.bsuir.lab01.actions.book.getBook.contracts;

import by.bsuir.lab01.actions.Contract;
import by.bsuir.lab01.actions.Validators;
import by.bsuir.lab01.bean.*;
import by.bsuir.lab01.bean.Book.BookRequest;
import by.bsuir.lab01.command.CommandException;
import by.bsuir.lab01.entity.Book;

public class GetByTitleContract extends Validators implements Contract {

    @Override
    public void validate(Request req) throws CommandException {

        BookRequest request = (BookRequest)req;

        String title = request.getTitle();
        title = title.trim();
        title = Capitalize(title);

        if (this.isEmpty(title)) {
            throw new CommandException("Title field should not be empty!");
        }

        request.setTitle(title);
    }

    @Override
    public Book getContractData(Request req) {
        Book contractData = new Book();

        BookRequest request = (BookRequest) req;

        contractData.title = request.getTitle();

        return contractData;
    }

}
