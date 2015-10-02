package by.bsuir.lab01.actions.book.getBook.contracts;

import by.bsuir.lab01.actions.Contract;
import by.bsuir.lab01.actions.Validators;
import by.bsuir.lab01.bean.*;
import by.bsuir.lab01.bean.Book.BookRequest;
import by.bsuir.lab01.command.CommandException;
import by.bsuir.lab01.entity.Book;

public class GetByAuthorContract extends Validators implements Contract {

    @Override
    public void validate(Request req) throws CommandException {
        BookRequest request = (BookRequest)req;

        if (this.isEmpty(request.getAuthor())) {
            throw new CommandException("Author field should not be empty!");
        }
    }

    @Override
    public Book getContractData(Request req) {
        Book contractData = new Book();

        BookRequest request = (BookRequest) req;

        contractData.author = request.getAuthor();

        return contractData;
    }
}
