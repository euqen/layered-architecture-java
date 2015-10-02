package by.bsuir.lab01.bean.User;

import by.bsuir.lab01.bean.Request;
import by.bsuir.lab01.bean.Response;

public class UserRequest extends Request {

    private String username;
    private String password;

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
