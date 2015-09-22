package by.bsuir.lab01.command;

import by.bsuir.lab01.bean.Request;
import by.bsuir.lab01.bean.Response;

public interface Command {
	Response execute(Request request) throws CommandException;
}
