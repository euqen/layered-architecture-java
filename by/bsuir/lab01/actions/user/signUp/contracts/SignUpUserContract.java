package by.bsuir.lab01.actions.user.signUp.contracts;

import by.bsuir.lab01.actions.Contract;
import by.bsuir.lab01.actions.Validators;
import by.bsuir.lab01.bean.*;
import by.bsuir.lab01.bean.User.UserRequest;
import by.bsuir.lab01.command.CommandException;
import by.bsuir.lab01.entity.User;

public class SignUpUserContract extends Validators implements Contract {

    @Override
    public void validate(Request req) throws CommandException {

        UserRequest request = (UserRequest)req;

        if (!this.between(request.getUsername(), 2, 15)) {
            throw new CommandException("Username should be from 2 to 15 characters");
        }

        if (!this.between(request.getPassword(), 6, 20)) {
            throw new CommandException("Password should be from 6 to 20 characters");
        }

    }

    @Override
    public User getContractData(Request req) {
        User contractData = new User();

        UserRequest request = (UserRequest) req;

        contractData.username = request.getUsername();
        contractData.password = request.getPassword();

        return contractData;
    }

}