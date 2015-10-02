package by.bsuir.lab01.actions.user.signOut.contracts;

import by.bsuir.lab01.actions.Contract;
import by.bsuir.lab01.bean.Request;
import by.bsuir.lab01.actions.Validators;
import by.bsuir.lab01.command.CommandException;
import by.bsuir.lab01.entity.User;


public class SignOutUserContract extends Validators implements Contract {

    @Override
    public void validate(Request req) throws CommandException {

    }

    @Override
    public User getContractData(Request req) {
        return new User();
    }
}
