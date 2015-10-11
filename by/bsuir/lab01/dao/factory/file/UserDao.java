package by.bsuir.lab01.dao.factory.file;

import by.bsuir.lab01.dao.DaoException;
import by.bsuir.lab01.entity.Entity;
import by.bsuir.lab01.entity.User;
import by.bsuir.lab01.view.*;
import by.bsuir.lab01.view.Console;

import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public final class UserDao extends FileDaoFactory {

    private UserDao() {}

    private static final UserDao instance = new UserDao();

    public static UserDao getInstance() {
        return instance;
    }

    private final String origin = "/home/euqen/src/by/bsuir/lab01/source/users.txt";
    private final String authOrigin = "/home/euqen/src/by/bsuir/lab01/source/auth.txt";

    public Boolean isSudoUser() throws DaoException {
        File file = new File(authOrigin);

        try {
            this.isOriginExists(file);
        }
        catch (DaoException e) {
            throw new DaoException(e.getMessage(), e);
        }

        Boolean result = false;

        try {
            BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));

            try {
                String line;
                if ((line = in.readLine()) != null) {
                    String username = ""; Integer pos = 0;
                    String password = ""; String isSudoField = "";

                    for(Integer i = 0; i < line.length(); i++) {
                        if (line.charAt(i) != ':') {
                            username += line.charAt(i);
                        }
                        else {
                            pos = ++i;
                            break;
                        }
                    }

                    for (Integer i = pos; i < line.length(); i++) {
                        if (line.charAt(i) != ':') {
                            password += line.charAt(i);
                        }
                        else {
                            pos = ++i;
                            break;
                        }
                    }

                    for (Integer i = pos; i < line.length(); i++) {
                        isSudoField += line.charAt(i);
                    }

                    if (isSudoField.contentEquals("sudo")) {
                        return true;
                    }

                    return false;
                }
            }
            finally {
                in.close();
            }
        }
        catch (IOException e) {
            throw new DaoException(e.getMessage(), e);
        }

        return result;

    }

    public User getTemporaryAuthData() throws DaoException {
        File file = new File(authOrigin);

        try {
            this.isOriginExists(file);
        }
        catch (DaoException e) {
            throw new DaoException(e.getMessage(), e);
        }

        User result = new User();

        try {
            BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));

            try {
                String line;
                if ((line = in.readLine()) != null) {
                    String username = ""; Integer pos = 0;
                    String password = "";

                    for(Integer i = 0; i < line.length(); i++) {
                        if (line.charAt(i) != ':') {
                            username += line.charAt(i);
                        }
                        else {
                            pos = ++i;
                            break;
                        }
                    }

                    for (Integer i = pos; i < line.length(); i++) {
                        if (line.charAt(i) != ':') {
                            password += line.charAt(i);
                        }
                        else {
                            break;
                        }
                    }

                    result.username = username;
                    result.password = password;
                }
            }
            finally {
                in.close();
            }
        }
        catch (IOException e) {
            throw new DaoException(e.getMessage(), e);
        }

        return result;
    }

    @Override
    public ArrayList<Entity> find() throws DaoException {
        File file = new File(origin);

        try {
            this.isOriginExists(file);
        }
        catch (DaoException e) {
            throw new DaoException(e.getMessage(), e);
        }

        ArrayList<Entity> resultSet = new ArrayList<>();

        try {
            BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));

            try {
                String line;
                while ((line = in.readLine()) != null) {
                    User user = new User();
                    user.username = line; //TO DO get author
                    resultSet.add(user);
                }
            }
            finally {
                in.close();
            }
        }
        catch (IOException e) {
            throw new DaoException(e.getMessage(), e);
        }

        return resultSet;
    }

    @Override
    public User findOne(Entity user) throws DaoException {
        File file = new File(origin);

        try {
            this.isOriginExists(file);
        }
        catch (DaoException e) {
            throw new DaoException(e.getMessage(), e);
        }

        User query = (User)user;
        User result = new User();

        try {
            BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));

            try {
                String line;
                while ((line = in.readLine()) != null) {
                    String username = ""; Integer pos = 0;
                    String password = "";

                    for(Integer i = 0; i < line.length(); i++) {
                        if (line.charAt(i) != ':') {
                            username += line.charAt(i);
                        }
                        else {
                            pos = ++i;
                            break;
                        }
                    }

                    for (Integer i = pos; i < line.length(); i++) {
                            password += line.charAt(i);
                    }

                    if (query.username.contentEquals(username)) {
                        result.username = username;
                        if (sha1(query.password).contentEquals(password)) {
                            result.password = password;
                        }
                        else if (query.password.contentEquals(password)) {
                            result.password = password;
                        }

                        break;
                    }
                }
            }
            finally {
                in.close();
            }
        }
        catch (IOException e) {
            throw new DaoException(e.getMessage(), e);
        }

        return result;
    }

    @Override
    public void insert(Entity user) throws DaoException {
        File file = new File(origin);

        try {
            this.isOriginExists(file);
        }
        catch (DaoException e) {
            throw new DaoException(e.getMessage(), e);
        }

        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(origin, true)));
            User query = (User)user;

            String hash = sha1(query.password);

            try {
                out.println(query.username + ':' + hash);
            }
            finally {
                out.close();
            }
        }
        catch(IOException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }


    public void signIn(Entity user) throws DaoException {
        File file = new File(authOrigin);

        try {
            this.isOriginExists(file);
        }
        catch (DaoException e) {
            try {
                file.createNewFile();
            }
            catch (IOException ex) {
                throw new DaoException(ex.getMessage(), e);
            }
        }

        try {
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());
            User query = (User)user;

            String hash = sha1(query.password);

            try {
                out.println(query.username + ":" + hash);
            }
            finally {
                out.close();
            }
        }
        catch(IOException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    public void signOut() throws DaoException {
        File file = new File(authOrigin);

        try {
            this.isOriginExists(file);
            try {
                file.delete();
            }
            catch (Exception e) {
                throw new DaoException(e.getMessage(), e);
            }
        }
        catch (DaoException e) {
            throw new DaoException(e.getMessage(), e);
        }

    }

    private void isOriginExists(File file) throws DaoException {
        if (!file.exists()) {
            throw new DaoException(file.getPath() + " does not exists! Please create it and redo this operation!");
        }
    }

    private String sha1(String text) throws DaoException {
        MessageDigest sha1;
        String hash;

        try {
            sha1 = MessageDigest.getInstance("SHA");
        }
        catch (NoSuchAlgorithmException e) {
            throw new DaoException(e.getMessage(), e);
        }

        sha1.update(text.getBytes());
        byte[] digest = sha1.digest();
        BigInteger hashedBytes = new BigInteger(1, digest);
        hash = hashedBytes.toString(16);

        return hash;
    }
}
