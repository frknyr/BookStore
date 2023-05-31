import business.abstracts.*;
import business.concretes.*;
import core.concretes.AuthorControlManager;
import core.concretes.BookControlManager;
import core.concretes.CategoryControlManager;
import core.concretes.CustomerControlManager;
import dataAccess.abstracts.IOrderDao;
import dataAccess.concretes.*;
import entities.concretes.*;


import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException {

        ICustomerService customerService = new CustomerManager(new CustomerDao(new DbHelperDao()), new CustomerControlManager());
        ICategoryService categoryService = new CategoryManager(new CategoryDao(new DbHelperDao()), new CategoryControlManager());
        IAuthorService authorService = new AuthorManager(new AuthorDao(new DbHelperDao()), new AuthorControlManager());
        IBookService bookService = new BookManager(new BookDao(new DbHelperDao()),new BookControlManager());
        IOrderService orderService = new OrderManager(new OrderDao(new DbHelperDao()));


        customerService.delete(1);









    }
}