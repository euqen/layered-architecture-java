package by.bsuir.lab01.actions.user;

import by.bsuir.lab01.actions.Controller;
import by.bsuir.lab01.bean.*;
import by.bsuir.lab01.bean.User.UserRequest;
import by.bsuir.lab01.bean.User.UserResponse;
import by.bsuir.lab01.entity.User;
import by.bsuir.lab01.view.Console;

public class UserController extends Controller {

    public void signIn(String username, String password) {

        UserRequest request = new UserRequest();
        request.setUsername(username);
        request.setPassword(password);
        request.setCommandName("SIGN_IN");
        UserResponse response = (UserResponse)this.executeRequest(request);

        this.render(response);
        this.renderUser(response.getUser());
    }

    public void signUp(String username, String password) {

        UserRequest request = new UserRequest();
        request.setUsername(username);
        request.setPassword(password);
        request.setCommandName("SIGN_UP");

        UserResponse response = (UserResponse)this.executeRequest(request);

        this.render(response);
        this.renderUser(response.getUser());
    }

    public void signOut() {
        UserRequest request = new UserRequest();
        request.setCommandName("SIGN_OUT");

        UserResponse response = (UserResponse)this.executeRequest(request);

        this.render(response);
    }

    private void renderUser(User user) {
        Console.println("Username:" + user.username);
    }

}