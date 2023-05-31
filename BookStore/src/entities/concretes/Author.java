package entities.concretes;

import entities.abstracts.IEntities;

public class Author implements IEntities {
    private int author_id;
    private String author_name;
    private String author_surname;
    public Author(int author_id, String author_name, String author_surname) {
        this.author_id = author_id;
        this.author_name = author_name;
        this.author_surname = author_surname;
    }

    public Author(String author_name, String author_surname) {
        this.author_name = author_name;
        this.author_surname = author_surname;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public String getAuthor_name() {
        return author_name.toUpperCase();
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getAuthor_surname() {
        return author_surname.toUpperCase();
    }

    public void setAuthor_surname(String author_surname) {
        this.author_surname = author_surname;
    }
}
