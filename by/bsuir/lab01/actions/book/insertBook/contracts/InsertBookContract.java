package by.bsuir.lab01.actions.book.insertBook.contracts;

import by.bsuir.lab01.actions.Contract;
import by.bsuir.lab01.bean.Book.BookRequest;
import by.bsuir.lab01.bean.Request;
import by.bsuir.lab01.actions.Validators;
import by.bsuir.lab01.command.CommandException;
import by.bsuir.lab01.entity.Book;


public class InsertBookContract extends Validators implements Contract {

    /**
     * Request fields validation.
     *
     * @param req
     * @throws CommandException
     */
    @Override
    public void validate(Request req) throws CommandException {

        BookRequest request = (BookRequest) req;

        String title = request.getTitle();
        title = title.trim();
        title = Capitalize(title);

        String author = request.getAuthor();
        author = author.trim();
        author = Capitalize(author);

        if (!this.between(title, 1, 50)) {
            throw new CommandException("Title should be from 1 to 50 characters");
        }

        if (!this.between(author, 2, 50)) {
            throw new CommandException("Author should be from 2 to 50 characters");
        }

        request.setTitle(title);
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

        contractData.title = request.getTitle();
        contractData.author = request.getAuthor();

        return contractData;
    }
}
