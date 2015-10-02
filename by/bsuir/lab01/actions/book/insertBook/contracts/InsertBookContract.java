package by.bsuir.lab01.actions.book.insertBook.contracts;

import by.bsuir.lab01.actions.Contract;
import by.bsuir.lab01.bean.NewBookRequest;
import by.bsuir.lab01.bean.Request;
import by.bsuir.lab01.actions.Validators;
import by.bsuir.lab01.command.CommandException;
import by.bsuir.lab01.entity.Book;


public class InsertBookContract extends Validators implements Contract {

    @Override
    public void validate(Request req) throws CommandException {

        NewBookRequest request = (NewBookRequest) req;

        if (!this.between(request.getTitle(), 1, 50)) {
            throw new CommandException("Title should be from 1 to 50 characters");
        }

        if (!this.between(request.getAuthor(), 2, 50)) {
            throw new CommandException("Password should be from 2 to 50 characters");
        }

    }

    @Override
    public Book getContractData(Request req) {
        Book contractData = new Book();

        NewBookRequest request = (NewBookRequest) req;

        contractData.title = request.getTitle();
        contractData.author = request.getAuthor();

        return contractData;
    }
}
