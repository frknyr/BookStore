package business.concretes;

import business.abstracts.IOrderService;
import dataAccess.abstracts.IOrderDao;
import entities.concretes.Order;

import java.util.List;

public class OrderManager implements IOrderService {
    private IOrderDao orderDao;

    public OrderManager(IOrderDao orderDao) {
        this.orderDao = orderDao;
    }


    // Order için gereken kontrol sistemleri için çalışıyorum :)
    @Override
    public void add(Order order) {
        orderDao.add(order);
    }

    @Override
    public void delete(int order_id) {
        orderDao.delete(order_id);
    }

    @Override
    public void update(Order order) {
        orderDao.update(order);
    }

    @Override
    public Order get(int id) {
        return orderDao.get(id);
    }

    @Override
    public List<Order> getAll() {
        return orderDao.getAll();
    }
}
