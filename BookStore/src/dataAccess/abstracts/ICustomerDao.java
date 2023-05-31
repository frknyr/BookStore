package dataAccess.abstracts;

import entities.concretes.Customer;

import java.util.List;

public interface ICustomerDao {
    void add(Customer customer);

    void delete(int customer_id);

    void update(Customer customer);

    Customer get(int customer_id);

    List<Customer> getAll();


}
