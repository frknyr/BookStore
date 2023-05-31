package dataAccess.concretes;

import dataAccess.abstracts.ICustomerDao;
import dataAccess.abstracts.IDbHelperDao;
import entities.concretes.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao implements ICustomerDao {
    IDbHelperDao dbHelper;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    Statement statement = null;
    ResultSet resultSet;

    public CustomerDao(IDbHelperDao dbHelper) {
        this.dbHelper = dbHelper;
    }

    @Override
    public void add(Customer customer) {
        try {
            String sql = "INSERT INTO TBL_CUSTOMERS(CUSTOMER_NAME,CUSTOMER_SURNAME,CUSTOMER_PHONENUMBER," +
                    "CUSTOMER_MAİL) VALUES(?,?,?,?)";
            connection = dbHelper.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, customer.getCustomer_name().toUpperCase());
            preparedStatement.setString(2, customer.getCustomer_surname().toUpperCase());
            preparedStatement.setString(3, customer.getCustomer_phoneNumber());
            preparedStatement.setString(4, customer.getCustomer_email());
            int result = preparedStatement.executeUpdate();


            preparedStatement.close();
            connection.close();

        } catch (SQLException exception) {
            dbHelper.showErrorMessage(exception);
        }
    }

    @Override
    public void delete(int customer_id) {
        try {
            String sql = "DELETE FROM TBL_CUSTOMERS WHERE customer_ıd=?";
            connection = dbHelper.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, customer_id);
            int result = preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
        } catch (SQLException exception) {
            dbHelper.showErrorMessage(exception);
        }
    }

    @Override
    public void update(Customer customer) {
        try {
            String sql = "UPDATE TBL_CUSTOMERS SET customer_name=?, customer_surname=?, customer_phoneNumber=?, customer_mail=?" +
                    " WHERE customer_ıd=? ";
            connection = dbHelper.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, customer.getCustomer_name().toUpperCase());
            preparedStatement.setString(2, customer.getCustomer_surname().toUpperCase());
            preparedStatement.setString(3, customer.getCustomer_phoneNumber());
            preparedStatement.setString(4, customer.getCustomer_email());
            preparedStatement.setInt(5, customer.getCustomer_id());
            int result = preparedStatement.executeUpdate();


            preparedStatement.close();
            connection.close();

        } catch (SQLException exception) {
            dbHelper.showErrorMessage(exception);
        }
    }

    @Override
    public Customer get(int customer_id) {
        for (Customer customer : getAll()) {
            if (customer.getCustomer_id() == customer_id) {
                return customer;
            }
        }
        return null;
    }

    @Override
    public List<Customer> getAll() {
        List<Customer> customers = null;
        try {
            String sql = "SELECT * FROM TBL_CUSTOMERS";
            connection = dbHelper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            customers = new ArrayList<Customer>();
            while (resultSet.next()) {
                customers.add(new Customer(resultSet.getInt("customer_ıd"), resultSet.getString("customer_name"),
                        resultSet.getString("customer_surname"), resultSet.getString("customer_phoneNumber"),
                        resultSet.getString("customer_mail")));
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException exception) {
            dbHelper.showErrorMessage(exception);
        }

        return customers;
    }
}
