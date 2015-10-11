package by.bsuir.lab01.bean.User;

import by.bsuir.lab01.bean.Response;
import by.bsuir.lab01.entity.User;

public class UserResponse extends Response {

    private User user;
    private String autoAuthError;

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setAutoAuthError(String error) {
        this.autoAuthError = error;
    }

    public String getAutoAuthError() {
        return this.autoAuthError;
    }

    public boolean hasErrors() {
        if (autoAuthError != null || this.getErrorMessage() != null) {
            return true;
        }

        return false;
    }
}
