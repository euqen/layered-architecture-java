package by.bsuir.lab01.service;

import by.bsuir.lab01.dao.DaoException;
import by.bsuir.lab01.dao.DaoFactory;
import by.bsuir.lab01.dao.factory.file.UserDao;
import by.bsuir.lab01.entity.User;

public final class UserService extends BaseViewService {

    public static User getTemporaryAuthData() throws ServiceException {
        UserDao userDao = (UserDao)DaoFactory.getDao(new User());

        User user;

        try {
           user = userDao.getTemporaryAuthData();
        }
        catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }

        return user;
    }

    public static Boolean isSudoUser() throws ServiceException {
        UserDao userDao = (UserDao)DaoFactory.getDao(new User());

        Boolean isSudoUser;
        try {
            isSudoUser = userDao.isSudoUser();
        }
        catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }

        return isSudoUser;
    }

    public static void signIn(User user) throws ServiceException {
        UserDao userDao = (UserDao)DaoFactory.getDao(user);

        try {
            userDao.signIn(user);
        }
        catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }

    }

    public static void signOut(User user) throws ServiceException {
        UserDao userDao = (UserDao)DaoFactory.getDao(user);

        try {
            userDao.signOut();
        }
        catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

}
