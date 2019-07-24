package com.chilly.dome.entity;

public class Book {
    private int id;
    private String bookName;
    private String bookIntro;

    public int getId() {
        return id;
    }

    public String getBookName() {
        return bookName;
    }

    public String getBookIntro() {
        return bookIntro;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setBookIntro(String bookIntro) {
        this.bookIntro = bookIntro;
    }
}
