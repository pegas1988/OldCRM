package controller;

import entity.Order;
import service.OrderService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ShowListOfOrdersController implements Controller {
    private final String VIEW_NAME;
    OrderService orderService = new OrderService();

    public ShowListOfOrdersController(String VIEW_NAME) {
        this.VIEW_NAME = VIEW_NAME;
    }

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<Order> orderList;
        orderList = orderService.findAllOrders();
        req.setAttribute("orderList", orderList);
        return new ControllerResultDto(VIEW_NAME);
    }
}
