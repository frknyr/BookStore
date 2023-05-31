package core.abstracts;

import entities.concretes.Customer;

import java.util.List;

public interface ICustomerControlService {
    boolean controlName(Customer customer);

    boolean controlSurname(Customer customer);

    boolean controlMailFormat(Customer customer);

    boolean controlUsedMail(Customer customer, List<Customer> customers);

    boolean controlPhoneNumber(Customer customer);

    boolean controlCustomerId(int customer_id, List<Customer> customers);

    boolean controlCustomerUpdateMail(Customer customer, List<Customer> customers);


}
