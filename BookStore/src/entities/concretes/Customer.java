package entities.concretes;

import entities.abstracts.IEntities;

public class Customer implements IEntities {
    private int customer_id;
    private String customer_name;
    private String customer_surname;
    private String customer_phoneNumber;
    private String customer_email;

    public Customer(int customer_id, String customer_name, String customer_surname, String customer_phoneNumber, String customer_email) {
        this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.customer_surname = customer_surname;
        this.customer_phoneNumber = customer_phoneNumber;
        this.customer_email = customer_email;
    }

    public Customer(String customer_name, String customer_surname, String customer_phoneNumber, String customer_email) {
        this.customer_name = customer_name;
        this.customer_surname = customer_surname;
        this.customer_phoneNumber = customer_phoneNumber;
        this.customer_email = customer_email;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_surname() {
        return customer_surname;
    }

    public void setCustomer_surname(String customer_surname) {
        this.customer_surname = customer_surname;
    }

    public String getCustomer_phoneNumber() {
        return customer_phoneNumber;
    }

    public void setCustomer_phoneNumber(String customer_phoneNumber) {
        this.customer_phoneNumber = customer_phoneNumber;
    }

    public String getCustomer_email() {
        return customer_email;
    }

    public void setCustomer_email(String customer_email) {
        this.customer_email = customer_email;
    }
}
