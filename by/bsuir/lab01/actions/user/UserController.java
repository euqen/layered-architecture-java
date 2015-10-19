package by.bsuir.lab01.actions.user;

import by.bsuir.lab01.actions.Controller;
import by.bsuir.lab01.bean.*;
import by.bsuir.lab01.bean.User.UserRequest;
import by.bsuir.lab01.bean.User.UserResponse;
import by.bsuir.lab01.entity.User;
import by.bsuir.lab01.view.Console;

public class UserController extends Controller {

    /**
     * Sends a request that makes an attempt to sign in automatically according to user,
     * who signed in ever.
     *
     * @return attempt result
     */
    public Boolean autoSignIn() {
        UserRequest request = new UserRequest();
        request.setCommandName("AUTO_SIGN_IN");
        UserResponse response = (UserResponse)this.executeRequest(request);
        this.render(response);
        if (!response.hasErrors()) {
            return true;
        }

        return false;
    }

    /**
     * Sends a request to sign in user.
     *
     * @param username
     * @param password
     */
    public void signIn(String username, String password) {

        UserRequest request = new UserRequest();
        request.setUsername(username);
        request.setPassword(password);
        request.setCommandName("SIGN_IN");
        UserResponse response = (UserResponse)this.executeRequest(request);

        this.render(response);

        Console console = Console.getInstance();
        if (response.getStatus() == 200) {
            console.showBookActions();
        }
        else {
            console.showUserActions();
        }
    }

    /**
     * Sends a request to sign up user.
     *
     * @param username
     * @param password
     */
    public void signUp(String username, String password) {

        UserRequest request = new UserRequest();
        request.setUsername(username);
        request.setPassword(password);
        request.setCommandName("SIGN_UP");

        UserResponse response = (UserResponse)this.executeRequest(request);
        this.render(response);
        Console console = Console.getInstance();

        if (response.getStatus() == 200) {
            this.signIn(username, password);
        }
        else {
            console.showUserActions();
        }

    }

    /**
     * Sends a request to sign out user.
     */
    public void signOut() {
        UserRequest request = new UserRequest();
        request.setCommandName("SIGN_OUT");

        UserResponse response = (UserResponse)this.executeRequest(request);

        this.render(response);

        Console console = Console.getInstance();
        console.showUserActions();
    }

}