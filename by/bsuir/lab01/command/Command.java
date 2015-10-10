package by.bsuir.lab01.command;

import by.bsuir.lab01.bean.Request;
import by.bsuir.lab01.bean.Response;

public abstract class Command {
	public final Integer SUCCEED = 200;
	public final Integer INTERNAL_ERROR = 500;
	public final Integer NO_CONTENT = 204;
	public abstract Response execute(Request request) throws CommandException;
}
