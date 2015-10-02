package by.bsuir.lab01.dao.factory.file;

import by.bsuir.lab01.dao.DaoException;
import by.bsuir.lab01.entity.Entity;

import java.util.ArrayList;

public final class UserDao extends FileDaoFactory {

    private UserDao() {}

    private static final UserDao instance = new UserDao();

    public static UserDao getInstance() {
        return instance;
    }

    @Override
    public ArrayList<Entity> find() throws DaoException {
        ArrayList<Entity> asd = new ArrayList<>();

        return asd;
    }

    @Override
    public Entity findOne(Entity user) throws DaoException {
        return new Entity();
    }

    @Override
    public void insert(Entity user) throws DaoException {

    }


    public void signIn(Entity user) throws DaoException {

    }

    public void signOut() throws DaoException {

    }

}
