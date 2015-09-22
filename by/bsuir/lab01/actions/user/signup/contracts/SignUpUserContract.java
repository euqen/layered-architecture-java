package by.bsuir.lab01.actions.user.signup.contracts;

import by.bsuir.lab01.bean.Contract;
import by.bsuir.lab01.bean.Request;
import by.bsuir.lab01.bean.SignInRequest;
import by.bsuir.lab01.command.CommandException;

import java.util.HashMap;
import java.util.Map;

public class SignUpUserContract implements Contract {

    @Override
    public void validate(Request req) throws CommandException {

        SignInRequest request = (SignInRequest) req;

        if (!this.between(request.getUsername(), 2, 15)) {
            throw new CommandException("Username should be from 2 to 15 characters");
        }

        if (!this.between(request.getPassword(), 6, 20)) {
            throw new CommandException("Password should be from 6 to 20 characters");
        }

    }

    @Override
    public Map<String, String> getContractData(Request req) {
        Map<String, String> contractData = new HashMap<>();

        SignInRequest request = (SignInRequest) req;

        contractData.put("username", request.getUsername());
        contractData.put("password", request.getPassword());

        return contractData;
    }

    private Boolean isEmpty(String value) {
        if (value.length() == 0) {
            return true;
        }

        return false;
    }

    private Boolean between(String value, int from, int to) {
        int len = value.length();

        if (len >= from && len <= to) {
            return true;
        }

        return false;
    }
}