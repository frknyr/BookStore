package dataAccess.abstracts;

import entities.concretes.Order;

import java.util.List;

public interface IOrderDao {
    void add(Order order);

    void delete(int order_id);

    void update(Order order);

    Order get(int id);

    List<Order> getAll();
}
