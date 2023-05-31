package dataAccess.concretes;

import dataAccess.abstracts.*;
import entities.concretes.Author;
import entities.concretes.Book;
import entities.concretes.Customer;
import entities.concretes.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDao implements IOrderDao {
    private IDbHelperDao dbHelperDao;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    Statement statement = null;
    ResultSet resultSet;
    IBookDao bookDao = new BookDao(new DbHelperDao());
    ICustomerDao customerDao = new CustomerDao(new DbHelperDao());
    IAuthorDao authorDao = new AuthorDao(new DbHelperDao());


    public OrderDao(IDbHelperDao dbHelperDao) {
        this.dbHelperDao = dbHelperDao;
    }

    @Override
    public void add(Order order) {
        Customer customer = customerDao.get(order.getCustomer_id());
        Book book = bookDao.get(order.getBook_id());
        Author author = authorDao.get(book.getAuthor_id());
        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        try {
            String sql = "INSERT INTO tbl_orders(customer_id,customer_nameSurname,author_id,author_nameSurname,book_id," +
                    " book_name,order_amount,order_unitPrice,order_totalPrice,order_date) VALUES (?,?,?,?,?,?,?,?,?,?)";
            connection = dbHelperDao.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, order.getCustomer_id());
            preparedStatement.setString(2, customer.getCustomer_name() + " " + customer.getCustomer_surname());
            preparedStatement.setInt(3, author.getAuthor_id());
            preparedStatement.setString(4, author.getAuthor_name() + " " + author.getAuthor_surname());
            preparedStatement.setInt(5, order.getBook_id());
            preparedStatement.setString(6, book.getBook_name());
            preparedStatement.setInt(7, order.getOrder_amount());
            preparedStatement.setDouble(8, book.getBook_price());
            preparedStatement.setDouble(9, book.getBook_price() * order.getOrder_amount());
            preparedStatement.setDate(10, sqlDate);

            int result = preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
        } catch (SQLException exception) {
            dbHelperDao.showErrorMessage(exception);
        }
    }

    @Override
    public void delete(int order_id) {
        try {
            String sql = "DELETE FROM tbl_orders WHERE order_id= ?";
            connection = dbHelperDao.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, order_id);
            int result = preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

        } catch (SQLException exception) {
            dbHelperDao.showErrorMessage(exception);
        }
    }

    @Override
    public void update(Order order) {
        Customer customer = customerDao.get(order.getCustomer_id());
        Book book = bookDao.get(order.getBook_id());
        Author author = authorDao.get(book.getAuthor_id());
        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        try {
            String sql = "UPDATE tbl_orders SET customer_id=?,customer_nameSurname=?,author_id=?,author_nameSurname=?," +
                    "book_id=?,book_name=?,order_amount=?,order_unitPrice=?,order_totalPrice=?,order_date=? " +
                    "WHERE order_id=?";
            connection = dbHelperDao.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, order.getCustomer_id());
            preparedStatement.setString(2, customer.getCustomer_name() + " " + customer.getCustomer_surname());
            preparedStatement.setInt(3, author.getAuthor_id());
            preparedStatement.setString(4, author.getAuthor_name() + " " + author.getAuthor_surname());
            preparedStatement.setInt(5, order.getBook_id());
            preparedStatement.setString(6, book.getBook_name());
            preparedStatement.setInt(7, order.getOrder_amount());
            preparedStatement.setDouble(8, book.getBook_price());
            preparedStatement.setDouble(9, book.getBook_price() * order.getOrder_amount());
            preparedStatement.setDate(10, sqlDate);
            preparedStatement.setInt(11, order.getOrder_id());

            int result = preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
        } catch (SQLException exception) {
            dbHelperDao.showErrorMessage(exception);
        }
    }

    @Override
    public Order get(int id) {
        for (Order order : getAll()) {
            if (order.getOrder_id() == id) {
                return order;
            }
        }
        return null;
    }

    @Override
    public List<Order> getAll() {
        List<Order> orders = new ArrayList<>();
        try {
            String sql = "SELECT * FROM tbl_orders";
            connection = dbHelperDao.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                orders.add(new Order(resultSet.getInt("order_id"), resultSet.getInt("customer_id"),
                        resultSet.getString("customer_nameSurname"), resultSet.getInt("author_id"),
                        resultSet.getString("author_nameSurname"), resultSet.getInt("book_id"),
                        resultSet.getString("book_name"), resultSet.getInt("order_amount"),
                        resultSet.getDouble("order_unitPrice"), resultSet.getDouble("order_totalPrice"),
                        resultSet.getDate("order_date")));
            }


        } catch (SQLException exception) {
            dbHelperDao.showErrorMessage(exception);
        }
        return orders;
    }
}
