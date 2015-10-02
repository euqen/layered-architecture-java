package by.bsuir.lab01.actions.book.getBook.contracts;

import by.bsuir.lab01.actions.Contract;
import by.bsuir.lab01.bean.Request;
import by.bsuir.lab01.actions.Validators;
import by.bsuir.lab01.command.CommandException;
import by.bsuir.lab01.entity.Book;

public class GetAllBooksContract extends Validators implements Contract {

    @Override
    public void validate(Request req) throws CommandException {

    }

    @Override
    public Book getContractData(Request req) {
       return null;
    }

}
