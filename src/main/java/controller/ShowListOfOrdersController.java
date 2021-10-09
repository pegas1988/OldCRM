package controller;

import controller.constant.ControllerConstant;
import entity.Order;
import service.OrderService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ShowListOfOrdersController implements Controller {

    private final String VIEW_NAME;
    private OrderService orderService = new OrderService();

    ShowListOfOrdersController(String VIEW_NAME) {
        this.VIEW_NAME = VIEW_NAME;
    }

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) {
        List<Order> orderList;
        orderList = orderService.findAllOrders();
        req.setAttribute(ControllerConstant.CONTROLLER_ORDER_LIST, orderList);
        return new ControllerResultDto(VIEW_NAME);
    }
}
