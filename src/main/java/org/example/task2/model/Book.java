package org.example.task2.model;

import java.util.Collections;
import java.util.List;

public class Book {

    private final String text;
    private final List<Book> childs;

    public Book(String text, List<Book> childs) {
        this.text = text;
        this.childs = childs;
    }

    public Book(String text) {
        this(text, Collections.emptyList());
    }

    public Book(List<Book> childs) {
        this("", childs);
    }

    public String getText() {
        return text;
    }

    public List<Book> getChilds() {
        return childs;
    }

    @Override
    public String toString() {
        return "Book{" +
                "text='" + text + '\'' +
                ", childs=" + childs +
                '}';
    }
}
