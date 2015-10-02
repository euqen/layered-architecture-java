package by.bsuir.lab01.bean.Book;

import by.bsuir.lab01.bean.Request;

public class BookRequest extends Request {
    private String title;
    private String author;
    private String type;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }


}
