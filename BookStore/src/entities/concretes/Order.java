package entities.concretes;

import entities.abstracts.IEntities;

import java.util.Date;

public class Order implements IEntities {
    private int order_id;
    private int customer_id;
    private String customer_nameSurname;
    private int author_id;
    private String author_nameSurname;
    private int book_id;
    private String book_name;
    private int order_amount;
    private double order_unitPrice;
    private double order_totalPrice;
    private Date time;

    public Order(int order_id, int customer_id, String customer_nameSurname, int author_id, String author_nameSurname,
                 int book_id, String book_name, int order_amount, double order_unitPrice, double order_totalPrice, Date time) {
        this.order_id = order_id;
        this.customer_id = customer_id;
        this.customer_nameSurname = customer_nameSurname;
        this.author_id = author_id;
        this.author_nameSurname = author_nameSurname;
        this.book_id = book_id;
        this.book_name = book_name;
        this.order_amount = order_amount;
        this.order_unitPrice = order_unitPrice;
        this.order_totalPrice = order_totalPrice;
        this.time = time;
    }


    public Order(int customer_id, int book_id, int order_amount) {
        this.customer_id = customer_id;
        this.book_id = book_id;
        this.order_amount = order_amount;
    }


    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getOrder_amount() {
        return order_amount;
    }

    public void setOrder_amount(int order_amount) {
        this.order_amount = order_amount;
    }

    public double getOrder_unitPrice() {
        return order_unitPrice;
    }

    public void setOrder_unitPrice(double order_unitPrice) {
        this.order_unitPrice = order_unitPrice;
    }

    public double getOrder_totalPrice() {
        return order_totalPrice;
    }

    public void setOrder_totalPrice(double order_totalPrice) {
        this.order_totalPrice = order_totalPrice;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getCustomer_nameSurname() {
        return customer_nameSurname;
    }

    public void setCustomer_nameSurname(String customer_nameSurname) {
        this.customer_nameSurname = customer_nameSurname;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public String getAuthor_nameSurname() {
        return author_nameSurname;
    }

    public void setAuthor_nameSurname(String author_nameSurname) {
        this.author_nameSurname = author_nameSurname;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }
}
