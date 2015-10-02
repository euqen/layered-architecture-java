package by.bsuir.lab01.actions;

import by.bsuir.lab01.bean.Request;
import by.bsuir.lab01.command.CommandException;
import by.bsuir.lab01.entity.Entity;

public interface Contract {
    void validate(Request request) throws CommandException;
    Entity getContractData(Request req);
}
