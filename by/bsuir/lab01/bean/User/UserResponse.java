package by.bsuir.lab01.bean.User;

import by.bsuir.lab01.bean.Response;
import by.bsuir.lab01.entity.User;

public class UserResponse extends Response {

    private User user;

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
