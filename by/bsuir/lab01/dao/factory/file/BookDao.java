package by.bsuir.lab01.dao.factory.file;

import by.bsuir.lab01.dao.DaoException;
import by.bsuir.lab01.entity.Book;
import by.bsuir.lab01.entity.Entity;

import java.io.*;
import java.util.ArrayList;

public final class BookDao extends FileDaoFactory {

    private BookDao() {}

    private static final BookDao instance = new BookDao();

    public static BookDao getInstance() {
        return instance;
    }


    @Override
    public ArrayList<Entity> find() throws DaoException {
        File file = new File("books.txt");

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
                    Book book = new Book();
                    book.title = line; //TO DO get author
                    resultSet.add(book);
                }
            }
            finally {
                in.close();
            }
        }
        catch (IOException e) {
            throw new DaoException("Error reading file", e);
        }

        return resultSet;
    }


    @Override
    public Entity findOne(Entity book) throws DaoException {
        File file = new File("books.txt");

        try {
            this.isOriginExists(file);
        }
        catch (DaoException e) {
            throw new DaoException(e.getMessage(), e);
        }

        Book query = (Book)book;
        Book result = new Book();

        try {
            BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));

            try {
                String line;
                while ((line = in.readLine()) != null) {
                    if (query.title != null) {
                        if (query.title.contentEquals(line)) {
                            result.title = line;
                            break;
                        }
                    }
                    if (query.author != null) {
                        //check equal with author
                    }
                }
            }
            finally {
                in.close();
            }
        }
        catch (IOException e) {
            throw new DaoException("Error reading file", e);
        }

        return result;
    }

    public void insert(Entity book) throws DaoException {
        File file = new File("books.txt");

        try {
            this.isOriginExists(file);
        }
        catch (DaoException e) {
            throw new DaoException(e.getMessage(), e);
        }

        try {
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());
            Book query = (Book)book;

            try {
                out.print(query.title);
            }
            finally {
                out.close();
            }
        }
        catch(IOException e) {
            throw new DaoException(e.getMessage(), e);
        }

    }

    private void isOriginExists(File file) throws DaoException {
        if (!file.exists()) {
            throw new DaoException("Data origin does not exists!");
        }
    }
}
