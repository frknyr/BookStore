package business.abstracts;

import entities.concretes.Customer;
import java.sql.SQLException;
import java.util.List;

public interface ICustomerService {
    void add(Customer customer) ;

    void delete(int customer_id);

    void update(Customer customer);

    Customer get(int customer_id) ;

    List<Customer> getAll() throws SQLException;
}
