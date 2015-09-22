package by.bsuir.lab01.bean;

public class SignInRequest extends Request {

    private String password;
    private String username;

    public void setPassword(String password) {

        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }
}
