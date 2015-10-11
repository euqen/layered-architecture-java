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

    private final String origin = "/home/euqen/src/by/bsuir/lab01/source/books.txt";

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
                    Book book = new Book();
                    String title = ""; Integer pos = 0;
                    String author = "";

                    for(Integer i = 0; i < line.length(); i++) {
                        if (line.charAt(i) != ':') {
                            title += line.charAt(i);
                        }
                        else {
                            pos = ++i;
                            break;
                        }
                    }

                    for (Integer i = pos; i < line.length(); i++) {
                        author += line.charAt(i);
                    }

                    book.title = title;
                    book.author = author;

                    resultSet.add(book);
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
    public Entity findOne(Entity book) throws DaoException {
        File file = new File(origin);

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
                    String title = ""; Integer pos = 0;
                    String author = "";

                    for(Integer i = 0; i < line.length(); i++) {
                        if (line.charAt(i) != ':') {
                            title += line.charAt(i);
                        }
                        else {
                            pos = i++;
                            break;
                        }
                    }

                    for (Integer i = pos; i < line.length(); i++) {
                        author += line.charAt(i);
                    }

                    if (query.title != null && query.title.contentEquals(title)) {
                        result.title = title;
                        break;
                    }

                    if (query.author != null && query.author.contentEquals(author)) {
                        result.author = author;
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

    public void insert(Entity book) throws DaoException {
        File file = new File(origin);

        try {
            this.isOriginExists(file);
        }
        catch (DaoException e) {
            throw new DaoException(e.getMessage(), e);
        }

        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(origin, true)));
            Book query = (Book)book;

            try {
                out.println(query.title + ":" + query.author);
            }
            finally {
                out.close();
            }
        }
        catch(IOException e) {
            throw new DaoException(e.getMessage(), e);
        }

    }

    public ArrayList<Entity> findByAuthor(Book query) throws DaoException {
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
                    Book book = new Book();
                    String title = ""; Integer pos = 0;
                    String author = "";

                    for(Integer i = 0; i < line.length(); i++) {
                        if (line.charAt(i) != ':') {
                            title += line.charAt(i);
                        }
                        else {
                            pos = ++i;
                            break;
                        }
                    }

                    for (Integer i = pos; i < line.length(); i++) {
                        author += line.charAt(i);
                    }

                    if (query.author.contentEquals(author)) {
                        book.title = title;
                        book.author = author;
                        resultSet.add(book);
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

        return resultSet;
    }

    public ArrayList<Entity> findByTitle(Book query) throws DaoException {
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
                    Book book = new Book();
                    String title = ""; Integer pos = 0;
                    String author = "";

                    for(Integer i = 0; i < line.length(); i++) {
                        if (line.charAt(i) != ':') {
                            title += line.charAt(i);
                        }
                        else {
                            pos = ++i;
                            break;
                        }
                    }

                    for (Integer i = pos; i < line.length(); i++) {
                        author += line.charAt(i);
                    }

                    if (query.title.contentEquals(title)) {
                        book.title = title;
                        book.author = author;
                        resultSet.add(book);
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

        return resultSet;
    }


    private void isOriginExists(File file) throws DaoException {
        if (!file.exists()) {
            throw new DaoException("Data origin does not exists!");
        }
    }
}
