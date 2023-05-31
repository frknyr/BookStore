package entities.concretes;

import entities.abstracts.IEntities;

public class Book implements IEntities {
    private int book_id;
    private int category_id;
    private String category_name;
    private int author_id;
    private String author_name;
    private String book_name;
    private String book_explanation;
    private String book_year;
    private double book_price;

    public Book(int book_id, int category_id, int author_id, String book_name, String book_explanation, String book_year
            , double book_price) {
        this.book_id = book_id;
        this.category_id = category_id;
        this.author_id = author_id;
        this.book_name = book_name;
        this.book_explanation = book_explanation;
        this.book_year = book_year;
        this.book_price = book_price;
    }

    public Book(int category_id, int author_id, String book_name, String book_explanation, String book_year, double book_price) {
        this.category_id = category_id;
        this.author_id = author_id;
        this.book_name = book_name;
        this.book_explanation = book_explanation;
        this.book_year = book_year;
        this.book_price = book_price;
    }

    public Book(int book_id, int category_id, String category_name, int author_id,
                String author_name, String book_name, String book_explanation, String book_year, double book_price) {
        this.book_id = book_id;
        this.category_id = category_id;
        this.category_name = category_name;
        this.author_id = author_id;
        this.author_name = author_name;
        this.book_name = book_name;
        this.book_explanation = book_explanation;
        this.book_year = book_year;
        this.book_price = book_price;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getBook_explanation() {
        return book_explanation;
    }

    public void setBook_explanation(String book_explanation) {
        this.book_explanation = book_explanation;
    }

    public String getBook_year() {
        return book_year;
    }

    public void setBook_year(String book_year) {
        this.book_year = book_year;
    }

    public double getBook_price() {
        return book_price;
    }

    public void setBook_price(double book_price) {
        this.book_price = book_price;
    }
}
