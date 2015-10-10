package by.bsuir.lab01.entity;


import by.bsuir.lab01.view.Console;

public class User extends Entity {
    public String username;
    public String password;
    public String role;

    public Boolean exists() {
        if (username != null) {
            return true;
        }

        return false;
    }

    public Boolean isPasswordCorrect() {
        if (password != null) {
            return true;
        }

        return false;
    }

    public Boolean isAdmin() {
        if (role.contentEquals("Admin")) {
            return true;
        }

        return false;
    }
}
