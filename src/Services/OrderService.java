package Services;

import DaoLayer.OrderDao;
import entities.Order;

import java.sql.Date;
import java.util.List;

public class OrderService {
    OrderDao orderDao = new OrderDao();

    public void createOrder(Order order) {
        orderDao.create(order);
    }

    public void deleteOrder(Order order) {
        order.setLifeCycle("deleted");
        orderDao.delete(order);
    }

    public List<Order> findAllOrders() {
        return orderDao.findAll();
    }

    public Order order(Integer id) {
        return orderDao.findById(id);
    }

    public List<Order> findByProduct(String product) {
        return orderDao.findByProduct(product);
    }

    public List<Order> findByCreating(Date date) {
        return orderDao.findByCreatingDate(date);
    }
}
