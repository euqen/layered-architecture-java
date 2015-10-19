package by.bsuir.lab01.actions.book.getBook.contracts;

import by.bsuir.lab01.actions.Contract;
import by.bsuir.lab01.actions.Validators;
import by.bsuir.lab01.bean.*;
import by.bsuir.lab01.bean.Book.BookRequest;
import by.bsuir.lab01.command.CommandException;
import by.bsuir.lab01.entity.Book;

public class GetByAuthorContract extends Validators implements Contract {

    /**
     * Request fields validation.
     *
     * @param req
     * @throws CommandException
     */
    @Override
    public void validate(Request req) throws CommandException {
        BookRequest request = (BookRequest)req;

        String author = request.getAuthor();
        author = author.trim();
        author = Capitalize(author);

        if (this.isEmpty(author)) {
            throw new CommandException("Author field should not be empty!");
        }

        request.setAuthor(author);
    }

    /**
     * Get query data for pass it into service.
     *
     * @param req
     * @return Book data
     */
    @Override
    public Book getContractData(Request req) {
        Book contractData = new Book();

        BookRequest request = (BookRequest) req;

        contractData.author = request.getAuthor();

        return contractData;
    }
}
