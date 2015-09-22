package by.bsuir.lab01.bean;

import by.bsuir.lab01.bean.Request;
import by.bsuir.lab01.bean.Response;
import by.bsuir.lab01.command.CommandException;

import java.util.Map;

public interface Contract {
    void validate(Request request) throws CommandException;
    Map<String, String> getContractData(Request req);
}
